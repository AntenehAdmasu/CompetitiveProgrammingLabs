// Question link : https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class SquareSubMatricesWithAllOnes {

    public static void main(String[] args) {
        int[][] test = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(new SquareSubMatricesWithAllOnes().countSquares(test));
    }

    public int countSquares(int[][] matrix) {

        int totalCount = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    continue;
                }
                int top = (i-1) < 0 ? 0 : matrix[i-1][j];
                int left = (j-1) < 0 ? 0 : matrix[i][j-1];
                int diagonal = (i-1 >= 0 && j-1 >= 0) ? matrix[i-1][j-1] : 0;

                int current = Math.min(Math.min(top,left),diagonal) + 1;
                matrix[i][j] = current;

                totalCount += current;

            }
        }
        return totalCount;
    }
}
