public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return traverse(root, 0);
    }

    public int traverse (TreeNode node, int level){
        if(node.left == null && node.right == null){
            return level;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(node.left != null){
            left = traverse(node.left, level + 1);
        }
        if(node.right != null){
            right = traverse(node.right, level + 1);
        }

        return Math.min(left, right);
    }
}
