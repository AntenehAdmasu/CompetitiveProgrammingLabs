// Question : https://leetcode.com/problems/minimum-increment-to-make-array-unique/

import java.util.Arrays;
import java.util.HashSet;

public class MinimumIncrement {
    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,2,1,7,6};
        int[] test2 = new int[]{1,2,2};
        new MinimumIncrement().minIncrementForUnique(test);
    }
    public int minIncrementForUnique(int[] A) {

        Arrays.sort(A);
        HashSet<Integer> occ = new HashSet<>();
        int cost = 0;
        int lastVal = 0;
        for (int x: A) {
            System.out.println("checking " + x);
            if(occ.contains(x)){
                cost += lastVal + 1 -x;
                lastVal++;
                occ.add(lastVal);
                continue;
            }
            lastVal = x;
            occ.add(x);
        }
        System.out.println(cost);
        return cost;
    }
}
