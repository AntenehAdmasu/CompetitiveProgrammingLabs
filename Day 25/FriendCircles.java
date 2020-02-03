// Question link : https://leetcode.com/problems/friend-circles/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class FriendCircles {

    public static void main(String[] args) {
        int[][] M = new int[][]{
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1}
        };
        System.out.println(new FriendCircles().findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {

        int size = M.length;
        HashMap<Integer, ArrayList<Integer>> friendsList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int friendCirclesCount = 0;

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> friends = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1) {
                    friends.add(j);
                }
            }
            friendsList.put(i, friends);
        }

        for (int i = 0; i < size; i++) {
            if (!visited.contains(i)) {
                friendCirclesCount++;
                traverseThroughCircle(i, visited, friendsList);
            }
        }

        return friendCirclesCount;
    }

    private void traverseThroughCircle(int friend, HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> friendsList) {
        Stack<Integer> stack = new Stack<>();
        stack.push(friend);

        int i = 0;
        while (!stack.isEmpty() && i < 20) {
            int current = stack.pop();
            visited.add(current);
            ArrayList<Integer> friends = friendsList.get(current);
            for (int fr : friends) {
                if (!visited.contains(fr)) {
                    stack.add(fr);
                    visited.add(fr);
                }
            }

        }
    }
}



