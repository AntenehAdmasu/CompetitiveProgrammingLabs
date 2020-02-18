// Question link : https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{2,3},
                new int[]{3,4},
                new int[]{1,2}
        };
        System.out.println("=>> " + new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }


    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new TwoDArrayComparator());

        int jumpCount = 0;
        if(intervals.length == 0) return 0;
        int last = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++){
            if(last > intervals[i][0]){
                jumpCount++;
            }else{
                last = intervals[i][1];
            }
        }

        return jumpCount;
    }
}

class TwoDArrayComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) return -1;
        if (o1[0] > o2[0]) return 1;
        if(o1[1] < o2[1]) return -1;
        if(o1[1] > o2[1]) return 1;
        return 0;
    }
}
