import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeFriends {

    public static void main(String[] args) {


        ArrayList<String> userinputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < numberOfInputs; i++) {
            String uinput = scanner.nextLine();
            userinputs.add(uinput);
        }

        for (int k = 0; k < userinputs.size(); k++) {
            System.out.println(findDistance(userinputs.get(k)));
        }
    }

    private static int findDistance(String input) {
        String[] inputArray = input.split(" ");
        for (int i = 0; i < inputArray.length; i++) {
        }
        ArrayList<Integer> inputArraylist = new ArrayList();
        for (int i = 0; i < inputArray.length; i++) {
            inputArraylist.add(Integer.parseInt(inputArray[i]));
        }

        ArrayList<Integer> sorted = ThreeFriends.sort(inputArraylist);

        if(sorted.get(0) < sorted.get(1)){
            sorted.set(0, (sorted.get(0) + 1));
        }else{
            if((sorted.get(0).equals(sorted.get(1)) && (sorted.get(0).equals(sorted.get(2)) == false))){
                sorted.set(0,(sorted.get(0) + 1));
                sorted.set(1, (sorted.get(1) + 1));
            }
        }
        if(sorted.get(2) > sorted.get(1)){
            sorted.set(2, (sorted.get(2) - 1));
        }else{
            if((sorted.get(2).equals(sorted.get(1)) && (sorted.get(2).equals(sorted.get(0)) == false))){
                sorted.set(2,(sorted.get(2) - 1));
                sorted.set(1, (sorted.get(1) - 1));
            }
        }

        int a = sorted.get(0);
        int b = sorted.get(1);
        int c = sorted.get(2);

        int distance = Math.abs(a - b) + Math.abs(a - c) + Math.abs(c - b);
        return distance;
    }



    public static ArrayList<Integer> sort(ArrayList<Integer> nums){
        for (int i = 0; i < nums.size() ; i++) {
            for (int j = i; j < nums.size(); j++) {
                if(nums.get(j) < nums.get(i)){
                    Collections.swap(nums, i, j);
                }
            }
        }
        return nums;
    }

}
