import java.util.ArrayList;
import java.util.Collections;

public class SortArrayParity {
//    public static void main(String[] args) {
//        int[] A = {2, 3, 5, 4, 8, 8, 9, 9};
//
//        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,34,65,23,55,342,55,80,30,19}; int[] arr2 = {2,1,4,3,9,6};
//        int[] x = relativeSortArray(arr1,arr2);
//
//        for (int j = 0; j < x.length; j++) {
//            System.out.println("X is " + x[j]);
//        }
//
//    }

//    public static int[] sortArrayByParityII(int[] A){
//        int[] B = new int[A.length];
//        int evenIndex = 0;
//        int oddIndex = 1;
//        for (int a = 0; a < A.length; a++) {
//
//            if (A[a] % 2 == 0) {
//                B[evenIndex] = A[a];
//                evenIndex += 2;
//
//            }else{
//                B[oddIndex] = A[a];
//                oddIndex += 2;
//            }
//        }
//
//        return B;
//    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        int arr3Counter = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length ; j++) {
                if(arr2[i] == arr1[j]){
                    arr3[arr3Counter] = arr1[j];
                    arr1[j] = -1;
                    arr3Counter++;
                }
            }
        }

        int unsorted = arr3Counter;
        for (int i = 0; i < arr1.length ; i++) {
            if(arr1[i] != -1){
                arr3[arr3Counter] = arr1[i];
                arr3Counter++;
            }
        }
        quickSort(unsorted,arr3.length -1,arr3);


        return arr3;
    }


    public static void quickSort(int initialIndex, int finalIndex, int[] array) {

        if (initialIndex < finalIndex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIndex, array);
            quickSort(initialIndex, pivIndex - 1, array);
            quickSort(pivIndex + 1, finalIndex, array);
        }
    }

    public static int getSortedPivotIndex(int intialIndex, int finalIndex, int[] array) {
        int pivot = array[intialIndex];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (array[intialIndex] <= pivot) intialIndex++;
                while (array[finalIndex] >= pivot) finalIndex--;

            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int temp = array[intialIndex];
                int temp2 = array[finalIndex];

                array[intialIndex] = temp2;
                array[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            int temp2 = array[finalIndex];

            array[pivotIndex] = temp2;
            array[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }

}
