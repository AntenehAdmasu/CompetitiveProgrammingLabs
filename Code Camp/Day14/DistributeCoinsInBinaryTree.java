// Question link : https://leetcode.com/contest/weekly-contest-120/problems/distribute-coins-in-binary-tree/

public class DistributeCoinsInBinaryTree {

    public int distributeCoins(TreeNode root) {
        return getReport(root)[1];
    }

    public int[] getReport(TreeNode root){

        if(root == null){
            return new int[] {0,0};
        }

        int[] leftReport = getReport(root.left);
        int[] rightReport = getReport(root.right);

        int totalCoin = leftReport[0] + rightReport[0] + (root.val -1);
        int totalMoves = leftReport[1] + rightReport[1] + Math.abs(totalCoin);

        return new int[]{totalCoin,totalMoves};
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