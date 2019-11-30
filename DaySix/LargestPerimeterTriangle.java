public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {

        quickSort(0, A.length - 1,A);


        for (int i = A.length - 1; i >=0; i--) {
            System.out.println("i is " + i );
            if(i > 2){
                System.out.println("in if");
                if(A[i-2] + A[i-1] > A[i]){
                    System.out.println(A[i] + " i " + A[i - 1] + " i " + A[i - 2]);
                    return A[i-2] + A[i-1] + A[i];
                }
            }else{
                System.out.println("in else");
                if(A[0] + A[1] > A[2]){
                    System.out.println(A[i] + " is " + A[i - 1] + " is " + A[i - 2]);
                    return A[2] + A[1] + A[0];
                }
            }
        }
        return 0;
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

