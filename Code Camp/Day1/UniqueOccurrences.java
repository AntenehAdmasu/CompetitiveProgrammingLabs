// Question link : https://leetcode.com/contest/weekly-contest-156/problems/unique-number-of-occurrences

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,2,1,1,3};
        int[] test2 = new int[]{1,1,2,2,2,3,3,3,3};
        int[] test3 = new int[]{};

        System.out.println(new UniqueOccurrences().uniqueOccurrences(test));
    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        HashSet<Integer> occurences = new HashSet<>();

        for (int x: arr) {
            occ.put(x, occ.containsKey(x) ? occ.get(x) + 1 : 1);
        }
        for (int occurence: occ.keySet()) {
            System.out.println(occurence + " " + occ.get(occurence));
            if(occurences.contains(occ.get(occurence))){
                return false;
            }
            occurences.add(occ.get(occurence));
        }
        return true;
    }
}
