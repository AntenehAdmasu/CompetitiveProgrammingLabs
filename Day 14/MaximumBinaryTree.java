import java.util.Arrays;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] x = new int[]{4,2,6,5,7,8};
//        int[] y = Arrays.copyOfRange(x, 6, 6);

//        System.out.println("len is " + y.length);
//        for (int i = 0; i < y.length; i++) {
//            System.out.println(y[i]);
//        }

//        int max = 0;
//        for (int i = 0; i < x.length; i++) {
//            if(x[i] > x[max]){
//                max = i;
//            }
//        }
//
//        System.out.println("max is " + max);
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

        System.out.println("max is " + max);
        TreeNode root = new TreeNode(nums[max]);

        leftarray = Arrays.copyOfRange(nums, 0, max);
        rightarray = Arrays.copyOfRange(nums, max+1, len);

        System.out.println("left len " + leftarray.length);
        System.out.println("right len " + rightarray.length);

        for (int i = 0; i < leftarray.length; i++) {
            System.out.println("L " + leftarray[i]);
        }
        for (int i = 0; i < rightarray.length; i++) {
            System.out.println("R " + rightarray[i]);
        }

        root.left = constructMaximumBinaryTree(leftarray);
        root.right = constructMaximumBinaryTree(rightarray);

        return root;
    }
}
