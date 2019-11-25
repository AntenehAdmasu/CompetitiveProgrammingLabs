import java.util.ArrayList;
import java.util.Collections;

public class Insertion {
    public ArrayList<Integer> sort(ArrayList<Integer> nums) {
        if(nums.size() == 0) return nums;
        for (int key = 1; key < nums.size(); key++) {

            int i = key;
            int j = i -1;

            while( j >= 0 && (nums.get(key) < nums.get(j))){
                Collections.swap(nums, key, j);
                key --;
                j --;
            }
        }
        return nums;
    }
}
