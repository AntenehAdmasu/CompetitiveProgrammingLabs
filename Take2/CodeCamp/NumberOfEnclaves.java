import java.util.HashSet;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        HashSet<String> visited = new HashSet<>();

        //First and Last row
        for (int col = 0; col < m; col++) {
            if (A[0][col] == 1) {
                dfs(0, col, A);
            }

            if (A[n - 1][col] == 1) {
                dfs(n - 1, col, A);
            }
        }

        //First and Last column
        for (int row = 0; row < n; row++) {
            if (A[row][0] == 1) {
                dfs(row, 0, A);
            }

            if (A[row][m - 1] == 1) {
                dfs(row, m - 1, A);
            }
        }

        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (A[row][col] == 1) {
                    res += 1;
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        A[i][j] = 0;
        for (int[] dir : directions) {
            int new_x = i + dir[0];
            int new_y = j + dir[1];

            if ((0 <= new_x && new_x < n) && (0 <= new_y && new_y < m) && (A[new_x][new_y] == 1)) {
                dfs(new_x, new_y, A);
            }
        }
    }
}