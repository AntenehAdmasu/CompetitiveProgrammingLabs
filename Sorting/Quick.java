import java.util.ArrayList;
import java.util.Collections;

public class Quick {
    public static ArrayList<Integer> listOfNumbers;
    public ArrayList<Integer> sort(ArrayList<Integer> numbers){
        listOfNumbers = numbers;
        quickSort(0, listOfNumbers.size() - 1);
        return listOfNumbers;
    }
    public static void quickSort(int initial, int finall){
        int index = partition(0,finall );

        if(initial < index - 1){
            quickSort(initial, index - 1);
        }
        if(index < finall){
            quickSort(index+1, finall);
        }

    }

    public static int partition(int left, int right){
        int pivot = listOfNumbers.get(right);
        while (left < right){

            while(listOfNumbers.get(left) < pivot) left ++;
            while (listOfNumbers.get(right) > pivot) right--;

            if (left < right) {
                Collections.swap(listOfNumbers, left, right);
            }
        }
        return left;
    }

}
