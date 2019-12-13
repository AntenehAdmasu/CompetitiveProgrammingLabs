import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromPostOrder {

    public static void main(String[] args) {

        TreeNode a  = new TreeNode(1);
        a.left = null;
        a.left = null;

        a.right = new TreeNode(2);
        a.right.left = new TreeNode(3);
        a.right.right = null;

        ArrayList<Integer> ans = new ArrayList<>();
        ans =(ArrayList<Integer>) new BinaryTreeFromPostOrder().postorderTraversal(a);
        System.out.println("Size is " + ans.size());
        for (int x: ans) {
            System.out.println("*" + x);
        }

    }
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList();

        List<Integer> leftNodes = null;
        List<Integer> rightNodes = null;

        List<Integer> output = new ArrayList<>();

        leftNodes = postorderTraversal(root.left);
        rightNodes = postorderTraversal(root.right);



        if(leftNodes.size() != 0){
            output.addAll(leftNodes);
        }
        if(rightNodes.size() != 0){
            output.addAll(rightNodes);
        }

        output.add(root.val);

        return output;

    }
}
