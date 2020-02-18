// Question link : https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxNumberOfEvents {

    public static void main(String[] args) {
        int[][] events = new int[][]{
                new int[]{4,4},
                new int[]{2,2},
                new int[]{3,4},
                new int[]{1,4},
                new int[]{1,1}
        };

        System.out.println("=> " + new MaxNumberOfEvents().maxEvents(events));
    }
    public int maxEvents(int[][] events) {

        Arrays.sort(events, new TwoDArrayComparatorFirst());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int counter = 0;
        int i = 0;

        for (int day = 1; day < 100001; day++) {

            while (heap.size() > 0 && heap.peek() < day){
                heap.poll();      // Polling events that ended already
            }
            while (i < events.length && events[i][0] == day){
                heap.add(events[i][1]);         // Inserting elements that start on that day
                i++;
            }
            if(heap.size() > 0 && heap.peek() >=  day){
                int x = heap.poll();
                counter++;
            }

        }
        return counter;
    }
}


class TwoDArrayComparatorFirst implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) return -1;
        if (o1[0] > o2[0]) return 1;
        return 0;
    }
}
