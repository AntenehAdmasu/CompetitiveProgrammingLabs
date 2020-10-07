import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
        }
        int partitionCount = 0;
        HashSet<Character> partitionElements = new HashSet<>();
        boolean newPartition = false;
        for (char c : S.toCharArray()) {
            if (newPartition) {
                answer.add(partitionCount);
                partitionCount = 0;
                partitionElements.clear();
            }
            partitionCount++;
            partitionElements.add(c);
            int occ = charMap.get(c);
            // update the hashmap
            if (occ == 1) {
                charMap.remove(c);
                partitionElements.remove(c);
            } else {
                charMap.put(c, occ - 1);
            }
            newPartition = partitionElements.isEmpty();
        }
        answer.add(partitionCount);
        return answer;
    }


}
