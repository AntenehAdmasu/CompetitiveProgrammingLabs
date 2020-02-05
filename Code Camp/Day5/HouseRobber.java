// Question link : https://leetcode.com/problems/house-robber/

public class HouseRobber {

    public static void main(String[] args) {
        int[] test2 = new int[]{2,7,9,3,1};
        System.out.println(new HouseRobber().rob(test2));

    }


    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        if(len == 3) return Math.max(nums[0] + nums[2], nums[1]);

        nums[2] += nums[0];
        int pointer1 = 3;

        while (pointer1 < len){
            nums[pointer1] += Math.max(nums[pointer1-2], nums[pointer1-3]);
            pointer1+= 1;
        }

        return Math.max(nums[len-1], nums[len-2]);

    }
}
