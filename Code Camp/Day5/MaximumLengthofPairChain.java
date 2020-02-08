// Question link : https://leetcode.com/problems/maximum-length-of-pair-chain/

public class MaximumLengthofPairChain {


    public int findLongestChain(int[][] Pairs) {

        int[][] pairs = sort(Pairs);
        pairs[0][0] = 1;
        int maxChain = 0;

        for (int i = 0; i < pairs.length ; i++) {
            int maxPrevChain = 0;
            int j = i-1;
            while (j >= 0){
                if(pairs[j][1] < pairs[i][0]){
                    maxPrevChain = Math.max(maxPrevChain, pairs[j][0]);
                }
                j--;
            }
            pairs[i][0] = maxPrevChain + 1;
            maxChain = Math.max(maxChain,pairs[i][0]);

        }
        return maxChain;
    }


    public static int[][] sort(int[][] nums) {

        int length = nums.length;
        int[][] left = new int[length / 2][2];
        int[][] right = new int[length - length / 2][2];

        if (length == 1) {
            return nums;
        } else {
            left = sort(Arrays.copyOfRange(nums, 0, length / 2));
            right = sort(Arrays.copyOfRange(nums, length / 2, length));
        }
        return merge(left, right);
    }


    public static int[][] merge(int[][] left, int[][] right) {

        int l = 0;
        int r = 0;
        int[][] mergedList = new int[left.length + right.length][3];
        int inserted = 0;

        while ((l < left.length) && (r < right.length)) {
            if (left[l][0] < right[r][0]) {
                mergedList[inserted] = left[l];
                l++;
            } else {
                mergedList[inserted] = right[r];
                r++;
            }
            inserted++;
        }
        // Filling the remaining slots
        if (l == left.length) {
            for (int i = r; i < right.length; i++) {
                mergedList[inserted] = right[i];
                inserted++;
            }
        } else {
            for (int i = l; i < left.length; i++) {
                mergedList[inserted] = left[i];
                inserted++;
            }
        }

        return mergedList;
    }
}
