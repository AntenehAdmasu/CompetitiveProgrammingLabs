/// Question : https://codeforces.com/contest/1265/problem/B

import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        ArrayList<String> userinputs = new ArrayList<>();


        for (int i = 0; i  < numberOfInputs ; i++) {
            scanner.nextInt();
            scanner.nextLine();
            String nums = scanner.nextLine();
            userinputs.add(nums);
        }

        for (int i = 0; i < userinputs.size() ; i++) {
            System.out.println(getBeautifulNumbers(userinputs.get(i)));
        }
        scanner.close();
    }

    public static String getBeautifulNumbers(String userinput){
        String[] numbers = userinput.split(" ");
        int size = numbers.length;

        int[] arr = new int[size];
        StringBuilder result = new StringBuilder(userinput);
        for (int i = 0; i < size; i++) {
            arr[Integer.parseInt(numbers[i]) - 1] = i;
        }

        int min = arr[0] + 1;
        int max = arr[0] + 1;

        for (int i = 0; i < size ; i++) {
            min = min < (arr[i] + 1) ? min : arr[i] + 1;
            max = max > (arr[i] + 1) ? max : arr[i] + 1;
            char bit = ((max - min + 1) == (i+1) ) ? '1' : '0';
            result.setCharAt(i,bit);
        }
        return result.substring(0,max);
    }
}
