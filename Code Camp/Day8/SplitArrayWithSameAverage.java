// Question link : https://leetcode.com/problems/split-array-with-same-average/

import java.util.ArrayList;
import java.util.HashSet;

public class SplitArrayWithSameAverage {

    public static void main(String[] args) {
        int[] allNums = new int[]{4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5};
        int[] allNums2 = new int[]{17, 5, 5, 1, 14, 10, 1300, 1, 6};


        System.out.println(new SplitArrayWithSameAverage().splitArraySameAverage(allNums));

    }

    public boolean splitArraySameAverage(int[] A) {

        HashSet<State> endStates = new HashSet<>();
        HashSet<State> visited = new HashSet<>();
        HashSet<Integer> possibles = new HashSet<>();

        double sum = 0;

        for (int x : A) sum += x;
        double unit = sum / A.length;

        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        for (int i = 1; i <= A.length / 2; i++) {

            if ((sum * i) / A.length == (int) ((sum * i) / A.length)) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(A.length - i);
                pairs.add(pair);
                possibles.add(i);
                int Sum = (int) (i * unit);
                State state = new State(Sum, i);

                endStates.add(state);
            }
        }

        if (endStates.size() == 0) return false;
        ArrayList<ArrayList<Integer>> elements = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            elements.add(temp);
            int val = A[i];
            State s = new State(val, 1);
            if (endStates.contains(s)) return true;
        }

        int listSize = 1;
        while (elements.get(0).size() <= A.length / 2) {

            if (!possibles.contains(listSize)) {
                elements = getPossibleCombinations(elements, visited, A);
                listSize++;
                continue;
            }
            for (ArrayList combinations : elements) {
                int Sum = getSum(combinations, A);
                State s = new State(Sum, combinations.size());
                if (endStates.contains(s)) return true;
            }

            elements = getPossibleCombinations(elements, visited, A);
            listSize++;
        }
        return false;

    }


    public ArrayList<ArrayList<Integer>> getPossibleCombinations(ArrayList<ArrayList<Integer>> number, HashSet<State> visited, int[] A) {

        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        for (ArrayList<Integer> num : number) {
            ArrayList<ArrayList<Integer>> fromOne = generateUnique(num, A, visited);

            for (ArrayList fone : fromOne) toReturn.add(fone);
        }

        return toReturn;
    }

    private ArrayList<ArrayList<Integer>> generateUnique(ArrayList<Integer> num, int[] A, HashSet<State> visited) {
        HashSet<Integer> tempHashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int x : num) tempHashSet.add(x);

        for (int j = 0; j < A.length; j++) {
            if (!tempHashSet.contains(j)) {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.addAll(num);
                newList.add(j);
                State s = new State(getSum(newList, A), newList.size());
                if (!visited.contains(s)) {
                    result.add(newList);
                    visited.add(s);
                }
            }
        }
        return result;
    }


    public int getSum(ArrayList<Integer> nums, int[] A) {
        int sum = 0;
        for (int x : nums) {
            sum += A[x];
        }
        return sum;
    }
}


class State {

    int sum;
    int size;

    public State(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        return this.size == ((State) o).size && this.sum == ((State) o).sum;
    }

    @Override
    public int hashCode() {
        return sum * 12345 + size * 76;

    }
}
