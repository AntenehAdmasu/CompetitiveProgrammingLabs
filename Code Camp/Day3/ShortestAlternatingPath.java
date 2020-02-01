// Question link : https://leetcode.com/problems/shortest-path-with-alternating-colors/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ShortestAlternatingPath {

    public static void main(String[] args) {
        int[][] re = new int[][]{
                {2, 2},
                {0, 1},
                {0, 3},
                {0, 0},
                {0, 4},
                {2, 1},
                {2, 0},
                {1, 4},
                {3, 4}
        };

        int[][] be = new int[][]{
                {1, 3},
                {0, 0},
                {0, 3},
                {4, 2},
                {1, 0}
        };

        int[] resultArray = new ShortestAlternatingPath().shortestAlternatingPaths(5, re, be);
        for (
                int x : resultArray) {
            System.out.println("=> " + x);
        }

    }


    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        HashMap<Integer, ArrayList<Integer>> redEdges = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> blueEdges = new HashMap<>();
        int[] resultArray = new int[n];

        // RED EDGES FROM EACH AVAILABLE NODE
        for (int i = 0; i < red_edges.length; i++) {
            if (redEdges.containsKey(red_edges[i][0])) {
                redEdges.get(red_edges[i][0]).add(red_edges[i][1]);
            } else {
                ArrayList<Integer> dest = new ArrayList<>();
                dest.add(red_edges[i][1]);
                redEdges.put(red_edges[i][0], dest);
            }
        }

        // BLUE EDGES FROM EACH AVAILABLE NODE
        for (int i = 0; i < blue_edges.length; i++) {
            if (blueEdges.containsKey(blue_edges[i][0])) {
                blueEdges.get(blue_edges[i][0]).add(blue_edges[i][1]);
            } else {
                ArrayList<Integer> dest = new ArrayList<>();
                dest.add(blue_edges[i][1]);
                blueEdges.put(blue_edges[i][0], dest);
            }
        }

        HashMap<State, Integer> distance = new HashMap<>();  // This is where I can keep the state
        LinkedList<State> queue = new LinkedList<>();
        State blueZero = new State(0, true);
        State redZero = new State(0, false);

        queue.add(redZero);
        queue.add(blueZero);

        distance.put(blueZero, 0);
        distance.put(redZero, 0);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // To find all the adjacent nodes from the given node
            ArrayList<Integer> adjacents = current.color == false ? blueEdges.get(current.node) : redEdges.get(current.node);

            for (int i = 0; adjacents != null && i < adjacents.size(); i++) {
                State neighbour = new State(adjacents.get(i), !current.color);          // Nodes with the other colors
                if (!distance.containsKey(neighbour)) {
                    queue.add(neighbour);
                    distance.put(neighbour, distance.get(current) + 1);
                }
            }
        }

        resultArray[0] = 0;

        // Filling the result array
        for (int i = 1; i < resultArray.length; i++) {

            int fromRed = distance.containsKey(new State(i, false)) ? distance.get(new State(i, false)) : -1;
            int fromBlue = distance.containsKey(new State(i, true)) ? distance.get(new State(i, true)) : -1;

            if (fromBlue != -1 && fromRed != -1) {
                resultArray[i] = Math.min(fromBlue, fromRed);
                continue;
            }
            resultArray[i] = Math.max(fromRed, fromBlue);
        }
        return resultArray;
    }

}


class State {

    int node;
    boolean color; // false for Red and true for blue

    public State(int n, boolean c) {
        node = n;
        color = c;
    }

    @Override
    public boolean equals(Object o) {
        State newState = (State) o;
        return this.node == newState.node && this.color == newState.color;
    }

    @Override
    public int hashCode() {
        if (color == false) {
            return node;
        } else {
            return node + 500;
        }
    }
}
