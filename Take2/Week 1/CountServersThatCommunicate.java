import java.util.HashMap;
import java.util.HashSet;

class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        HashMap<Integer, Integer> rowsMap = new HashMap<>();
        HashMap<Integer, Integer> colsMap = new HashMap<>();

        int communicatingServers = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1){
                    rowsMap.put(row, rowsMap.containsKey(row) ? rowsMap.get(row) + 1 : 1);
                    colsMap.put(column, colsMap.containsKey(column) ? colsMap.get(column) + 1 : 1);
                }
            }
        }

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1){
                    if((rowsMap.containsKey(row) && rowsMap.get(row) > 1) || (colsMap.containsKey(column) && colsMap.get(column) > 1)){
                        communicatingServers++;
                    }
                }
            }
        }
        return communicatingServers;
    }
}