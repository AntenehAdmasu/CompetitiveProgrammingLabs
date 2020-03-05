// Question link :https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        int[][] numIndexArr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            int[] numPos = {nums[i], i};
            numIndexArr[i] = numPos;
        }
        Arrays.sort(numIndexArr, new TwoDArrayComparator());

        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int sum = numIndexArr[start][0] + numIndexArr[end][0];
            if(sum == target){
                return new int[]{numIndexArr[start][1], numIndexArr[end][1]};
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
        }
        return null;
    }
}

class TwoDArrayComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1 ,int[] o2){
        return o1[0] - o2[0];
    }
}