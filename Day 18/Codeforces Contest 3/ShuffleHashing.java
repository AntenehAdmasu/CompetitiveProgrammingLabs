// Question : http://codeforces.com/contest/1278/problem/A

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShuffleHashing {
    public static void main(String[] args) {

        ArrayList<String> userinputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfInputs; i++) {
            String password = scanner.nextLine();
            String hash = scanner.nextLine();

            userinputs.add(password);
            userinputs.add(hash);
        }

        for (int k = 0; k < userinputs.size(); k+=2) {
            checkPassword(userinputs.get(k), userinputs.get(k+1));
        }
    }


    public static void checkPassword(String password, String hash){
        int plen = password.length();
        int hlen = hash.length();
        String[] sorted_password = password.split("");
        Arrays.sort(sorted_password);

        for (int i = 0; i < hlen - plen + 1 ; i++) {
            String[] test = (hash.substring(i, i + plen)).split("");
            Arrays.sort(test);
            if(Arrays.equals(test,sorted_password)){
                System.out.println("YES");return;
            }
        }
        System.out.println("NO");
    }
    
}
