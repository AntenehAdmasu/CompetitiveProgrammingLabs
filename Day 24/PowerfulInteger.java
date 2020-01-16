// Question link : https://leetcode.com/problems/powerful-integers/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulInteger {
    public static void main(String[] args) {
        powerfulIntegers(2,1,10);
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {

        int maxPossibleForX = (x==1) ? 1: (int) (Math.log(bound-1) / Math.log(x));
        int maxPossibleForY = (y==1) ? 1: (int) (Math.log(bound-1) / Math.log(y));
        HashSet<Integer> result = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= maxPossibleForX; i++) {
            for (int j = 0; j <= maxPossibleForY; j++) {
                int num = (int)(Math.pow(x, i) + Math.pow(y,j));
                if(num > bound) break;
                result.add(num);
            }
        }

        res.addAll(result);

        return res;
    }
}
