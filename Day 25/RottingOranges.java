// Question link : https://leetcode.com/problems/rotting-oranges/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class RottingOranges{
    public int orangesRotting(int[][] grid) {
        
        HashSet<Grid> visited = new HashSet<>();
        LinkedList<Grid> queue = new LinkedList<>();
        int maxDays = 0;
        int orangeCount = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                orangeCount += grid[i][j] != 0 ? 1 : 0;
                if(grid[i][j] == 2){
                    Grid rotOr = new Grid(i,j,0);
                    queue.add(rotOr);
                }
            }
            
        }
            
        while(!queue.isEmpty()){

            Grid current = queue.poll();
            visited.add(current);
            maxDays = Math.max(maxDays, current.days);

            //top
            if (current.x - 1 >= 0 && grid[current.x - 1][current.y] == 1 && !visited.contains(new Grid(current.x - 1, current.y, current.days + 1))) {
                Grid topCell = new Grid(current.x - 1, current.y, current.days + 1);
                queue.add(topCell);
                visited.add(topCell);
            }
            
            //bottom
            if (current.x + 1 < grid.length && grid[current.x + 1][current.y] == 1 && !visited.contains(new Grid(current.x + 1, current.y, current.days + 1))) {
                Grid bottomCell = new Grid(current.x + 1, current.y, current.days + 1);
                queue.add(bottomCell);
                visited.add(bottomCell);

            }
            
            //left
            if (current.y - 1 >= 0 && grid[current.x][current.y-1] == 1 && !visited.contains(new Grid(current.x, current.y-1, current.days + 1))) {
                Grid leftCell = new Grid(current.x, current.y - 1, current.days + 1);
                queue.add(leftCell);
                visited.add(leftCell);

            }
            
            //right
            if (current.y + 1 < grid[0].length && grid[current.x][current.y+1] == 1 && !visited.contains(new Grid(current.x, current.y+1, current.days + 1))) {
                Grid rightCell = new Grid(current.x, current.y + 1, current.days + 1);
                queue.add(rightCell);
                visited.add(rightCell);

            }

        }
            
        return orangeCount == visited.size() ? maxDays : -1;
        
    }
}


class Grid {

    int x;
    int y;
    int days;
    
    public Grid(int x, int y, int days) {
        this.x = x;
        this.y = y;
        this.days = days;
    }

    @Override
    public boolean equals(Object obj) {
        Grid newGrid = (Grid) obj;
        return this.x == newGrid.x && this.y == newGrid.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


