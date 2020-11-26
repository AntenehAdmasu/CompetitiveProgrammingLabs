import java.util.ArrayList;
import java.util.HashMap;

public class MaximumBinaryTreeWidth {
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> widths = new HashMap<>();
        findWidth(root, widths, 1, 1);
        int maxWidth = 1;
        for(int level: widths.keySet()){
            ArrayList<Integer> values = widths.get(level);
            maxWidth = Math.max(Math.abs(values.get(0) - values.get(1)) + 1, maxWidth);
        }
        return maxWidth;
    }

    public void findWidth(TreeNode node, HashMap<Integer, ArrayList<Integer>> widths, int height, int xpos){
        if(node == null){
            return;
        }
        ArrayList<Integer> widthAtHeight;
        widthAtHeight = new ArrayList<>();
        if(widths.containsKey(height)){
            ArrayList<Integer> existingWidth = widths.get(height);
            widthAtHeight.add(Math.min(existingWidth.get(0), xpos));
            widthAtHeight.add(Math.max(existingWidth.get(1), xpos ));
        }else {
            widthAtHeight.add(xpos);
            widthAtHeight.add(xpos);
        }
        widths.put(height, widthAtHeight);
        findWidth(node.left, widths, height + 1, (xpos * 2) - 1);
        findWidth(node.right, widths, height + 1, (xpos * 2));

    }


}
