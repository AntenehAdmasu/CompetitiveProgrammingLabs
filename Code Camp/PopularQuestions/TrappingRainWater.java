// Question link : https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }

    public int trapWithExtraArray(int[] height) {

        int length = height.length;
        if(length == 0){
            return 0;
        }
        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];
        int currentLtoR = height[0];
        int currentRtoL = height[height.length-1];

        for (int i = 0; i < height.length; i++) {
            if (height[i] > currentLtoR) {
                currentLtoR = height[i];
            }
            if(height[length - 1 - i] > currentRtoL){
                currentRtoL = height[length - 1 - i];
            }
            leftToRight[i] = currentLtoR;
            rightToLeft[length-1-i] = currentRtoL;
        }

        int totalWater = 0;
        for (int i = 0; i < length ; i++) {
            int waterLevel = Math.min(leftToRight[i],rightToLeft[i]);
            totalWater += waterLevel - height[i];
        }

        return totalWater;

    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] < leftMax){
                    totalWater += leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if(height[right] < rightMax){
                    totalWater += rightMax - height[right];
                }else{
                    rightMax = height[right];
                }
                right--;
            }

        }
        return totalWater;

    }
}
