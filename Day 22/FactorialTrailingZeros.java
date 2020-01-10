// Question : https://leetcode.com/problems/factorial-trailing-zeroes/

public class FactorialTrailingZeros {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeros().trailingZeroes(25));
    }

    public int trailingZeroes(int n) {

        int divisor = 5;
        int trailingZeros = 0;
        while(n >= divisor){
            trailingZeros += n / divisor;
            divisor *= 5;
        }
        return trailingZeros;


    }
}
