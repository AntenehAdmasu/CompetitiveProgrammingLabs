import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> items = new ArrayList<>();
        for(int num: nums){
            HashSet<Integer> visited = new HashSet<>();
            traverse(nums, num, result, items, visited);
        }
        return result;
    }

    public void traverse(int[] nums, int number, List<List<Integer>> result, ArrayList<Integer> items, HashSet<Integer> visited){
        ArrayList<Integer> itemsCopy = (ArrayList) items.clone();
        visited.add(number);
        itemsCopy.add(number);
        if(visited.size() == nums.length){
            result.add(itemsCopy);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited.contains(nums[i])){
                traverse(nums, nums[i], result, itemsCopy, visited);
                visited.remove(nums[i]);
            }
        }
    }
}
