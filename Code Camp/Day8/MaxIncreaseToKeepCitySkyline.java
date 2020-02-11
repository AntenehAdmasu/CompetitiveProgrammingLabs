// Question link : https://leetcode.com/contest/weekly-contest-77/problems/max-increase-to-keep-city-skyline/

public class MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
               new int[] {3,0,8,4},
                new int[]{2,4,5,7},
                new int[]{9,2,6,3},
                new int[]{0,3,1,0}
        };

        System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMaximum = new int[grid.length];
        int[] columnMaximum = new int[grid[0].length];

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cell = grid[i][j];
                rowMaximum[i] = Math.max(rowMaximum[i], cell);
                columnMaximum[j] = Math.max(columnMaximum[j], cell);
            }
        }

        int maxCount = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                int maxPossibleIncrement = Math.min(rowMaximum[i],columnMaximum[j]);
                maxCount += Math.abs(grid[i][j] - maxPossibleIncrement);
            }
        }
        return maxCount;
    }

}
