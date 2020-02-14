// Question link : https://leetcode.com/contest/weekly-contest-88/problems/maximize-distance-to-closest-person/

import java.util.ArrayList;
import java.util.Collections;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        int[] seats = new int[]{0,0,0,0,1,0,1,0,1,0,0,0};
        new MaximizeDistanceToClosestPerson().maxDistToClosest(seats);
        System.out.println(" ++>>> " + new MaximizeDistanceToClosestPerson().maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1){
                ones.add(i);
            }
        }
        int len = ones.size();
        Collections.sort(ones);
        int start = 0; int end = 0;

        int maxDistance = ones.get(0) - 0 > seats.length-1 - ones.get(len-1) ? ones.get(0) - 0 : seats.length -1 - ones.get(len-1);

        int init = maxDistance;
        for (int i = 0; i < ones.size()-1; i++) {
            int diff = (ones.get(i+1) - ones.get(i)) / 2;
            if(diff > maxDistance){
                maxDistance = diff ;
                start = ones.get(i); end = ones.get(i+1);
            }
        }

        if(maxDistance == init){
            int pos = maxDistance == ones.get(0) - 0 ? 0 : seats.length -1;
            int dis = pos == 0 ? ones.get(0) : seats.length - ones.get(ones.size()-1)-1;
            return dis;
        }

        int pos = (start + end) / 2;

        return Math.abs(Math.min(start-pos, end - pos));

    }

}
