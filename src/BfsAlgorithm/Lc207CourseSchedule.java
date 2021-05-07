package BfsAlgorithm;

import java.util.*;

public class Lc207CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // Corner case
            if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) return true;

            int[] indegree = new int[numCourses];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] preCourse : prerequisites) {
                indegree[preCourse[0]] ++;
                if (graph.containsKey(preCourse[1])) {
                    graph.get(preCourse[1]).add(preCourse[0]);
                } else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(preCourse[0]);
                    graph.put(preCourse[1], temp);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int curCourse = queue.poll();
                    List<Integer> temp = graph.get(curCourse);
                    if (temp == null) {
                        break;
                    }
                    for (int i = 0; i < temp.size(); i++) {
                        indegree[temp.get(i)] --;
                        if (indegree[temp.get(i)] == 0) queue.offer(temp.get(i));
                    }
                    size --;
                }
            }

            for (int course : indegree) {
                if (course != 0) return false;
            }

            return true;
        }
    }
}
