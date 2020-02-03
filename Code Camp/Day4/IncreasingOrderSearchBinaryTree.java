// Question link : https://leetcode.com/problems/increasing-order-search-tree/

import java.util.ArrayList;
import java.util.Stack;

public class Increasing {

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> nodes = getAllNodes(root);

        TreeNode newRoot = constructTree(nodes);
        return newRoot;
    }

    private ArrayList<TreeNode> getAllNodes(TreeNode root) {
        ArrayList<TreeNode> allBelow = new ArrayList<>();
        ArrayList<TreeNode> left;
        ArrayList<TreeNode> right;

        if (root.left == null & root.right == null) {
            allBelow.add(new TreeNode(root.val));
            return allBelow;
        }
        if (root.left != null) {
            left = getAllNodes(root.left);
            allBelow.addAll(left);
        }
        allBelow.add(new TreeNode(root.val));
        if (root.right != null) {
            right = getAllNodes(root.right);
            allBelow.addAll(right);
        }
        return allBelow;

    }

    private TreeNode constructTree(ArrayList<TreeNode> allNodes) {
        TreeNode handler = allNodes.get(0);
        for (int i = 0; i < allNodes.size()-1 ; i++) {
            allNodes.get(i).right = allNodes.get(i+1);
        }
        return handler;
    }
}

