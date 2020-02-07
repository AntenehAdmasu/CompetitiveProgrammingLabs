// Question link : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

public class NUniqueIntegers {

    public static void main(String[] args) {
        new NUniqueIntegers().sumZero(11);
    }

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int counter = 0;

        for (int i = 1; i <= n/2; i++) {
            res[counter++] = i;
            res[counter++] = i * -1;
        }

        if(n % 2 != 0) res[counter] = 0;
        return res;


    }
}
