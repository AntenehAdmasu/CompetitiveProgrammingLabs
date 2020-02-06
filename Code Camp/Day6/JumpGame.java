// Question link : https://leetcode.com/contest/weekly-contest-174/problems/jump-game-v/

import java.util.ArrayList;
import java.util.HashMap;

public class JumpGame {
    public static void main(String[] args) {
        int[] test = new int[]{6,6,14,6,8,13,9,7,10,6,12};
        new JumpGame().maxJumps(test,2);

    }

    public int maxJumps(int[] arr, int d) {
        HashMap<Integer, ArrayList<Integer>> leftMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> rightMap = new HashMap<>();
        int[] mem = new int[arr.length];

        ConstructMoveMaps(arr, leftMap, rightMap, d);

        int maxMoves = 0;
        for (int i = 0; i < arr.length; i++) {
            int move = getMaxMoves(i, mem, leftMap, rightMap);
            maxMoves = Math.max(maxMoves, move);
        }
        return maxMoves;

    }

    private int getMaxMoves(int i, int[] mem, HashMap<Integer, ArrayList<Integer>> leftMap, HashMap<Integer, ArrayList<Integer>> rightMap) {
        if(leftMap.get(i).size() == 0 && rightMap.get(i).size() == 0){
            mem[i] = 1;
            return 1;
        }else{
            if(mem[i] != 0) return mem[i];
            int maxFromHere = 0;
            for (int l: leftMap.get(i)) {
                int move = getMaxMoves(l, mem, leftMap, rightMap);
                maxFromHere = Math.max(maxFromHere, move);
            }
            for (int r: rightMap.get(i)) {
                int move = getMaxMoves(r, mem, leftMap, rightMap);
                maxFromHere = Math.max(maxFromHere, move);
            }
            mem[i] = maxFromHere + 1;
            return mem[i];
        }
    }


    public void ConstructMoveMaps(int[] arr, HashMap<Integer, ArrayList<Integer>> leftMap, HashMap<Integer, ArrayList<Integer>> rightMap, int d) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {

            ArrayList<Integer> leftMoves = new ArrayList<>();
            ArrayList<Integer> rightMoves = new ArrayList<>();

            int j = i-1;
            int maxLeft = 0;
            int maxRight = 0;

            while (j >= i - d && j >= 0) {
                if(arr[j] >= arr[i]) break;
                if (arr[j] <= arr[i] && arr[j] >= maxLeft) {
                    if (arr[j] > maxLeft) {
                        leftMoves.clear();
                        leftMoves.add(j);
                        maxLeft = arr[j];
                        j--;
                        continue;
                    }
                    leftMoves.add(j);
                }
                j--;
            }
            leftMap.put(i, leftMoves);

            int k = i + 1;
            while (k <= i + d && k < len) {
                if(arr[k] >= arr[i]) break;
                if (arr[k] <= arr[i] && arr[k] >= maxRight) {
                    if (arr[k] > maxRight) {
                        rightMoves.clear();
                        rightMoves.add(k);
                        maxRight = arr[k];
                        k++;
                        continue;
                    }
                    rightMoves.add(k);
                }
                k++;
            }
            rightMap.put(i, rightMoves);

        }
    }
}