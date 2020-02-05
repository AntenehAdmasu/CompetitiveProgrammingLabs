// Question link : https://leetcode.com/problems/maximum-subarray/

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] test = new int[]{-2,6,-3,7,-4,3};
        System.out.println(new MaximumSubarray().maxSubArray(test));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE * -1;
        int prev = nums[0];
        int max = prev;

        for (int i = 1; i < nums.length ; i++) {
            // Override the prev if the prev + the value at array is less than the value at array else add it upon the accumulated prev
            prev += (prev + nums[i] < nums[i]) ? -prev + nums[i] : nums[i];
            max = Math.max(prev, max);
        }
        return max;
    }
}
