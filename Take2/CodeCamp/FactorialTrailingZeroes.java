public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long divisor = 5;
        int trailingZeros = 0;
        while(n >= divisor){
            trailingZeros += (n / divisor);
            divisor *= 5;
        }
        return trailingZeros;
    }
}
