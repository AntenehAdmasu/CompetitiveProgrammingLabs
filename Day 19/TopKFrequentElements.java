// Question : https://leetcode.com/problems/top-k-frequent-elements/submissions/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int nums[] = new int[]{1};
        List<Integer> myheap = new TopKFrequentElements().topKFrequent(nums, 1);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        KFrequent topKFrequent = new KFrequent(nums, k);
        int[][] heap = topKFrequent.getFrequent();
        for (int i = 0; i < k; i++) {
            result.add(heap[i][1]);
        }
        return result;
    }
}

class KFrequent{
    int size;
    int[] nums;
    int[][] heap;
    int k;
    public KFrequent(int[] numbers, int K){
        size = 0;
        nums = numbers;
        heap = new int[K][2];
        k = K;
    }

    public int[][] getFrequent() {

        HashMap<Integer, Integer> occurence = new HashMap<>();
        for (int x : nums) {
            occurence.put(x, occurence.containsKey(x) ? occurence.get(x) + 1 : 1);
        }
        int counter = 0;
        for (int n : occurence.keySet()) {
            if (counter < k) {
                insert(heap, new int[]{occurence.get(n), n});

            } else {
                if (occurence.get(n) > heap[0][0]) {
                    delete(heap);
                    insert(heap, new int[]{occurence.get(n), n});
                }
            }
            counter++;
        }
        return heap;

    }

    public void insert(int[][] heap, int[] pair) {
        heap[size] = pair;
        size++;
        int i = size - 1;
        while (heap[i][0] < heap[(parent(i))][0]) {
            int[] temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void delete(int[][] heap) {
        int[] temp = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = temp;
        size--;
        sinkDown(heap, 0);
    }

    public void sinkDown(int[][] heap, int pos) {
        int smallerChild;
        if (rightChild(pos) < size && heap[rightChild(pos)][0] < heap[pos][0]) {
            smallerChild = heap[leftChild(pos)][0] < heap[rightChild(pos)][0] ? leftChild(pos) : rightChild(pos);
        } else if ((leftChild(pos) < size && heap[leftChild(pos)][0] < heap[pos][0])) {
            smallerChild = leftChild(pos);
        } else {
            return;
        }
        int[] temp = heap[pos];
        heap[pos] = heap[smallerChild];
        heap[smallerChild] = temp;
        sinkDown(heap, smallerChild);
    }


    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }
}

