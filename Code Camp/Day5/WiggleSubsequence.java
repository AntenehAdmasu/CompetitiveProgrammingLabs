// Question link :https://leetcode.com/problems/wiggle-subsequence/

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        int increase = 1;
        int decrease = 1;
        for(int i = 1; i < nums.length; i++){

            if(nums[i] > nums[i-1]){
                decrease = increase + 1;
            }
            if(nums[i] < nums[i-1]){
                increase = decrease + 1;
            }
        }

        return Math.max(increase, decrease);
    }

}
