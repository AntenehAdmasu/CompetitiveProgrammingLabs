import java.util.Stack;

public class BTSIterator {
    Stack<Integer> stack;
    public BTSIterator(TreeNode root) {
        stack = new Stack<>();
        constructStack(root, stack);
    }

    public void constructStack(TreeNode node, Stack<Integer> stack){
        if(node == null){
            return;
        }
        constructStack(node.right, stack);
        stack.add(node.val);
        constructStack(node.left, stack);
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
