// Question link : https://leetcode.com/problems/rotting-oranges/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class RottingOranges{
    public int orangesRotting(int[][] grid) {

        ArrayList<OrangeGrid> rottenOranges = new ArrayList();
        HashSet<OrangeGrid> freshOrangesSeen = new HashSet<>();

        int freshOrangesCount = 0;


        int[][] arr = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                arr[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 2){
                    OrangeGrid rotOr = new OrangeGrid(i,j,0);
                    rottenOranges.add(rotOr);
                }else if(grid[i][j] == 1){
                    freshOrangesCount++;
                }
            }

        }

        for(OrangeGrid rotten: rottenOranges){
            LinkedList<OrangeGrid> queue = new LinkedList<>();
            HashSet<OrangeGrid> visited = new HashSet<>();
            queue.add(rotten);

            while(!queue.isEmpty()){

                OrangeGrid current = queue.poll();
                visited.add(current);

                ArrayList<OrangeGrid> freshNeighbours = getFreshNeighbours(current, grid);

                for(OrangeGrid neighbour: freshNeighbours){
                    if(visited.contains(neighbour)){
                        continue;
                    }
                    int daysTook = current.days + 1;
                    OrangeGrid newRotten = new OrangeGrid(neighbour.x, neighbour.y, daysTook);
                    queue.add(newRotten);
                    arr[neighbour.x][neighbour.y] = Math.min(arr[neighbour.x][neighbour.y], daysTook);
                    freshOrangesSeen.add(neighbour);

                }

            }

        }
        if(freshOrangesSeen.size() < freshOrangesCount){
            System.out.println(freshOrangesSeen.size() + " : " + freshOrangesCount);
            return -1;
        }

        int maxDays = 0;
        for(int[] row: arr){
            for(int x: row){
                if(x == Integer.MAX_VALUE) continue;
                maxDays = Math.max(maxDays, x);
            }
        }
        return maxDays;



    }


    public ArrayList<OrangeGrid> getFreshNeighbours(OrangeGrid cell, int[][] matrix){

        ArrayList<OrangeGrid> neighbours = new ArrayList<>();

        //top
        if (cell.x - 1 >= 0 && matrix[cell.x - 1][cell.y] == 1) {
            OrangeGrid topCell = new OrangeGrid(cell.x - 1, cell.y,0);
            neighbours.add(topCell);
        }

        //bottom
        if (cell.x + 1 < matrix.length && matrix[cell.x + 1][cell.y] == 1) {
            OrangeGrid bottomCell = new OrangeGrid(cell.x + 1, cell.y,0);
            neighbours.add(bottomCell);
        }

        //left
        if (cell.y - 1 >= 0 && matrix[cell.x][cell.y - 1] == 1) {
            OrangeGrid leftCell = new OrangeGrid(cell.x, cell.y - 1,0);
            neighbours.add(leftCell);
        }


        //right
        if (cell.y + 1 < matrix[0].length && matrix[cell.x][cell.y + 1] == 1) {
            OrangeGrid rightCell = new OrangeGrid(cell.x, cell.y + 1,0);
            neighbours.add(rightCell);
        }

        return neighbours;

    }
}


class OrangeGrid {

    int x;
    int y;
    int days;

    public OrangeGrid(int x, int y, int days) {
        this.x = x;
        this.y = y;
        this.days = days;
    }

    @Override
    public boolean equals(Object obj) {
        OrangeGrid newOrangeGrid = (OrangeGrid) obj;
        return this.x == newOrangeGrid.x && this.y == newOrangeGrid.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


