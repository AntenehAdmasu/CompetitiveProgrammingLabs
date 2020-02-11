// Question link : https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/submissions/

import java.util.ArrayList;

public class MaximumProductOfSplittedBinaryTree {


    public int maxProduct(TreeNode root) {

        ArrayList<Integer> allSums = new ArrayList<>();
        getSum(root, allSums);
        int len = allSums.size();
        int maxDifference = allSums.get(len - 1);
        int num1 = 0;
        int num2 = 0;

        for (int sum : allSums) {
            int difference = Math.abs((allSums.get(len - 1) - sum) - sum);

            if (difference < maxDifference) {
                maxDifference = difference;
                num1 = allSums.get(len - 1) - sum;
                num2 = sum;
            }
        }

        Double d = ((double) num1 * (double) num2) % (1000000007);
        Integer result = d.intValue();
        return result;
    }

    public int getSum(TreeNode root, ArrayList<Integer> sums) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) return 0;

        int left = getSum(root.left, sums);
        int right = getSum(root.right, sums);

        int self = root.val;
        self += left;
        self += right;
        sums.add(self);
        return self;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}