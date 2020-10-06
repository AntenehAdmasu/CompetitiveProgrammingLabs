import java.util.HashMap;
import java.util.PriorityQueue;

public class KthLargestInAnArray {

    public int findKthLargest(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<OccurenceMap> heap = new PriorityQueue();
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            frequency.put(num, frequency.containsKey(num) ? frequency.get(num) + 1 : 1);
        }
        for(int num: frequency.keySet()){
            min = Math.min(min, num);
            if(num >= min){
                heap.add(new OccurenceMap(num, frequency.get(num)));
            }
        }
        int count = 0;
        while(!heap.isEmpty()){
            OccurenceMap top = heap.poll();
            if(count + top.freq >= k){
                return top.number;
            }
            count += top.freq;
        }
        return -1;
    }
}


class OccurenceMap implements Comparable<OccurenceMap> {
    int number;
    int freq;

    public OccurenceMap(int num, int freq) {
        this.number = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(OccurenceMap o) {
        OccurenceMap newOM = (OccurenceMap) o;
        return newOM.number - this.number;

    }
}

