import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumTimeToCollectApples {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int travelTime = 0;
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] arr : edges) {
            ArrayList<Integer> dest1 = adjList.containsKey(arr[0]) ? adjList.get(arr[0]) : new ArrayList<>();
            ArrayList<Integer> dest2 = adjList.containsKey(arr[1]) ? adjList.get(arr[1]) : new ArrayList<>();
            dest1.add(arr[1]);
            dest2.add(arr[0]);
            adjList.put(arr[0], dest1);
            adjList.put(arr[1], dest2);
        }
        travelTime += getApplesRecur(0, adjList, hasApple,visited);
        return Math.max(0,travelTime - 2);

    }

    public int getApplesRecur(int node, HashMap<Integer, ArrayList<Integer>> adjList, List<Boolean> hasApple, HashSet<Integer> visited) {
        int time = 2;
        visited.add(node);
        ArrayList<Integer> children = adjList.containsKey(node) ? adjList.get(node) : null;
        if(children != null){
            for (int child: children) {
                if (!visited.contains(child)) {
                    time += getApplesRecur(child, adjList, hasApple, visited);
                }
            }
        }
        if(time == 2 && !hasApple.get(node)){
            time -= 2;
        }
        return time;
    }
}
