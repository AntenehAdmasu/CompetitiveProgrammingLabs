// Question link : https://leetcode.com/contest/weekly-contest-174/problems/the-k-weakest-rows-in-a-matrix

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 0, 0,},
                new int[]{1, 0, 0},
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 0, 0},

        };
        new TheKWeakestRowsInAMatrix().kWeakestRows(test, 4);

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<IndexSoldierPair> heap = new PriorityQueue<>();
        int[] toReturn = new int[k];
        int columnSize = mat[0].length;
        int rowSize = mat.length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 1; j < columnSize; j++) {
                mat[i][j] += mat[i][j - 1];
            }
            addToHeap(heap, new IndexSoldierPair(i, mat[i][columnSize - 1]), k);
        }

        for (int i = 0; i < k; i++) {
            toReturn[k - 1 - i] = heap.poll().index;
        }
        return toReturn;
    }


    public void addToHeap(PriorityQueue<IndexSoldierPair> heap, IndexSoldierPair row, int k) {
        if (heap.size() < k) {
            heap.add(row);
            return;
        }
        if (heap.peek().soldier > row.soldier) {
            int val = heap.poll().soldier;
            heap.add(row);
        }
    }

}

class IndexSoldierPair implements Comparable {
    int index, soldier;

    public IndexSoldierPair(int i, int s) {
        index = i;
        soldier = s;
    }

    @Override
    public int compareTo(Object o) {
        if (this.soldier < ((IndexSoldierPair) o).soldier) return 1;
        if (this.soldier == (((IndexSoldierPair) o).soldier)) {
            if (this.index < ((IndexSoldierPair) o).index) return 1;
        }
        return -1;
    }
}
