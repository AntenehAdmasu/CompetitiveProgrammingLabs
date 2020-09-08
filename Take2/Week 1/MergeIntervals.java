import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new TwoDArrayComparator());
        int start, end;
        int index = 0;
        int len = intervals.length;
        int[][] result = new int[len][2];
        int resLength = 0;
        while (index < len){
            end = intervals[index][1];
            start = intervals[index][0];
            boolean iterated = false;
            while (index < len && intervals[index][0] <= end){
                iterated = true;
                end = Math.max(end, intervals[index][1]);
                index++;
            }
            result[resLength++] = new int[]{start, end};
            if(!iterated){
                index++;
            }
        }
        return Arrays.copyOf(result, resLength);
    }
}

class TwoDArrayComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[0] < o2[0]){
            return -1;
        }else if(o1[0] > o2[0]){
            return 1;
        }else{
            return o1[1] - o2[1];
        }
    }
}
