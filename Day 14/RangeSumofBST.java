import javafx.scene.shape.TriangleMesh;

public class RangeSumofBST {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);

        t.left = a;  t.right = b;
        a.left = c;  a.right = d;
        b.left = e;  b.right = f;

        System.out.println("Sum is " + new RangeSumofBST().rangeSumBST(t,5,7));


    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        int sum = 0;
        int nodeval = ((root.val >= L) && (root.val <= R )) ? root.val : 0;
        sum+=nodeval;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null) sum += rangeSumBST(left, L, R);
        if(right != null) sum += rangeSumBST(right, L, R);

        return sum;

    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
