// Question link : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

import java.util.ArrayList;

public class NumberOfDiceRolls {

    public static void main(String[] args) {
        new NumberOfDiceRolls().numRollsToTarget(4, 6, 10);

    }


    public int numRollsToTarget(int d, int f, int target) {


        ArrayList<Integer> prev = new ArrayList<>();

        for (int i = 0; i < f; i++) {
            prev.add(1);
        }

        for (int i = 1; i < d; i++) {
            ArrayList<Integer> current = new ArrayList<>();

            Double sum = 0D;
            int window = (-1 * f);

            for (int j = window; j < (prev.size() - 1); j++) {
                if (j < 0) {
                    sum += prev.get(j + f);
                } else if (j + f < prev.size()) {
                    sum += prev.get(j + f);
                    sum -= prev.get(j);
                } else {
                    sum -= prev.get(j);
                }

                current.add((int) (sum % 1000000007));
            }

            prev = current;
        }

        if (target < d || target > d * f) {
            return 0;
        }

        return prev.get(target - d);

    }
}