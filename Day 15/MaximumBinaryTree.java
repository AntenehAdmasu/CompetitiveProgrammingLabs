import java.util.Arrays;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        new MaximumBinaryTree().constructMaximumBinaryTree(x);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if(len == 0) return null;
        if(len == 1) return new TreeNode(nums[0]);

        int[] leftarray = null;
        int[] rightarray = null;

        int max = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] > nums[max]){
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums[max]);

        leftarray = Arrays.copyOfRange(nums, 0, max);
        rightarray = Arrays.copyOfRange(nums, max+1, len);


        root.left = constructMaximumBinaryTree(leftarray);
        root.right = constructMaximumBinaryTree(rightarray);

        return root;
    }
}
