import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        PriorityQueue<FrequencyMap> heap = new PriorityQueue();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            frequency.put(c, frequency.containsKey(c) ? frequency.get(c) + 1 : 1);
        }

        for(Character c: frequency.keySet()){
            heap.add(new FrequencyMap(c, frequency.get(c)));
        }
        StringBuilder answer = new StringBuilder();
        while(!heap.isEmpty()){
            FrequencyMap fm = heap.poll();
            int counter = fm.freq;
            while(counter-- > 0){
                answer.append(fm.c);
            }
        }

        return answer.toString();
    }
}

class FrequencyMap implements Comparable<FrequencyMap> {
    Character c;
    int freq;
    public FrequencyMap(Character c, int freq){
        this.c = c;
        this.freq = freq;
    }

    @Override
    public int compareTo(FrequencyMap o) {
        FrequencyMap newFM = (FrequencyMap) o;
        return this.freq - newFM.freq;
    }
}
