// Question link : https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

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
            answer.get(current.level).add(current.node.val);

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

class NodeLevelPair{
    int level;
    TreeNode node;

    public NodeLevelPair(TreeNode root, int level){
        this.level = level;
        this.node = root;
    }
}

