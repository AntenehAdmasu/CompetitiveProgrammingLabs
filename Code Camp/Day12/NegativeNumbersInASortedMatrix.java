// Question link : https://leetcode.com/contest/weekly-contest-176/problems/count-negative-numbers-in-a-sorted-matrix

public class NegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {

        int negativeCount = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int i = rowLength-1; i >= 0 ; i--) {
            for (int j = colLength - 1; j >= 0; j--) {
                if(grid[i][j] >= 0)break;
                negativeCount++;
            }
        }

        return negativeCount;
    }
}
