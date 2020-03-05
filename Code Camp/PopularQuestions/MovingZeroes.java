// Question link : https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;

public class MovingZeroes {

    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        int[] ans = new MovingZeroes().moveZeroesToTheRight(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] moveZeroesToTheRight(int[] arr) {
        int zeroPointer = 0;
        while (zeroPointer < arr.length - 1 && arr[zeroPointer] != 0) {
            zeroPointer++;
        }
        int nonZeroPointer = zeroPointer;

        while (nonZeroPointer < arr.length - 1 && zeroPointer < arr.length - 1) {

            while (zeroPointer < arr.length - 1 && arr[zeroPointer] != 0) {
                zeroPointer++;
            }

            while (nonZeroPointer < arr.length - 1 && arr[nonZeroPointer] == 0) {
                nonZeroPointer++;
            }

            int temp = arr[zeroPointer];
            arr[zeroPointer] = arr[nonZeroPointer];
            arr[nonZeroPointer] = temp;
        }

        return arr;
    }
}
