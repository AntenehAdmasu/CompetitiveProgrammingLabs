// Question link : https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int currentDistance = Integer.MAX_VALUE;
        int bestSum = 0;

        for(int p1 = 0; p1 < nums.length; p1 ++){

            int p2 = p1 + 1;
            int p3 = nums.length - 1;

            int sum;

            while(p2 < p3){
                sum = nums[p1] + nums[p2] + nums[p3];
                if(sum > target){
                    p3--;
                }else{
                    p2++;
                }
                if(Math.abs(sum - target) < currentDistance){
                    currentDistance = Math.abs(sum - target);
                    bestSum = sum;
                }
            }

        }

        return bestSum;

    }
}
