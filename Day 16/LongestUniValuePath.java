// Question link : https://leetcode.com/problems/longest-univalue-path/

public class LongestUniValuePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);

        LengthTracker x = new LengthTracker(0);
        System.out.println(new LongestUniValuePath().longestUniValuePath(root, x));
        int lonpath = x.maxLength - 1;
        System.out.println("=> " + lonpath);
    }

    private int longestUniValuePath(TreeNode root, LengthTracker length) {

        if(root == null){
            return 0;
        }

        int resultFromLeft = longestUniValuePath(root.left, length);
        int resultFromRight = longestUniValuePath(root.right, length);
        int len;
        if(root.left == null || root.right == null){

            if(root.left == null && root.right == null){
                length.maxLength = Math.max(length.maxLength, 1);
                return 1;
            }

            if(root.right == null){
                if(root.val == root.left.val){
                    len = 1 + resultFromLeft;
                    length.maxLength = Math.max(length.maxLength, len);
                    return len;
                }
                return 1;
            }

            if(root.left == null){
                if(root.val == root.right.val){
                    len = 1 + resultFromRight;
                    length.maxLength = Math.max(length.maxLength, len);
                    return len;
                }
                return 1;
            }

        }else{
            if(root.val == root.left.val && root.val == root.right.val){
                len = resultFromLeft + resultFromRight + 1;
                length.maxLength = Math.max(length.maxLength, len);
                return Math.max(resultFromLeft + 1, resultFromRight+1);

            }else if(root.val == root.right.val){
                len = resultFromRight + 1;
                length.maxLength = Math.max(length.maxLength, len);
                return len;

            }else if(root.val == root.left.val){
                len = resultFromLeft + 1;
                length.maxLength = Math.max(length.maxLength, len);
                return len;

            }

        }

        length.maxLength = Math.max(length.maxLength, 1);
        return 1;
    }

}































class LengthTracker{
    int maxLength;
    public LengthTracker(int val){
        this.maxLength = val;
    }
}