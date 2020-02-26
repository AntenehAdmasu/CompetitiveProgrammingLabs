// Question link : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

import java.util.*;

class CityWithSmallestNumberOfNeighbours {

    public static void main(String[] args) {
        int n = 4;
        int threshold = 4;
        int[][] edges = {
                {0,1,3},
                {1,2,1},
                {1,3,4},
                {2,3,1}
        };
        new CityWithSmallestNumberOfNeighbours().findTheCity(n,edges,threshold);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // This adjacency contains sources as key , and weight and destination, wrapped as an object, as values
        HashMap<Integer, ArrayList<DestinationWeightPair>> adjList = getAdjacencyList(edges);

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                    continue;
                }
                matrix[i][j] = 100000;
            }
        }

        HashSet<Integer> visitedCities = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while (!stack.isEmpty()){
            int currentCity = stack.pop();
            if(visitedCities.contains(currentCity)){
                continue;
            }
            visitedCities.add(currentCity);

            if ( adjList.containsKey(currentCity)){
                for (DestinationWeightPair neighBourCity: adjList.get(currentCity)) {
                    int weight = neighBourCity.weight;
                    matrix[neighBourCity.dest][currentCity] = matrix[currentCity][neighBourCity.dest] = weight;
                    stack.add(neighBourCity.dest);
                }
            }
        }

        for (int k = 0; k < n ; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int leastCitiesIndex = -1;
        int citiesWithLeastNeighbours = n+1;

        for (int i = 0; i < matrix.length; i++) {
            int neighCount = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] <= distanceThreshold){
                    neighCount++;
                }
            }

            if(neighCount <= citiesWithLeastNeighbours){
                citiesWithLeastNeighbours = neighCount;
                leastCitiesIndex = i;
            }
        }

        return leastCitiesIndex;
    }

    private HashMap<Integer, ArrayList<DestinationWeightPair>> getAdjacencyList(int[][] edges) {
        HashMap<Integer, ArrayList<DestinationWeightPair>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            // From the source to the destination
            ArrayList<DestinationWeightPair> destWeight = adjList.containsKey(source) ? adjList.get(source) : new ArrayList<>();

            // From the destination to the source
            ArrayList<DestinationWeightPair> sourceWeight = adjList.containsKey(dest) ? adjList.get(dest) : new ArrayList<>();

            destWeight.add(new DestinationWeightPair(dest, weight));
            sourceWeight.add(new DestinationWeightPair(source, weight));

            adjList.put(source, destWeight);
            adjList.put(dest, sourceWeight);
        }
        return adjList;
    }

}


class DestinationWeightPair {
    int dest;
    int weight;

    public DestinationWeightPair(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return dest + " , " + weight;
    }
}