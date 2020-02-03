// Question link : https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        tn.left.left = new TreeNode(8);
        new BinaryTreeRightSideView().rightSideView(tn);

    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        HashMap<Integer,Integer> ans = new HashMap<>();
        Stack<NodeState> stack = new Stack<>();
        HashSet<NodeState> visited = new HashSet<>();

        NodeState rootNode = new NodeState(root,0);
        stack.push(rootNode);
        visited.add(rootNode);

        while (!stack.isEmpty()){
            NodeState current = stack.pop();

            // If another node hasn't set it a distance at this level, this is the rightmost node on this level
            if(!ans.containsKey(current.distance)) ans.put(current.distance, current.treeNode.val);

            // Constructing the right and left nodestates from their parent
            NodeState rightNode = current.treeNode.right != null ? new NodeState(current.treeNode.right, current.distance + 1) : null;
            NodeState leftNode = current.treeNode.left != null ? new NodeState(current.treeNode.left, current.distance + 1) : null;

            // Pushed first to make it popped after rightNode
            if(leftNode != null){
                visited.add(leftNode);
                stack.push(leftNode);
            }

            // Pushed after leftNode to be popped first
            if(rightNode != null){
                visited.add(rightNode);
                stack.push(rightNode);
            }
        }

        // Filling the answer arraylist for each level
        int level = 0;
        while (ans.containsKey(level)){
            answer.add(ans.get(level));
            level++;
        }

        return answer;
    }
}


class NodeState {
      TreeNode treeNode;
      int distance;
      public NodeState(TreeNode n, int d){
          treeNode = n;
          distance = d;
      }

      @Override
      public boolean equals(Object o){
          return this.treeNode == ((NodeState) o).treeNode;
      }

      @Override
      public int hashCode(){
          return treeNode.hashCode();
      }

 }