// Question link : https://codeforces.com/contest/1285/problem/C

import java.util.ArrayList;
import java.util.Scanner;

public class FadiandLCM {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        maxLCMPair((long)a);
    }


    public static void maxLCMPair(long n){
        // Get the factors from its sqroot backwards
        long sqrRoot = (long) Math.sqrt(n);
        ArrayList<Long> factors = new ArrayList<>();
        for (int i = 1; i <= sqrRoot; i++) {
            if(n % i == 0) factors.add((long)i);
        }

        //Get each factor's pair and check their GCD
        for (int i = factors.size()-1; i >= 0; i--) {
            long factor = factors.get(i);
            long pair = n / factor;
            if(getGCD(pair, factor) == 1){
                System.out.println(factor + " " + pair);
                return;
            }
        }
    }

    public static long getGCD(long a, long b){
        return (b == 0) ? a :getGCD(b,a % b);
    }
}
