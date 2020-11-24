public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] answer = robRecursively(root);
        return Math.max(answer[0], answer[1]);
    }

    public int[] robRecursively(TreeNode node){
        if(node == null){
            return new int[]{0, 0}; // {children, grandChildren} format
        }
        int[] left = robRecursively(node.left);
        int[] right = robRecursively(node.right);
        int maxFromChildren = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        int[] answer = new int[]{maxFromChildren, left[0] + right[0] + node.val };
        return answer;
    }
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

