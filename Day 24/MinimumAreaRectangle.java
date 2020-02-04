// Question link : https://leetcode.com/problems/minimum-area-rectangle/

import java.util.HashMap;
import java.util.HashSet;

public class MinimumAreaRectangle {


    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> xCoordintePoints = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yCoordintePoints = new HashMap<>();

        constructXandYCoordinateLists(points, xCoordintePoints, yCoordintePoints);

        int minArea = Integer.MAX_VALUE;
        for (int x : xCoordintePoints.keySet()) {
            HashSet<String> visited = new HashSet<>();

            for (int y : xCoordintePoints.get(x)) {
                int point = y;
                for (int pair : xCoordintePoints.get(x)) {
                    String grid = "";
                    grid += (pair < point) ? "" + pair + point : "" + point + pair;
                    if (y != pair && !visited.contains(grid)) {
                        visited.add(grid);
                        int area = checkRectangle(x, point, pair, yCoordintePoints);
                        minArea = Math.min(area, minArea);
                    }
                }
            }
        }

        return minArea;
    }

    // Checks if a rectangle can be formed from the given line and returns the one with the smallest area
    private int checkRectangle(int xCoordinate, int point, int pair, HashMap<Integer, HashSet<Integer>> yCoordintePoints) {

        int minArea = Integer.MAX_VALUE;
        for (int x: yCoordintePoints.get(point)) {
            if(x == xCoordinate) continue;
            if(yCoordintePoints.get(pair).contains(x)){
                int area = Math.abs(point - pair) * Math.abs(x- xCoordinate);
                minArea = Math.min(area, minArea);
            }
        }
        return minArea;
    }

    // Constructs a map of possible row and column coordinate for every point
    private void constructXandYCoordinateLists(int[][] points, HashMap<Integer, HashSet<Integer>> xCoordintePoints, HashMap<Integer, HashSet<Integer>> yCoordintePoints) {

        for (int[] point : points) {
            HashSet<Integer> xPoints = (xCoordintePoints.containsKey(point[0])) ? xCoordintePoints.get(point[0]) : new HashSet<>();
            xPoints.add(point[1]);
            xCoordintePoints.put(point[0], xPoints);

            HashSet<Integer> yPoints = (yCoordintePoints.containsKey(point[1])) ? yCoordintePoints.get(point[1]) : new HashSet<>();
            yPoints.add(point[0]);
            yCoordintePoints.put(point[1], yPoints);

        }


    }
}
