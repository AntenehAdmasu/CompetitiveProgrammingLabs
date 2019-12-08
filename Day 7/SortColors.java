import java.util.HashMap;

public class SortColors{

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        quickSort(0, nums.length -1, nums );
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



}}
