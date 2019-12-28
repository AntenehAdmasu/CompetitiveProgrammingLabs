// Question : https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static HashMap<Integer, Integer> numbers = new HashMap<>();

    public static int[] intersection(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    if(numbers.get(nums1[i]) == null){
                        numbers.put(nums1[i],1);
                    }
                }
            }
        }

        int[] ans = new int[numbers.size()];
        int counter = 0;
        for (Integer x : numbers.keySet()){
            ans[counter] = x;
            counter++;
        }
        return ans;
    }

}
