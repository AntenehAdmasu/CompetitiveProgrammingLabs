import java.util.PriorityQueue;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i = 0;
        int n = heights.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)-> b-a);

        while(i < n-1){
            int delta = heights[i+1] - heights[i];

            if(delta > 0){
                if(bricks >= delta){
                    bricks -= delta;
                    heap.add(delta);
                }else {
                    if(ladders > 0){
                        if(heap.isEmpty() || delta > heap.peek()){
                            ladders--;
                        }else{
                            int replace = heap.isEmpty() ? 0 : heap.poll();
                            bricks += replace;
                            ladders--;
                            continue;
                        }
                    }else{
                        return i;
                    }
                }
            }
            i++;
        }
        return i;
    }
}
