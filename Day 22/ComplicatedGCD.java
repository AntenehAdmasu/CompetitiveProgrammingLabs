// Question link : https://codeforces.com/problemset/problem/664/A

import java.util.Scanner;

public class ComplicatedGCD {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        String ans = (a.equals(b)) ? a : "1";
        System.out.println(ans);
    }
}
