// Question link : https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

import java.util.HashMap;

public class LengthofLongestFibonacciSequence {

    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,6,7,8};
        int B[] = {1,2,3,5};

        System.out.println(new LengthofLongestFibonacciSequence().lenLongestFibSubseq(B));
    }

    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            indexMap.put(A[i],i);
        }


        int maxCount = 1;

        for (int i = 0; i < A.length ; i++) {

            for (int j = i+1; j < A.length; j++) {

                int count = 2;
                int first = A[i];
                int second = A[j];

                int sum = first + second;

                while (indexMap.containsKey(sum)){
//                    System.out.println("in while for " + first + " " + second);
                    count++;
                    maxCount = Math.max(maxCount, count);
                    first = second;
                    second = sum;
                    sum = first + second;

                }
            }
        }

        return maxCount;

    }


}
