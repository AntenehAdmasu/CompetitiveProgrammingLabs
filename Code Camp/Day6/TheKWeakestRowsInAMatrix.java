// Question link : https://leetcode.com/contest/weekly-contest-174/problems/the-k-weakest-rows-in-a-matrix

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{1, 1, 1, 1, 0, 0},
                new int[]{0, 0, 1, 1, 1, 0},
                new int[]{0, 0, 1, 1, 0, 0}

        };
        new TheKWeakestRowsInAMatrix().kWeakestRows(test, 3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] toReturn = new int[k];

        int columnSize = mat[0].length;
        int rowSize = mat.length;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < columnSize; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }

        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            int minval = Integer.MAX_VALUE;
            for (int j = 0; j < rowSize ; j++) {
                if(mat[j][columnSize-1] < minval){
                    minIndex = j;
                    minval = mat[j][mat[0].length-1];
                }
            }

            mat[minIndex][columnSize-1] = Integer.MAX_VALUE;
            toReturn[i] = minIndex;
        }
        return toReturn;
    }
}
