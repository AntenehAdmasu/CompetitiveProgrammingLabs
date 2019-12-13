import java.time.temporal.Temporal;

public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode a  = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(7);

        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(3);

        new InsertIntoBST().insertIntoBST(a, 5);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if(root.val > val){
            leftNode = insertIntoBST(root.left, val);
            root.left = leftNode;
        }else{
            rightNode = insertIntoBST(root.right, val);
            root.right = rightNode;
        }

        return root;
    }
}
