import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer, List<Integer>> grMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> members = (grMap.containsKey(groupSizes[i])) ? grMap.get(groupSizes[i]) : new ArrayList<>();
            members.add(i);
            grMap.put(groupSizes[i], members);
        }

        for(int i: grMap.keySet()){
            List<Integer> group = new ArrayList<>();
            for(int j: grMap.get(i)){
                if(group.size() < i){
                    group.add(j);
                }
                if(group.size() == i){
                    answer.add(group);
                    group = new ArrayList<>();
                }
            }
        }

        return answer;
    }
}
