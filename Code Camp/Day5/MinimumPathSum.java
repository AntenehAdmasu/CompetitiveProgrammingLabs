// Question link : https://leetcode.com/problems/minimum-path-sum/

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{1,3,1}
//                new int[]{1,5,1}
//                new int[]{4,2,1}
        };
        System.out.println(new MinimumPathSum().minPathSum(test));
    }


    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 && j==0) continue;
                int up = (i == 0) ? Integer.MAX_VALUE : grid[i-1][j];
                int left = (j == 0) ? Integer.MAX_VALUE : grid[i][j-1];
                grid[i][j] += Math.min(up, left);
            }
        }
        return grid[n-1][m-1];

    }

}
