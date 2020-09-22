import java.util.ArrayList;
import java.util.List;

public class LargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, 0, root);
        return result;
    }

    public void traverse(List<Integer> result, int level, TreeNode node){
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(node.val);
        }
        else{
            result.set(level, Math.max(result.get(level), node.val));
        }
        traverse(result, level + 1, node.left);
        traverse(result, level + 1, node.right);
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
