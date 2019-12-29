// Question : https://leetcode.com/problems/range-sum-of-bst/

import javafx.scene.shape.TriangleMesh;

public class RangeSumofBST {

    public int rangeSumBST(TreeNode root, int L, int R) {

        int sum = 0;
        int nodeval = ((root.val >= L) && (root.val <= R )) ? root.val : 0;
        sum += nodeval;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null) sum += rangeSumBST(left, L, R);
        if(right != null) sum += rangeSumBST(right, L, R);

        return sum;

    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
