// Question link : https://leetcode.com/problems/first-missing-positive/

public class FirstMissingElement {

    
    public int firstMissingPositive(int[] nums) {

        int length = nums.length;
        boolean oneFound = false;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                oneFound = true;
            }
            if(nums[i] <= 0){
                nums[i] = 1;
            }
        }

        if(!oneFound){
            return 1;
        }

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            if(nums[i] > length){
                continue;
            }
            if(nums[val -1] > 0){

                nums[val-1] = -1 * nums[val-1];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;

    }

}
