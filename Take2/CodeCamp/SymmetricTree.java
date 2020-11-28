public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSubTrees(root.left, root.right);
    }

    public boolean checkSubTrees(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null) || leftNode.val != rightNode.val) {
            return false;
        }

        boolean isSymmetric = true;
        isSymmetric &= checkSubTrees(leftNode.left, rightNode.right);
        isSymmetric &= checkSubTrees(leftNode.right, rightNode.left);

        return isSymmetric;
    }

}
