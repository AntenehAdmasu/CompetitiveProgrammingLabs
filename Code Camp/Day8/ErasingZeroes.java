import java.util.ArrayList;
import java.util.Scanner;

public class ErasingZeroes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 0; i < testCases ; i++) {
            String inp = scanner.nextLine();
            inputs.add(inp);
        }
        for (String input: inputs) {
            getNumberOfErasedZeroes(input);
        }
    }

    public static void getNumberOfErasedZeroes(String s) {
        boolean oneFound = false;
        int tempCount = 0;
        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (oneFound) tempCount++;
            } else {
                if (oneFound) {
                    totalCount += tempCount;
                    tempCount = 0;
                }else{
                    oneFound = true;
                }
            }
        }
        System.out.println(totalCount);
    }
}
