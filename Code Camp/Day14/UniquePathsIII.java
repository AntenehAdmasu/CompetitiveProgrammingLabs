// Question link : https://leetcode.com/contest/weekly-contest-120/problems/unique-paths-iii/

import java.util.ArrayList;

public class UniquePathsIII {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println("total paths " + new UniquePathsIII().uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {

        int zeroesCount = 0;
        int startI = 0;
        int startJ = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                int cellVal = grid[i][j];
                if(cellVal == 0){
                    zeroesCount++;
                }else if(cellVal == 1){
                    startI = i;
                    startJ = j;
                }
            }
        }

        PathCount totalPathsCount = new PathCount(0);
        dfsTraverse(startI, startJ, grid, zeroesCount+1,0, totalPathsCount);
        return totalPathsCount.pathCount;
    }

    private void dfsTraverse(int i, int j, int[][] grid, int zeroesCount, int distance, PathCount pathCount) {

        if (grid[i][j] == 2){
            if(distance == zeroesCount){
                pathCount.pathCount++;
            }
            return;
        }
        ArrayList<int[]> neighbours = getNeighbours(i,j,grid);
        if(neighbours == null) return;
        for (int[] neighbour: neighbours) {
            grid[i][j] = 3;
            dfsTraverse(neighbour[0], neighbour[1] ,grid, zeroesCount,distance+1,pathCount);
            grid[i][j] = 0;
        }
    }

    private ArrayList<int[]> getNeighbours(int i, int j, int[][] grid) {
        ArrayList<int[]> neighbours = new ArrayList<>();

        // left neighbour
        if(i-1 >= 0 && (grid[i-1][j] == 0  || grid[i-1][j] == 2)){
            neighbours.add(new int[]{i-1,j});
        }

        //right neighbour
        if(i+1 < grid.length && (grid[i+1][j] == 0  || grid[i+1][j] == 2)){
            neighbours.add(new int[]{i+1,j});
        }

        // top neighbour
        if(j-1 >= 0 && (grid[i][j-1] == 0 || grid[i][j-1] == 2)){
            neighbours.add(new int[]{i, j-1});
        }

        // bottom neighbour
        if(j+1 < grid[0].length && (grid[i][j+1] == 0 || grid[i][j+1] == 2)){
            neighbours.add(new int[]{i,j+1});
        }

        return neighbours;
    }


}

class PathCount{
    public int pathCount;

    public PathCount(int count){
        this.pathCount = count;
    }
}