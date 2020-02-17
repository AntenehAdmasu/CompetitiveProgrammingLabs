// Question link : https://leetcode.com/contest/weekly-contest-88/problems/loud-and-rich/

import java.util.*;

public class LoudandRich {

    public static void main(String[] args) {

        int[][] test68 = new int[][]{
                new int[]{0,2},
                new int[]{1,2}
        };
        int[] quiet68 = new int[]{0,1,2};
        new LoudandRich().loudAndRich(test68, quiet68);
    }

        public int[] loudAndRich(int[][] richer, int[] quiet) {
            HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
            HashMap<Integer, Integer> calculated  = new HashMap<>();

            int[] res = new int[quiet.length];

            //  Constructing the adjacency list
            for (int pair[]: richer) {
                ArrayList<Integer> richers = adjList.containsKey(pair[1]) ? adjList.get(pair[1]) : new ArrayList<>();
                richers.add(pair[0]);
                adjList.put(pair[1], richers);
            }

            for (int i = 0; i < quiet.length; i++) {
                int result = getQuiter(i,adjList,quiet,calculated);
                res[i] = result;
            }
            return res;

        }


    public int getQuiter(int index, HashMap<Integer, ArrayList<Integer>> adjList, int[] quiet, HashMap<Integer,Integer> calculated){

        if(calculated.containsKey(index)){
            return calculated.get(index);
        }

        if( !adjList.containsKey(index)){
            calculated.put(index, index);
            return index;
        }

        int louder = quiet[index];
        int loudIndex = index;

        for (int richerPerson: adjList.get(index)) {
            int min = getQuiter(richerPerson, adjList, quiet, calculated);
            if(quiet[min] < louder){
                loudIndex = min;
                louder = quiet[min];
            }
        }

        calculated.put(index, loudIndex);
        return loudIndex;
    }
}
