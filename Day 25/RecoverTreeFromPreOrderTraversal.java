// Question link : https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

import java.util.Stack;

public class RecoverTreeFromPreOrderTraversal {


    public TreeNode recoverFromPreorder(String S) {
        if(S.length() == 0) return null;
        int index = 0;
        while (index < S.length() && S.charAt(index) != '-'){
            index++;
        }

        String rootVal = S.substring(0,index);
        int rootNodeValue = Integer.parseInt(rootVal);
        TreeNode root = new TreeNode(rootNodeValue);

        NodeLevelState rootState = new NodeLevelState(root, 0);
        Stack<NodeLevelState> stack = new Stack<>();
        stack.add(rootState);

        for (int i = index; i < S.length() ; i++) {
            int counter = i;
            while(S.charAt(counter) == '-'){
                counter++;
            }
            int level = counter - i;

            String nodeVal = "";
            while (counter < S.length() && S.charAt(counter) != '-'){
                nodeVal += S.charAt(counter);
                counter++;
            }

            int nodeValue = Integer.parseInt(nodeVal);

            TreeNode node = new TreeNode(nodeValue);
            NodeLevelState state = new NodeLevelState(node,level);

            while (stack.peek().level != level-1){
                stack.pop();
            }
            NodeLevelState current = stack.peek();

            if(current.level == level-1){
                if(current.node.left != null && current.node.right != null){
                    stack.pop();
                }else if(current.node.left == null){
                    current.node.left = node;
                }else{
                    current.node.right = node;
                }
            }
            stack.push(state);
            i = counter-1;
        }

        return root;
    }
}

class NodeLevelState{
    public TreeNode node;
    public int level;

    public NodeLevelState(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }

}
