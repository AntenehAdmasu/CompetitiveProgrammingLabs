// Question link : https://leetcode.com/problems/validate-binary-search-tree/

import java.util.ArrayList;

public class ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> allNodes = new ArrayList<>();
        getAllNodes(root, allNodes);
        for (int i = 0; i < allNodes.size()-1 ; i++) {
            // If the preceding node is greater
            if(allNodes.get(i) >= allNodes.get(i+1)) return false;
        }
        return true;

    }

    public void getAllNodes(TreeNode root, ArrayList<Integer> allNodes) {
        if(root == null) return;
        getAllNodes(root.left,allNodes);
        allNodes.add(root.val);
        getAllNodes(root.right, allNodes);
    }

}
