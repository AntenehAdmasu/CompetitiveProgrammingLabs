public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode mergedRoot = null;

        if(t1 == null & t2 == null) return null;

        if(t1 != null & t2 == null){
            return t1;
        }else if(t1 == null & t2 != null){
            return t2;
        }else{
            mergedRoot = new TreeNode(t1.val + t2.val);
        }





        TreeNode t1left, t1right, t2left, t2right;

        t1left = t1.left == null ? null : t1.left;
        t1right = t1.right == null ? null : t1.right;

        t2left = t2.left == null ? null : t2.left;
        t2right = t2.right == null ? null : t2.right;

        mergedRoot.left = mergeTrees(t1left, t2left);
        mergedRoot.right = mergeTrees(t1right, t2right);

        return mergedRoot;
    }
}
