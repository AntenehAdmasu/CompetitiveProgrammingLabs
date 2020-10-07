import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int[] stones2 = {3,3,4};
        int[] stones3 = {};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        for (int x: stones) {
            heap.add(x);
        }

        while (heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            int diff = Math.abs(stone1 - stone2);
            if(diff > 0){
                heap.add(diff);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
