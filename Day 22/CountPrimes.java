// Question : https://leetcode.com/problems/count-primes/

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(13));
    }
    public static int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;

        int[] numbers = new int[n+1];
        int nonPrime = 0;
        int sqrRoot = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrRoot; i++) {
            if(numbers[i] != -1){
                for (int j = i*i; j < n ; j+=i) {
                    nonPrime += (numbers[j] == -1 || j == i) ? 0: 1;
                    numbers[j] = -1;
                    if(i == 1) break;
                }
            }
        }
        return (n - nonPrime -2);
    }
}
