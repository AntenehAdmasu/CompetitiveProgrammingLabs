// Question : https://codeforces.com/contest/1279/problem/A

import java.util.ArrayList;
import java.util.Scanner;

public class NewyearGarland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        ArrayList<String> userinputs = new ArrayList<>();
        scanner.nextLine();

        for (int i = 0; i  < numberOfInputs ; i++) {
            String nums = scanner.nextLine();
            userinputs.add(nums);
        }

        // Sending inputs to the function
        for (int i = 0; i < userinputs.size() ; i++) {
            String[] inputs = userinputs.get(i).split(" ");
            isItPossible(Long.parseLong(inputs[0]), Long.parseLong(inputs[1]), Long.parseLong(inputs[2]));
        }
        scanner.close();
    }

    public static void isItPossible(long r, long g, long b){
        long length = r + g + b;
        long max = Math.max(Math.max(r,g),b);
        long maxPossibleOccurrence = (length % 2 == 0) ? length / 2 : (length / 2) + 1;
       
        String res = (max > maxPossibleOccurrence) ? "No" : "Yes";
        System.out.println(res);

    }
}
