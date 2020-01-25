// Question : https://leetcode.com/problems/two-city-scheduling/

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int[][] costDiff = new int[costs.length][2];
        int totalcost = 0;
        for (int i = 0; i < costs.length; i++) {
            costDiff[i] = new int[]{costs[i][0] - costs[i][1], i};
        }
        int[][] res = sort(costDiff);
        for (int i = 0; i < res.length; i++) {
            totalcost += (i < costs.length / 2) ? costs[res[i][1]][0] : costs[res[i][1]][1];
        }
        return totalcost;    }


    public int[][] sort(int[][] nums) {

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


    public int[][] merge(int[][] left, int[][] right) {

        int l = 0;
        int r = 0;
        int[][] mergedList = new int[left.length + right.length][2];
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
