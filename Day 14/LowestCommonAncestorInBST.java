// Question : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class LowestCommonAncestorInBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        int larger = p.val > q.val ? p.val : q.val;
        int smaller = p.val < q.val ? p.val : q.val;
        
        if(p.val == root.val || q.val == root.val){
            return root;
        }
        
        if(smaller < root.val && larger > root.val){
            return root;
        }else if(smaller < root.val && larger < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
        

    }


}
