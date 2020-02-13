// Question link : https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] courses = new int[][] {
                new int[]{0,1}
        };
        new CourseScheduleII().findOrder(2,courses);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) return null;
        int[] courses = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> AdjList = new HashMap<>();
        ArrayList<Integer> coursesTaken = new ArrayList<>();

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

        int index = 0;
        int[] OrderOfCourses = new int[coursesTaken.size()];

        for(int x: coursesTaken){
            OrderOfCourses[index++] = x;
        }

        return OrderOfCourses.length == numCourses ? OrderOfCourses : new int[]{} ;
    }
}