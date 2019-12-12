import java.util.Arrays;

public class ConstructBSTFromPreorder {


    public TreeNode bstFromPreorder(int[] preorder) {
        int len  = preorder.length;
        if(len == 0) return null;
        if(len == 1){
            return new TreeNode(preorder[0]);

        }
        TreeNode node = new TreeNode(preorder[0]);
        TreeNode leftnode = null;
        TreeNode rightnode = null;

        int[] leftarray = null;
        int[] rightarray = null;

        int max = 0;

        for (int i = 0; i < len; i++) {
            if(preorder[i] > max){
                max = i;
                break;
            }
        }
        if(max != 0){
            leftarray = Arrays.copyOfRange( preorder, 1, max);
            rightarray = Arrays.copyOfRange( preorder, max, len);
            if(leftarray.length != 0){

                leftnode = bstFromPreorder(leftarray);

                node.left = leftnode;
            }
            if(rightarray.length != 0 ){
                rightnode = bstFromPreorder(rightarray);
                node.right = rightnode;

            }

        }else{

            max = len - 1;
            int[] leftArray = Arrays.copyOfRange( preorder, 1, max);
            node.left = bstFromPreorder(leftArray);

        }

        return node;
    }
}
