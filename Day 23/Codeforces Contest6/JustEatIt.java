// Question : https://codeforces.com/contest/1285/problem/B

import java.util.Scanner;

public class JustEatIt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        int[] inputSizesList = new int[numberOfInputs];
        String[] userInputs = new String[numberOfInputs];

        scanner.nextLine();

        for (int i = 0; i < numberOfInputs; i++) {
            int inputSize = scanner.nextInt();
            scanner.nextLine();
            String input = scanner.nextLine();
            userInputs[i] = input;
            inputSizesList[i] = inputSize;
        }
        for (int i = 0; i < numberOfInputs ; i++) {
            String[] nums = userInputs[i].split(" ");
            System.out.println(isHappy(nums,inputSizesList[i] ));
        }
    }
    

    public static String isHappy(String[] tastines, int length){

        long sum = 0;
        int subArraySize = 0;
        long total = 0;

        for (String n: tastines) {
            total += Integer.parseInt(n);
        }

        for (int i = 0; i < length - 1 ; i++) {
            int num = Integer.parseInt(tastines[i]);
            sum += (sum + num > 0) ? num : (-1 * sum);
            subArraySize += (sum + num > 0) ? 1 : (-1 * subArraySize);
            if(sum >= total) return "NO";
        }

        if(sum >= total) return "NO";
        sum = 0;

        for (int i = 1; i < length ; i++) {
            int num = Integer.parseInt(tastines[i]);
            sum += (sum + num > 0) ? num : (-1 * sum);
            subArraySize += (sum + num > 0) ? 1 : (-1 * subArraySize);

            if(sum >= total) return "NO";
        }

        return "YES";
    }


}
