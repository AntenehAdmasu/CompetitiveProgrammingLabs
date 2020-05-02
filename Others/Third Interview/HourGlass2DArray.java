public class HourGlass2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {-9, -9, -9, 1, 1, 1},
                {0 ,- 9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(hourglassSum(arr));
    }

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            int j = 1;
            int sum = arr[i][j] + arr[i - 1][j] + arr[i+1][j] + arr[i - 1][j - 1] + arr[i - 1][j + 1] + arr[i + 1][j - 1] + arr[i + 1][j + 1];
            max = Math.max(max, sum);
            for (int k = 2; k < 5; k++) {
                sum -= (arr[i][k - 1] + arr[i - 1][k - 2] + arr[i + 1][k - 2]);
                sum += (arr[i][k] + arr[i - 1][k + 1] + arr[i + 1][k + 1]);
                max = Math.max(max, sum);
            }
        }
        return max;

    }
}
