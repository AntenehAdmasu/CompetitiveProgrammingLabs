public class BottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
//        root.left = new TreeNode(2);

        System.out.println("Val is " + new BottomLeftTreeValue().findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root){
        int val = getBottomLeftValue(root,0)[0];
        return val;

    }

    private int[] getBottomLeftValue(TreeNode root,int levelCounter) {
        levelCounter++;
        System.out.println();
        System.out.println("I am " + root.val);
        if(root.left == null & root.right == null){
            System.out.println("Returning my self " + root.val + " " + (levelCounter));
            return new int[]{levelCounter + 1, root.val};
        }

        int[] leftResult = null;
        int[] rightResult = null;

        if(root.left != null){
            leftResult = getBottomLeftValue(root.left, levelCounter);
        }
        if(root.right != null){
            rightResult = getBottomLeftValue(root.right, levelCounter);
        }
        if(leftResult == null){
            System.out.println(root.val + " returning from right val: " + rightResult[1]);
            return rightResult;
        }
        if(rightResult == null){
            System.out.println(root.val + " returning from left val: " + leftResult[1]);
            return leftResult;
        }
        if(leftResult[0] < rightResult[0]){
            return rightResult;
        }else{
            return leftResult;
        }


    }
}
