// Question link : https://leetcode.com/problems/number-of-closed-islands/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1,1,1,1,1,1,1,0},
                new int[]{1,0,0,0,0,1,1,0},
                new int[]{1,0,1,0,1,1,1,0},
                new int[]{1,0,0,0,0,1,0,1},
                new int[]{1,1,1,1,1,1,1,0}
        };
        System.out.println(new NumberOfClosedIslands().closedIsland(grid));

    }
    public int closedIsland(int[][] grid) {

        HashSet<Cell> visited = new HashSet<>();
        int gridRows = grid.length;
        int gridColumns = grid[0].length;
        int islandCount = 0;

        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                Cell cell = new Cell(i, j, grid[i][j]);
                if (!visited.contains(cell) && grid[i][j] == 0) {
                    boolean island = inIsland(cell, grid, visited);
                    if(island){
                        islandCount++;
                    }
                }
            }
        }

        return islandCount;

    }

    private boolean inIsland(Cell cell, int[][] grid, HashSet<Cell> visited) {

        LinkedList<Cell> queue = new LinkedList<>();
        visited.add(cell);
        queue.add(cell);
        HashSet<Cell> seenInOneTraversal = new HashSet<>();

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            visited.add(current);
            ArrayList<Cell> neighbours = getNeighbours(current, grid);


            for (Cell neighbour : neighbours) {
                if (neighbour.value == 0 && (neighbour.row == 0 || neighbour.row == grid.length - 1 ||
                        neighbour.column == 0 || neighbour.column == grid[0].length - 1)) {
                    // if these conditions are satisfied, there is a zero at the edge of the grid , or a port :)
                    return false;
                } else {
                    if (neighbour.value == 0 && !seenInOneTraversal.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                        seenInOneTraversal.add(neighbour);
                    }
                }
            }
        }

        return true;
    }

    private ArrayList<Cell> getNeighbours(Cell cell, int[][] grid) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        neighbours.add(new Cell(cell.row, cell.column - 1, grid[cell.row][cell.column - 1]));
        neighbours.add(new Cell(cell.row, cell.column + 1, grid[cell.row][cell.column + 1]));
        neighbours.add(new Cell(cell.row - 1, cell.column, grid[cell.row - 1][cell.column]));
        neighbours.add(new Cell(cell.row + 1, cell.column, grid[cell.row + 1][cell.column]));

        return neighbours;
    }
}

class Cell {
    int row, column, value;

    public Cell(int r, int c, int val) {
        row = r;
        column = c;
        value = val;
    }

    @Override
    public boolean equals(Object o) {
        Cell newCell = (Cell) o;
        return this.row == newCell.row && this.column == newCell.column;
    }

    @Override
    public int hashCode() {
        String hash = "" + row + column;
        return hash.hashCode();
    }
}


