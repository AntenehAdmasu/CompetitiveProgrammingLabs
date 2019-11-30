class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
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