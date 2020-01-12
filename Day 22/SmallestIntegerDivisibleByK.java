// Question link : https://leetcode.com/problems/smallest-integer-divisible-by-k/

public class SmallestIntegerDivisibleByK {

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(17));
    }

    public static int smallestRepunitDivByK(int K) {

        if(K % 2 == 0 || K % 5 == 0) return -1;
        int num = 1;

        int length = 1;
        while(true){
            if(num % K == 0) return length;
            num = (num % K) * 10 + 1;
            length++;
        }
    }
}
