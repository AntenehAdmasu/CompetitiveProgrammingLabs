// Question : https://leetcode.com/problems/find-bottom-left-tree-value/

public class BottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        System.out.println("Val is " + new BottomLeftTreeValue().findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root){
        int val = getBottomLeftValue(root,0)[0];
        return val;

    }

    private int[] getBottomLeftValue(TreeNode root,int levelCounter) {

        levelCounter++;

        if(root.left == null & root.right == null){
            return new int[]{levelCounter, root.val};
        }

        int[] leftResult = null;
        int[] rightResult = null;

        if(root.left != null) leftResult = getBottomLeftValue(root.left, levelCounter);
        
        if(root.right != null) rightResult = getBottomLeftValue(root.right, levelCounter);

        if(leftResult == null) return rightResult;
        
        if(rightResult == null) return leftResult;
        
        if(leftResult[0] < rightResult[0]){
            return rightResult;
        }else{
            return leftResult;
        }


    }
}
