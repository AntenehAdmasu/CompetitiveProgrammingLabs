import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Runner {
    public static void main(String[] args) {

        ArrayList<Integer> randomNumbers = generateRandomNumbers(33);

        Selection selection = new Selection();
        ArrayList<Integer> sortedBySelection = selection.sort(randomNumbers);

//        Insertion insertion = new Insertion();
//        ArrayList<Integer> sortedByInsertion = insertion.sort(randomNumbers);

//        Merge merge = new Merge();
//        ArrayList<Integer> sortedByMerge = merge.sort(randomNumbers);


//        Quick quick = new Quick();
//        ArrayList<Integer> sortedByQuickSort = quick.sort(randomNumbers);

        System.out.println("\n+++++++++ AFTER SORTING ++++++++++");
        for (int i = 0; i < sortedBySelection.size(); i++) {
            System.out.println(sortedBySelection.get(i));
        }
    }



    public static ArrayList<Integer> generateRandomNumbers(int size){
        HashMap<Integer, Integer > generatedNumbers = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();

        while(nums.size() < size) {
            Random random = new Random();
            int number = random.nextInt(size) + 1;
            if(!generatedNumbers.containsKey(number)){
                generatedNumbers.put(number, number);
                nums.add(number);
            }
        }
        return nums;
    }

}
.
