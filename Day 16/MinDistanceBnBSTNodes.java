// Question : https://leetcode.com/problems/minimum-distance-between-bst-nodes/

import java.util.ArrayList;
import java.util.Collections;

public class MinDistanceBnBSTNodes {
    
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> allNodes = minDiffInBST2(root);
        Collections.sort(allNodes);

        if(allNodes.size() == 1) return 0;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < allNodes.size() - 1; i++) {
            int difference = Math.abs(allNodes.get(i) - allNodes.get(i+1));
            if(difference < minDis){
                minDis = difference;
            }
        }
        return minDis;
    }


    public ArrayList<Integer> minDiffInBST2(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();

        output.add(root.val);
        if(root.left != null){
            ArrayList<Integer> leftNodes = minDiffInBST2(root.left);
            output.addAll(leftNodes);
        }
        if(root.right != null){
            ArrayList<Integer> rightNodes = minDiffInBST2(root.right);
            output.addAll(rightNodes);
        }
        return output;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}




