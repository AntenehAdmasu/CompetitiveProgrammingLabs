// Question link : https://codeforces.com/contest/1285/problem/C

import java.util.ArrayList;
import java.util.Scanner;

public class FadiandLCM {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        maxLCM(a);
    }


    public static void maxLCM(long number){
        int sqrRoot = (int) Math.sqrt(number);
        for (long i = sqrRoot; i >= 1 ; i--) {

            if(number % i == 0){
                long pair = number / i;
                if(getGCD(pair, i) == 1){
                    System.out.println(i + " " + pair);
                    return;
                }
            }
        }
    }

    private static long getGCD(long pair, long number){
        return (number == 0) ? pair: getGCD(number, pair % number);
    }

}
