// Question link : https://leetcode.com/problems/powx-n/

public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow2(2,10));
    }


    public static  double myPow(double x, int n) {
        return (n < 0) ? 1 / myPow2(x, Math.abs(n)) :  myPow2(x, Math.abs(n)) ;
    }


    public static double myPow2(double x, int n) {

        if(n == 0) return 1;
        double res = myPow2(x, n/2);
        return (n % 2 == 0) ? (res * res) : res * res * x;

    }
}
