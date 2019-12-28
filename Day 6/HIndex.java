// Question : https://leetcode.com/problems/h-index

public class HIndex {

    public int getHIndex(int[] citations) {
        int length = citations.length;
        quickSort(0, citations.length - 1, citations);
       

        for (int i = citations.length - 1; i >= 0; i--) {

            if(citations[i] < length - i){
                return length - i - 1;
            }else if(citations[i] < length - i){
                return length - i;
            }
        }


        return length;
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
