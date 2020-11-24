public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        int[] result = findTiltRecur(root);
        return result[0];
    }

    public int[] findTiltRecur(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }

        int[] left = findTiltRecur(node.left);
        int[] right = findTiltRecur(node.right);
        int sum = left[1] + node.val + right[1];
        int difference = left[0] + right[0] + Math.abs(left[1] - right[1]);
        int[] answer = new int[]{difference, sum};
        return answer;
    }
}
