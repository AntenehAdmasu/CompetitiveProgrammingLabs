import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        ArrayList<Integer> current = new ArrayList<>();
        findCombinations(candidates, result, target, current, 0);
        return result;

    }

    public void findCombinations(int[] candidates, List<List<Integer>> result, int target, ArrayList<Integer> current,int index){
        if(target == 0){
            result.add(current);
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target >= candidates[i]){
                ArrayList<Integer> items = (ArrayList) current.clone();
                items.add(candidates[i]);
                findCombinations(candidates, result, target - candidates[i], items, i);
            }
        }

    }

}
