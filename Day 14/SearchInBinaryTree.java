public class SearchInBinaryTree {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode left = null;
        TreeNode right = null;
        if(root == null) return null;

        if(root.val == val) return root;

        if(root.left != null){
            left = searchBST(root.left, val);
        }

        if(root.right != null){
            right = searchBST(root.left, val);
        }

        if(left != null) return left;
        if (right != null) return right;
        return null;

    }
    }
