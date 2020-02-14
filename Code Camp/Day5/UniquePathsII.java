// Question link : https://leetcode.com/problems/unique-paths-ii/

public class UniquePathsII {

    public static void main(String[] args) {
        int[][] oGrid = new int[][]{

                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(oGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
        int init = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                int top = i - 1 < 0 ? 0 : arr[i-1][j];
                int left = j - 1 < 0 ? 0 : arr[i][j-1];

                if (obstacleGrid[i][j] == 0){
                    arr[i][j] =  top + left;
                    arr[i][j] += i == 0 & j == 0 ? init : 0;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        return arr[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
