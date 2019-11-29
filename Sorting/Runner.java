import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class Runner {
    public static void main(String[] args) {

        ArrayList<Integer> randomNumbers = generateRandomNumbers(10);

//        Selection selection = new Selection();
//        ArrayList<Integer> sortedBySelection = selection.sort(randomNumbers);

//        Insertion insertion = new Insertion();
//        ArrayList<Integer> sortedByInsertion = insertion.sort(randomNumbers);

//        Merge merge = new Merge();
//        ArrayList<Integer> sortedByMerge = merge.sort(randomNumbers);


//        Quick quick = new Quick();
//        ArrayList<Integer> sortedByQuickSort = quick.sort(randomNumbers);

//        Counting counting = new Counting();
//        ArrayList<Integer> sortedByCounting = counting.sort(randomNumbers);

    }


    public static ArrayList<Integer>  generateRandomNumbers(int size){
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            nums.add(i);
        }
        for (int i = 0; i < size; i++) {
            int rand = new Random().nextInt(size - i) + 1;
            Collections.swap(nums, i, rand);
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Num: " + i);
        }
        return nums;

    }

}
