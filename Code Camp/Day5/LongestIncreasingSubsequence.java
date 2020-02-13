// Question link : https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.ArrayList;
import java.util.HashMap;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] test = new int[]{2,2,2,2,2};
        System.out.println("=>>>>>> " + new LongestIncreasingSubsequence().findNumberOfLIS(test));
    }

    public int findNumberOfLIS(int[] nums) {

        int len = nums.length;
        HashMap<Integer, ArrayList<Integer>> storedValues = new HashMap<>();

        for (int i = len-1; i >= 0 ; i--) {

            int max = 0;
            int vals = 0;

            for (int j = i; j < len; j++) {

                if(nums[i] < nums[j]){
                    int stored = storedValues.containsKey(j) ? storedValues.get(j).get(0) : Integer.MIN_VALUE;
                    if(stored >= max){
                        if (stored == max){
                            vals += storedValues.get(j).get(1);
                        }else{
                            max = storedValues.get(j).get(0);
                            vals = storedValues.get(j).get(1);
                        }
                    }
                }

            }

            ArrayList<Integer> values = new ArrayList<>();
            values.add(max+1);
            values.add(vals == 0 ? 1 : vals);
            storedValues.put(i, values);

        }

        int longestOccurrence = Integer.MIN_VALUE;
        int longestOccurrenceCounter = 0;

        for (int x: storedValues.keySet()) {

            if(storedValues.get(x).get(0) > longestOccurrence){
                longestOccurrence = storedValues.get(x).get(0);
                longestOccurrenceCounter = storedValues.get(x).get(1);
            }else if(storedValues.get(x).get(0) == longestOccurrence){
                longestOccurrenceCounter += storedValues.get(x).get(1);
            }

        }

        return longestOccurrenceCounter;

    }
}
