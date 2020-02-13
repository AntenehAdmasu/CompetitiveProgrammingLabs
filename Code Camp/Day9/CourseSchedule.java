// Question link : https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{2,5},
                new int[]{0,5},
                new int[]{0,4},
                new int[]{1,4},
                new int[]{1,3},
                new int[]{3,2},
        };
        new CourseSchedule().canFinish(6, test);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        int[] courses = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> AdjList = new HashMap<>();
        HashSet<Integer> coursesTaken = new HashSet<>();

        for (int[] pair : prerequisites) {
            courses[pair[0]]++;
            ArrayList<Integer> list = AdjList.containsKey(pair[1]) ? AdjList.get(pair[1]) : new ArrayList<>();
            list.add(pair[0]);
            AdjList.put(pair[1], list);
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < courses.length; i++) {
            if(courses[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            coursesTaken.add(x);
            ArrayList<Integer> dependants = AdjList.containsKey(x) ? AdjList.get(x) : null;
            if(dependants == null){
                continue;
            }
            for (int d: dependants) {
                courses[d]--;
                if(courses[d] == 0){
                    queue.add(d);
                }
            }
        }

        return coursesTaken.size() == numCourses;
    }
}
