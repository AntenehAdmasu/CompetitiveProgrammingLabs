import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Runner {
    public static void main(String[] args) {

        ArrayList<Integer> randomNumbers = generateRandomNumbers(300);

//        Selection selection = new Selection();
//        ArrayList<Integer> sortedBySelection = selection.sort(randomNumbers);

        Insertion insertion = new Insertion();
        ArrayList<Integer> sortedByInsertion = insertion.sort(randomNumbers);

        System.out.println("\n+++++++++ AFTER SORTING ++++++++++");
        for (int i = 0; i < sortedByInsertion.size(); i++) {
            System.out.println(sortedByInsertion.get(i));
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
        System.out.println("Before sorting");
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
        return nums;
    }
}
