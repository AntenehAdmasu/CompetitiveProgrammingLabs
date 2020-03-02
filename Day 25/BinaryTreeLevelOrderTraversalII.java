// Question link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<NodeLevelPair> queue = new LinkedList<>();

        if(root == null){
            return answer;
        }

        NodeLevelPair rootNode = new NodeLevelPair(root, 0);
        queue.push(rootNode);

        while(!queue.isEmpty()){
            NodeLevelPair current = queue.pop();
            List<Integer> valsAtLevel = answer.size() > current.level ? answer.get(current.level) : new ArrayList<>();
            valsAtLevel.add(current.node.val);
            if(answer.size() <= current.level){
                answer.add(valsAtLevel);
            }

            if(current.node.left != null){
                NodeLevelPair leftNode = new NodeLevelPair(current.node.left, current.level + 1);
                queue.add(leftNode);
            }

            if(current.node.right != null){
                NodeLevelPair rightNode = new NodeLevelPair(current.node.right, current.level + 1);
                queue.add(rightNode);
            }

        }

        return answer;

    }
}
