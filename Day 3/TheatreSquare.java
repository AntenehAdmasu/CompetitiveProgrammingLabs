// Question : http://codeforces.com/problemset/problem/1/A

import java.util.*;
public class Exercise {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long side1, side2;

        side1 = m % a == 0? m/a: (m/a) + 1;
        side2 = n % a == 0? n/a: (n/a) + 1;

        System.out.println(side1 * side2);
    }
}
