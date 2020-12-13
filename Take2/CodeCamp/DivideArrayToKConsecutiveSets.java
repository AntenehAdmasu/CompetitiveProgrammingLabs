import java.util.Arrays;
import java.util.HashMap;

public class DivideArrayToKConsecutiveSets {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        for(int elem: nums){
            // Check if it is a starting element
            if(map.containsKey(elem) && !map.containsKey(elem-1)){
                boolean kElements = getKElements(elem, map, 1,k);
                if(!kElements){
                    return false;
                }
            }
        }
        return map.isEmpty();

    }

    public boolean getKElements(int num, HashMap<Integer,Integer> map, int count, int k){
        if(map.get(num) == 1){
            map.remove(num);
        }else{
            map.put(num, map.get(num) - 1);
        }
        if(count == k){
            return true;
        }
        if(map.containsKey(num+1)){
            return getKElements(num+1, map, count + 1, k);
        }
        return false;
    }
}
