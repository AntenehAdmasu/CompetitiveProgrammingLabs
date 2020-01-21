// Question : https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

public class SumOfEvenValuedGrandParents {

    public int sumEvenGrandparent(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;

        int leftSum = root.left == null ? 0 : getSum(root, root.left);
        int rightSum = root.right == null ? 0 : getSum(root, root.right);
        return leftSum + rightSum ;
    }

    public int getSum(TreeNode parent, TreeNode node){
        int sum = 0;
        int left = 0; int right = 0;

        if(parent.val % 2 == 0){
            sum += node.left != null ? node.left.val : 0;
            sum += node.right != null ? node.right.val : 0;
        }

        if(node.left != null) sum += getSum(node, node.left );
        if(node.right != null) sum += getSum(node, node.right);

        return sum;

    }
}

