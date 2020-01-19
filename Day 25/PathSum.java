// Question : https://leetcode.com/problems/path-sum/

import java.util.HashSet;
import java.util.Stack;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> nodes = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();

        int currentSum = root.val;
        nodes.add(root);
        while (!nodes.empty()){
            TreeNode node = nodes.peek();
            visited.add(node);
            if(currentSum > sum){
                currentSum -= node.val;
                nodes.pop();
                continue;
            }

            if (node.left == null && node.right == null){
                if(sum == currentSum){
                    return true;
                }
                currentSum -= node.val;
                nodes.pop();
            }else if(node.left != null && !visited.contains(node.left)){
                nodes.add(node.left);
                currentSum += node.left.val;

            }else if( node.right != null && !visited.contains(node.right)){
                nodes.add(node.right);
                currentSum += node.right.val;
            }else{
                currentSum -= node.val;
                nodes.pop();
            }

        }
        return false;
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
