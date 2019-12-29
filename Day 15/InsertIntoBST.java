// Question : https://leetcode.com/problems/insert-into-a-binary-search-tree/

import java.time.temporal.Temporal;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if(root.val > val){
            leftNode = insertIntoBST(root.left, val);
            root.left = leftNode;
        }else{
            rightNode = insertIntoBST(root.right, val);
            root.right = rightNode;
        }

        return root;
    }
}
