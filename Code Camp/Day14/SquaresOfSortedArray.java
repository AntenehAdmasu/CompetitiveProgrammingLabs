// Question link : https://leetcode.com/contest/weekly-contest-120/problems/squares-of-a-sorted-array

import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] A) {

        Arrays.sort(A);
        int[] squareArray = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            squareArray[i] = A[i] * A[i];
        }
        Arrays.sort(squareArray);
        return squareArray;
    }
}
