// Question : https://leetcode.com/problems/bitwise-ors-of-subarrays/

import java.util.HashSet;

public class BitwiseORsofSubArrays {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,2};
        System.out.println(new BitwiseORsofSubArrays().getS(test));

    }

    public int getS(int[] A){

        HashSet<Integer> answer = new HashSet<>();
        HashSet<Integer> previous = new HashSet<>();
        
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> current = new HashSet<>();
            current.add(A[i]);
            answer.add(A[i]);
            for (int x : previous) {
                int temp = x | A[i];
                current.add(temp);
                answer.add(temp);
            }
            previous = current;
        }
        return answer.size();
    }
}
