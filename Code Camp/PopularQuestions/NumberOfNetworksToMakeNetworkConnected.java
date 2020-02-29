// Question link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NumberOfNetworksToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int numberOfSubgraphs = 0;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int[] edge : connections) {

            ArrayList<Integer> neighbourFirst = adjList.containsKey(edge[0]) ? adjList.get(edge[0]) : new ArrayList<>();
            ArrayList<Integer> neighbourSecond = adjList.containsKey(edge[1]) ? adjList.get(edge[1]) : new ArrayList<>();

            neighbourFirst.add(edge[1]);
            neighbourSecond.add(edge[0]);

            adjList.put(edge[0], neighbourFirst);
            adjList.put(edge[1], neighbourSecond);

        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                traverseGraph(i, adjList, visited);
                numberOfSubgraphs++;
            }
        }
        return numberOfSubgraphs - 1;
    }

    public void traverseGraph(int i, HashMap<Integer, ArrayList<Integer>> adjList, HashSet<Integer> visited) {
        visited.add(i);
        if (!adjList.containsKey(i)) {
            return;
        }

        for (int neighbour : adjList.get(i)) {
            if (!visited.contains(neighbour)) {
                traverseGraph(neighbour, adjList, visited);
            }
        }
    }
}














