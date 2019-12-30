// Question : https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromPostOrder {

    
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList();

        List<Integer> leftNodes = null;
        List<Integer> rightNodes = null;
        List<Integer> output = new ArrayList<>();

        leftNodes = postorderTraversal(root.left);
        rightNodes = postorderTraversal(root.right);

        if(leftNodes.size() != 0) output.addAll(leftNodes);
        if(rightNodes.size() != 0) output.addAll(rightNodes);

        output.add(root.val);

        return output;
    }

}
