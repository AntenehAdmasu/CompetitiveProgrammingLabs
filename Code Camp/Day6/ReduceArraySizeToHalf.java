// Question link : https://leetcode.com/contest/weekly-contest-174/problems/reduce-array-size-to-the-half

import java.util.Arrays;
import java.util.HashMap;

public class ReduceArraySizeToHalf {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] test2 = new int[]{1000,1000,3,7};
        int amount = new ReduceArraySizeToHalf().minSetSize(test);
        System.out.println("** " + amount);
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> occurence = new HashMap<>();
        // Filling the hashMap
        for (int x: arr) {
            occurence.put(x,occurence.containsKey(x) ? occurence.get(x) + 1 : 1);
        }
        int counter = 0;
        int[] occurenceArray = new int[occurence.keySet().size()];

        // getting occurences
        for (int x: occurence.keySet()) {
            occurenceArray[counter] = occurence.get(x);
            counter++;
        }

        Arrays.sort(occurenceArray);
        for (int x:occurenceArray) {
            System.out.println("=> " + x);
        }
        int totalRemoved = 0;
        int sizeToBeRemoved = 0;

        while(totalRemoved < arr.length/2){
            totalRemoved += occurenceArray[occurenceArray.length-1-sizeToBeRemoved];
            sizeToBeRemoved++;
        }
        return sizeToBeRemoved;
    }
}
