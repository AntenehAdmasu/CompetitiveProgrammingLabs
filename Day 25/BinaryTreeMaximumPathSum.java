// Question link : https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class BinaryTreeMaximumPathSum {

    public int maximumPathSum(TreeNode root, MaximumSumTracker max){
        if(root == null){
            return 0;
        }

        int fromLeft = maximumPathSum(root.left, max);
        int fromRight = maximumPathSum(root.right, max);

        int sumIncludingBothSides = fromLeft + fromRight + root.val;
        max.maxSum = Math.max(max.maxSum, sumIncludingBothSides);

        int oneSideAndSelf = Math.max(fromLeft, fromRight) + root.val;
        max.maxSum = Math.max(max.maxSum, oneSideAndSelf);
        max.maxSum = Math.max(max.maxSum, root.val);

        return Math.max(oneSideAndSelf, root.val);

    }

}


class MaximumSumTracker{
    int maxSum;
    public MaximumSumTracker(int value){
        this.maxSum = value;
    }
}