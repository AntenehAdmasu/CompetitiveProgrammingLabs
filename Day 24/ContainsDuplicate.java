import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> occurence = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if(occurence.containsKey(nums[i]) && (i - occurence.get(nums[i]) <= k)) return true;
            occurence.put(nums[i],i);
        }

        
        return false;
    }
}
