package BfsAlgorithm;

import java.util.*;

public class Lc210CourseScheduleII {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Corner case
            if (numCourses == 0) return new int[0];

            int[] indegree = new int[numCourses];
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] preCourse : prerequisites) {
                indegree[preCourse[0]] ++;
                if (graph.containsKey(preCourse[1])) {
                    graph.get(preCourse[1]).add(preCourse[0]);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(preCourse[0]);
                    graph.put(preCourse[1], temp);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) queue.offer(i);
            }

            List<Integer> courseOrder = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int curCourse = queue.poll();
                    courseOrder.add(curCourse);
                    List<Integer> temp = graph.get(curCourse);
                    if (temp != null) {
                        for (int i = 0; i < temp.size(); i++) {
                            indegree[temp.get(i)] --;
                            if (indegree[temp.get(i)] == 0) queue.offer(temp.get(i));
                        }
                    }
                    size --;
                }
            }

            if (courseOrder.size() != numCourses) return new int[0];
            int[] resCourseOrder = new int[numCourses];
            for (int i = 0; i < resCourseOrder.length; i++) {
                resCourseOrder[i] = courseOrder.get(i);
            }

            return resCourseOrder;
        }
    }
}
