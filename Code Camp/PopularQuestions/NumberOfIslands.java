// Question link : https://leetcode.com/problems/number-of-islands/

import java.util.HashSet;

public class NumberOfIslands {


    public int numIslands(char[][] grid) {
        int islandCounter = 0;
        HashSet<String> visited = new HashSet<>();
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                String cell = row + "," + column;
                if(!visited.contains(cell) && grid[row][column] == '1'){
                    isIsland(row, column, grid, visited);
                    islandCounter++;
                }
            }
        }
        return islandCounter;
    }

    public void isIsland(int row, int column, char[][] grid, HashSet<String> visited){
        String cell = row + "," + column;
        visited.add(cell);
        if(row - 1 >= 0 && grid[row-1][column] == '1' && !visited.contains((row-1)+","+column)){
            isIsland(row-1,column,grid, visited);
        }

        if(row + 1 < grid.length && grid[row+1][column] == '1' && !visited.contains((row+1)+","+column)){
            isIsland(row+1,column,grid, visited);
        }

        if(column - 1 >= 0 && grid[row][column-1] == '1' && !visited.contains(row+","+(column-1))){
            isIsland(row,column-1,grid, visited);
        }

        if(column + 1 < grid[0].length && grid[row][column+1] == '1'  && !visited.contains(row+","+(column+1))){
            isIsland(row,column+1,grid, visited);
        }
    }
}
