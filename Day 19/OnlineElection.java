// Question : https://leetcode.com/problems/online-election/

import java.util.ArrayList;
import java.util.Arrays;

public class OnlineElection {
    public static int[] persons;
    public static int[] time;
    public static ArrayList<Integer> winners;

    public static void main(String[] args) {
        int[] persons = new int[]{0,0,1,1,0};
        int[] time =    new int[]{0,6,39,52,75};

        OnlineElection oe = new OnlineElection(persons, time);
        System.out.println("Max vote for " + 66 + " is " +oe.q(66));

    }

    public OnlineElection(int[] person, int[] times) {
        persons = person;
        time = times;
        winners = new ArrayList<>();
        winners = calculateWinners();
    }

    // Precalculation to identify winners at each given time
    private ArrayList<Integer> calculateWinners() {

        int[] occurrenceMap = new int[5000];
        int maxVote = 0;
        int currentWinner = 0;

        for (int i = 0; i < persons.length; i++) {
            occurrenceMap[persons[i]]++;
            if(occurrenceMap[persons[i]] >= maxVote){
                currentWinner = persons[i];
                maxVote = occurrenceMap[persons[i]];
            }
            this.winners.add(currentWinner);
        }
        return this.winners;
    }

    public int q(int t) {
        return getCurrentWinner(t,0,winners.size()-1);
    }

    public int getCurrentWinner(int t, int left, int right){

        if(right >= left){
            int middle = (left + right - 1) / 2 ;
            if(left == right) middle = left;

            if(time[middle] <= t){
                if(middle < winners.size()-1 && time[middle+1] > t)return winners.get(middle);
                return getCurrentWinner(t,middle + 1,right);
            }else{
                if(middle > 0 && time[middle-1] < t) return winners.get(middle-1);
                return getCurrentWinner(t,left,middle-1);
            }
        }
        return winners.get(winners.size()-1);
    }

}


// Test case : https://leetcode.com/submissions/detail/289246752/testcase

