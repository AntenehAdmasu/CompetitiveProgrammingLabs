// Question link : https://leetcode.com/problems/most-frequent-subtree-sum/

import java.util.HashMap;

public class FrequentTreeSum {

    public static HashMap<Integer, Integer> sumoccurrence = new HashMap<>();
    static int maxoccurrence = 0;
    static int possibleResults = 0;

    public static int[] findFrequentTreeSum(TreeNode root) {
        traverseAndFindSums(root);
        int[] results = new int[possibleResults];
        int counter = 0;
        for (int x: sumoccurrence.keySet()) {
            if(sumoccurrence.get(x) == maxoccurrence){
                results[counter] = x;
                counter++;
            }
        }
        return results;
    }

    public static int traverseAndFindSums(TreeNode root){

        int right = 0;
        int left = 0;

        if(root.left != null) left = traverseAndFindSums(root.left);
        if(root.right != null) right = traverseAndFindSums(root.right);
        int sum = left + right + root.val;

        int occurrence = sumoccurrence.containsKey(sum)? sumoccurrence.get(sum) + 1 : 1;
        sumoccurrence.put(sum, occurrence );

        possibleResults += (occurrence == maxoccurrence) ? 1 : 0;
        possibleResults = (occurrence > maxoccurrence) ? 1 : possibleResults;
        maxoccurrence += (occurrence > maxoccurrence) ? 1 : 0;

        return sum;

    }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}