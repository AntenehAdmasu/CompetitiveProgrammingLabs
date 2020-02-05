// Question link : https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(4,5));
        System.out.println(new UniquePaths().uniquePaths(5,5));
    }

    public int uniquePaths(int m, int n) {
        int[] pathArray = new int[n]; // A pathArray of size 4, all valued 1 initially

//        for (int i = 0; i < n; i++) pathArray[i] = 1;

        // We can initialize the bottom layer with value one as in the commented-out but
        // adding one does the same if we add one each time in the iteration
        for (int i = 0; i < m-1; i++) {
            for (int j = n-2; j >= 0; j--) {
                pathArray[j] = pathArray[j+1] + pathArray[j] + 1;
            }
        }

        return pathArray[0] + 1;
    }
}
