// Question link : https://leetcode.com/problems/making-a-large-island/

import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1},
                {0, 1}
        };
        System.out.println(new MakingALargeIsland().largestIsland(grid));

    }


    public int largestIsland(int[][] grid) {

        int maxIsland = 0;
        HashMap<Integer, Integer> landIdAreaMap = new HashMap<>();

        // Land id should start from 2 since 0 & 1 are already taken
        int id = 2;

        // Get all the original islands
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    getIsLandSize(i, j, grid, landIdAreaMap, id);
                    maxIsland = Math.max(maxIsland, landIdAreaMap.get(id) );
                    id++;
                }
            }
        }

        // Checking new islands after changing each zero to one
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    int areaCount = 1;
                    HashSet<Integer> seenLands = new HashSet<>();
                    //top
                    if (i - 1 >= 0 && grid[i-1][j] != 0){
                        areaCount += landIdAreaMap.get(grid[i-1][j]);
                        seenLands.add(grid[i-1][j]);
                    }
                    // left
                    if(j - 1 >= 0 && grid[i][j-1] != 0 && !seenLands.contains(grid[i][j-1])){

                        areaCount += landIdAreaMap.get(grid[i][j-1]);
                        seenLands.add(grid[i][j-1]);
                    }
                    //bottom
                    if(i+1 < grid.length && grid[i+1][j] != 0 && !seenLands.contains(grid[i+1][j])){
                        areaCount += landIdAreaMap.get(grid[i+1][j]);
                        seenLands.add(grid[i+1][j]);
                    }
                    // right
                    if(j+1 < grid[0].length && grid[i][j+1] != 0 && !seenLands.contains(grid[i][j+1])){
                        areaCount += landIdAreaMap.get(grid[i][j+1]);
                    }
                    maxIsland = Math.max(maxIsland, areaCount);

                }
            }
        }
        return maxIsland;
    }

    private void getIsLandSize(int i, int j, int[][] grid, HashMap<Integer, Integer> landIdAreaMap, int landId) {
        landIdAreaMap.put(landId, landIdAreaMap.containsKey(landId) ? landIdAreaMap.get(landId) + 1 : 1);
        grid[i][j] = landId;

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            getIsLandSize(i - 1, j, grid, landIdAreaMap, landId);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            getIsLandSize(i, j - 1, grid, landIdAreaMap, landId);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            getIsLandSize(i + 1, j, grid, landIdAreaMap, landId);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            getIsLandSize(i, j + 1, grid, landIdAreaMap, landId);
        }
    }


}
