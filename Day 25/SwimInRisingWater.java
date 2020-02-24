// Question link : https://leetcode.com/problems/swim-in-rising-water/

import java.util.*;

public class SwimInRisingWater {


    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        HashSet<SwimmerState> visited = new HashSet<>();
        int maxWaitTime = 0;

        SwimmerState start = new SwimmerState(0,0,grid[0][0]);
        SwimmerState end = new SwimmerState(row-1,column-1,grid[row-1][column-1]);

        PriorityQueue<SwimmerState> heap = new PriorityQueue<>(new GridComparator());
        heap.add(start);

        while (!heap.isEmpty()){
            SwimmerState current = heap.poll();
            maxWaitTime = Math.max(maxWaitTime, current.depth);

            if(current.equals(end)){
                break;
            }
            
            visited.add(current);
            ArrayList<SwimmerState> neighbourGrids = getNeighbours(current, grid);

            for (SwimmerState swimmerGrid: neighbourGrids) {
                if( !visited.contains(swimmerGrid) ) {
                    heap.add(swimmerGrid);
                }
            }

        }

        return maxWaitTime;

    }


    public ArrayList<SwimmerState> getNeighbours(SwimmerState swimmerGrid,  int[][] grid ){
        ArrayList<SwimmerState> neighbours = new ArrayList<>();

        // top
        if(swimmerGrid.x - 1 >= 0){
            SwimmerState topNeighbour = new SwimmerState(swimmerGrid.x-1, swimmerGrid.y,grid[swimmerGrid.x-1][swimmerGrid.y]);
            neighbours.add(topNeighbour);
        }

        // bottom
        if(swimmerGrid.x + 1 < grid.length){
            SwimmerState bottomNeighbour = new SwimmerState(swimmerGrid.x+1, swimmerGrid.y,grid[swimmerGrid.x+1][swimmerGrid.y]);
            neighbours.add(bottomNeighbour);
        }

        // left
        if(swimmerGrid.y - 1 >= 0){
            SwimmerState leftNeighbour = new SwimmerState(swimmerGrid.x, swimmerGrid.y-1,grid[swimmerGrid.x][swimmerGrid.y-1]);
            neighbours.add(leftNeighbour);
        }

        // right
        if(swimmerGrid.y + 1 < grid[0].length){
            SwimmerState rightNeighbour = new SwimmerState(swimmerGrid.x, swimmerGrid.y+1,grid[swimmerGrid.x][swimmerGrid.y+1]);
            neighbours.add(rightNeighbour);
        }
        return neighbours;
    }
}


class SwimmerState{

    int x;
    int y;
    int depth;

    public SwimmerState(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o){
        SwimmerState newObject = (SwimmerState) o;
        boolean equals = this.x == newObject.x && this.y == newObject.y;
        return equals;
    }

    @Override
    public int hashCode(){
        int hash = Objects.hash(x,y);
        return hash;
    }

}

class GridComparator implements Comparator<SwimmerState>{

    @Override
    public int compare(SwimmerState o1, SwimmerState o2) {
        if(o1.depth < o2.depth) return -1;
        if(o1.depth > o2.depth) return 1;
        return 0;
    }
}