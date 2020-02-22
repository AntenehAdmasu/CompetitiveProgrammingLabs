// Question link : https://leetcode.com/problems/single-number/

public class SingleNumber {
    public int singleNumber(int[] nums) {

        int res = 0;
        for(int num = 0; num < nums.length; num++){
            res ^= nums[num];
        }

        return res;
    }

}
