public class SameTree {

    public static void main(String[] args) {
        
    }
       
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode Pleft = null;
        TreeNode Qleft = null;
        TreeNode Pright = null;
        TreeNode Qright = null;

        if(p == null & q == null) return true;
        if((p == null & q != null) || (p != null & q == null)) return false;

        if(p.val != q.val) return false;
        
        Pleft = p.left == null ? null : p.left;
        Qleft = q.left == null ? null : q.left;

        Pright = p.right == null ? null : p.right;
        Qright = q.right == null ? null : q.right;
        
        boolean leftSide = isSameTree(Pleft,Qleft);
        boolean rightSide = isSameTree(Pright, Qright);

        return leftSide && rightSide;

    }

}
