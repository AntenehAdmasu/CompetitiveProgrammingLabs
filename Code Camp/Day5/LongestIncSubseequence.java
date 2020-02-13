// Question link : https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncSubseequence {

    public static void main(String[] args) {
        int[] test = new int[]{10,9,2,5,3,7,101,18};

        System.out.println("=> " + new LongestIncSubseequence().lengthOfLIS(test));
    }


    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int[] arr = new int[nums.length];

        int longest = 0;

        for (int i = len-1; i >= 0 ; i--) {
            int max = 1;

            for (int j = i; j < len; j++) {

                if(nums[i] < nums[j]){
                    int stored = arr[j];
                    max = Math.max(max, stored+1);

                }
                arr[i] = max;
                longest = Math.max(arr[i], longest);

            }

        }

        return longest;

    }


}

