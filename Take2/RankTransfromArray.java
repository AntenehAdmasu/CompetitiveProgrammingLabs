import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RankTransfromArray {

    public static void main(String[] args) {
        int[] array = {40, 10, 20, 30, 10};
//        int[] ans = new RankTransfromArray().arrayRankTransformWithPriorityQueue(array);
        int[] ans2 = new RankTransfromArray().arrayRankTransform(array);
        System.out.println(Arrays.toString(ans2));
    }

    public int[] arrayRankTransformWithPriorityQueue(int[] arr) {
        PriorityQueue<Item> heap = new PriorityQueue<>();
        int index = 0;

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Item(arr[i], i));
        }
        int prev = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Item polled = heap.poll();
            System.out.println("polled " + polled.value + " index " + index);
            index += polled.value > prev ? 1 : 0;
            answer[polled.index] = index;
            prev = polled.value;
        }
        return answer;
    }

    public int[] arrayRankTransform2(int[] arr) {
        int[][] arrayWithIndices = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arrayWithIndices[i] = new int[]{arr[i], i};
        }
        Arrays.sort(arrayWithIndices, new ArrayComparator());
        for (int[] item : arrayWithIndices) {
            System.out.println(Arrays.toString(item));
        }
        int[] answer = new int[arr.length];
        int rank = 0;
        int previous = Integer.MIN_VALUE;
        for (int[] item : arrayWithIndices) {
            rank += item[0] > previous ? 1 : 0;
            answer[item[1]] = rank;
            previous = item[0];
        }
        return answer;
    }

    // After looking around - O(N) time
    public int[] arrayRankTransform(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int item : arr) {
            min = Math.min(item, min);
            max = Math.max(item, max);
        }
        System.out.println(max + " ^ " + min);

        int[] ranks = new int[max - min + 1];

        for (int num : arr) {
            // Putting ones as boolean to indicate a change
            ranks[num - min] = 1;
        }

        for (int i = 1; i < ranks.length; i++) {
            // Rank is the previous rank plus 1(if the current is larger)
            ranks[i] += ranks[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks[arr[i] - min];
        }
        return arr;
    }


}

class Item implements Comparable<Item> {

    int value;
    int index;

    public Item(int val, int index) {
        this.value = val;
        this.index = index;
    }

    @Override
    public int compareTo(Item o) {
        return this.value - o.value;
    }
}

class ArrayComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}
