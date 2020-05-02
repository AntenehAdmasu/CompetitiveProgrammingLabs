import java.util.Arrays;

public class LeftRotationOfAnArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(rotLeft(arr, 1));
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] newArr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            d %= a.length;
            newArr[i] = a[d];
            d++;
        }
        return newArr;
    }

}
