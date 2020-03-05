// Question link : https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> answer = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int[] bridge = new int[2];
        int index = 0;

        // Getting the start index
        while(index < intervals.length){
            int[] interval = intervals[index];
            if(newInterval[1] <= interval[0] || interval[0] > newInterval[0]){
                break;
            }
            if((newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) ){
                start = interval[0];
                break;
            }
            answer.add(interval);
            index++;
        }

        bridge[0] = start;

        while(index < intervals.length){

            int[] interval = intervals[index];
            if(interval[0] > newInterval[1]){
                break;
            }else if(interval[1] < newInterval[1]){
                index++;
                continue;
            }
            if(newInterval[1] <= interval[0] || newInterval[1] <= interval[1]){
                end = interval[1];
                index++;
                break;
            }
            index++;
            answer.add(interval);
        }

        bridge[1] = end;
        answer.add(bridge);

        for(int i = index; i < intervals.length; i++){
            int[] interval = intervals[i];
            answer.add(interval);
        }

        int[][] ans = new int[answer.size()][2];
        int counter = 0;
        for(int[] interval: answer){
            ans[counter][0] = interval[0];
            ans[counter++][1] = interval[1];
        }

        return ans;
    }
}
