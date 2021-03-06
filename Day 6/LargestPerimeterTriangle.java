// Question : https://leetcode.com/problems/largest-perimeter-triangle/

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {

        quickSort(0, A.length - 1,A);


        for (int i = A.length - 1; i >=0; i--) {
            if(i > 2){
                if(A[i-2] + A[i-1] > A[i]){
                    return A[i-2] + A[i-1] + A[i];
                }
            }else{
                if(A[0] + A[1] > A[2]){
                    return A[2] + A[1] + A[0];
                }
            }
        }
        return 0;
    }

    public static void quickSort(int initialIndex, int finalIndex, int[] array) {

        if (initialIndex < finalIndex) {
            int pivIndex = getIndex(initialIndex, finalIndex, array);
            quickSort(initialIndex, pivIndex - 1, array);
            quickSort(pivIndex + 1, finalIndex, array);
        }
    }

    public static int getIndex(int intialIndex, int finalIndex, int[] array) {
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

                array[intialIndex] = array[finalIndex];
                array[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];

            array[pivotIndex] = array[finalIndex];
            array[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }


}

