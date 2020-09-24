import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        if (root == null) {
            return result;
        }
        checkPath(root, result, elements, 0, sum);
        return result;
    }

    public void checkPath(TreeNode node, List<List<Integer>> result, List<Integer> pathElements, int sum, int target) {

        sum += node.val;
        ArrayList<Integer> list = new ArrayList<>(pathElements);
        list.add(node.val);
        if (node.left != null) {
            checkPath(node.left, result, list, sum, target);
        }
        if (node.right != null) {
            checkPath(node.right, result, list, sum, target);
        }
        if (node.left == null && node.right == null) {
            if (sum == target) {
                result.add(list);
                return;
            }
        }

    }

}
