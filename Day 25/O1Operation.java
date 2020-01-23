// Question link : https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class O1Operation {


    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, Integer> valIndexMap;
    ArrayList<Integer> numbers;

    public O1Operation() {
        valIndexMap = new HashMap<>();
        numbers = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valIndexMap.containsKey(val)) return false;
        valIndexMap.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val)) return false;
        int lastIndex = numbers.size() - 1;

        int index = (int) valIndexMap.get(val);
        int lastVal = numbers.get(lastIndex);

        Collections.swap(numbers, index, lastIndex);
        numbers.remove(lastIndex);
        valIndexMap.remove(val);

        if (index == lastIndex) return true;
        valIndexMap.put(lastVal, index);
        // System.out.println("test: " + valIndexMap.containsKey(val));
        // System.out.println("size: " + valIndexMap.size());

        return true;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (numbers.size() == 0) return 0;
        // System.out.println("size: " + numbers.size());
        int rand = new Random().nextInt(numbers.size());
        // System.out.println("rand: " + rand);

        return numbers.get(rand);
    }


}
