// Question link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

import java.util.ArrayList;
import java.util.List;

public class AllElementsIntoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> all = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        getAll(root1, first);
        getAll(root2, second);

        int l = 0;
        int r = 0;
        while ((l < first.size()) && (r < second.size())) {
            if (first.get(l) < second.get(r)) {
                all.add(first.get(l));
                l++;
            } else {
                all.add(second.get(r));
                r++;
            }
        }
        if (l == first.size()) {
            for (int i = r; i < second.size(); i++) {
                all.add(second.get(i));
            }
        } else {
            for (int i = l; i < first.size(); i++) {
                all.add(first.get(i));
            }
        }

        return all;

    }

    public void getAll(TreeNode root, ArrayList<Integer> nums) {
        if (root == null) return;

        getAll(root.left, nums);
        nums.add(root.val);
        getAll(root.right, nums);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}