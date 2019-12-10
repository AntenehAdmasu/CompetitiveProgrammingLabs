public class LowestCommonAncestorInBST {

    public static void main(String[] args) {

    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        if(root.val == p.val || root.val == q.val) return root;
        TreeNode leftResult = lowestCommonAncestor(leftNode, p,q);
        TreeNode rightResult = lowestCommonAncestor(rightNode, p,q);

        if (leftResult == null & rightResult == null){
            return null;
        }else if(leftResult != null & rightResult == null){
            return leftResult;
        }else if(leftResult == null & rightNode != null){
            return rightResult;
        }else{
            return root;
        }

    }


}
