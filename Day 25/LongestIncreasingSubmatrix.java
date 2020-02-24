// Question link : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LongestIncreasingSubmatrix {


    public int longestIncreasingPath(int[][] matrix) {

        HashMap<Grid, Integer> lookup = new HashMap<>();
        int maxSequence = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Grid cell = new Grid(i, j);
                if (lookup.containsKey(cell)) {
                    continue;
                }
                int sequenceLength = DFSTraverse(cell, lookup, matrix);
                maxSequence = Math.max(maxSequence, sequenceLength);
            }
        }

        return maxSequence;
    }

    private int DFSTraverse(Grid cell, HashMap<Grid, Integer> lookup, int[][] matrix) {

        if (lookup.containsKey(cell)) {
            return lookup.get(cell);
        }

        int max = 0;
        ArrayList<Grid> neighbours = getValidNeighbours(cell, matrix);
        if (neighbours == null) {
            lookup.put(cell, 1);
        } else {
            for (Grid neigh : neighbours) {
                max = Math.max(max, DFSTraverse(neigh, lookup, matrix));
            }
            lookup.put(cell, max + 1);
        }
        return lookup.get(cell);


    }

    private ArrayList<Grid> getValidNeighbours(Grid cell, int[][] matrix) {

        ArrayList<Grid> neighbours = new ArrayList<>();

        //top
        if (cell.x - 1 >= 0 && matrix[cell.x - 1][cell.y] > matrix[cell.x][cell.y]) {
            Grid topCell = new Grid(cell.x - 1, cell.y);
            neighbours.add(topCell);
        }

        //bottom
        if (cell.x + 1 < matrix.length && matrix[cell.x + 1][cell.y] > matrix[cell.x][cell.y]) {
            Grid bottomCell = new Grid(cell.x + 1, cell.y);
            neighbours.add(bottomCell);

        }

        // left
        if (cell.y - 1 >= 0 && matrix[cell.x][cell.y - 1] > matrix[cell.x][cell.y]) {
            Grid leftCell = new Grid(cell.x, cell.y - 1);
            neighbours.add(leftCell);

        }

        // right
        if (cell.y + 1 < matrix[0].length && matrix[cell.x][cell.y + 1] > matrix[cell.x][cell.y]) {
            Grid rightCell = new Grid(cell.x, cell.y + 1);
            neighbours.add(rightCell);

        }

        return neighbours;
    }

}

class Grid {

    int x;
    int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
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