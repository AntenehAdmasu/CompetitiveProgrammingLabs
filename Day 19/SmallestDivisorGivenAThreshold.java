// Question : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

public class SmallestDivisorGivenAThreshold {

    public static void main(String[] args) {
        int[] nums = new int[]{19};
        System.out.println("Max possible divisor " + smallestDivisor(nums, 5));

    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            max = (nums[i] > max) ? nums[i] : max;
        }
        return smallestDivisor(nums,threshold, 1,max,0);
    }

     public static int smallestDivisor(int[] nums, int threshold,int left, int right,int currentDivisor) {
        int currentdivisor = currentDivisor;
        if(right >= left){
            int middle = (left + right - 1) / 2 ;
            if(left == right) middle = left;

            if(getSumOfArray(nums,middle) <= threshold){
                currentDivisor = middle;
                return smallestDivisor(nums,threshold,left,middle-1,currentDivisor);
            }else{
                return smallestDivisor(nums,threshold,middle + 1,right,currentDivisor);
            }
        }

        return currentDivisor;
    }
    
    public static int getSumOfArray(int[] nums, int divisor){
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int q = nums[i] / divisor;
            total += (nums[i] == (nums[i] / divisor) * divisor) ? q : q + 1;
        }
        return total;
    }

    
}
