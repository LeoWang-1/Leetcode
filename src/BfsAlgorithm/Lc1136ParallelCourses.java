package BfsAlgorithm;

import java.util.*;

public class Lc1136ParallelCourses {
    class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            // Corner case
            if (relations == null || relations.length == 0 || relations[0] == null || relations[0].length == 0) return 1;

            // Build graph
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] indegree = new int[n];

            for (int[] relation : relations) {
                int preCourse = relation[0];
                int nextCourse = relation[1];
                indegree[nextCourse - 1] ++;
                if (map.containsKey(preCourse)) {
                    map.get(preCourse).add(nextCourse);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nextCourse);
                    map.put(preCourse, temp);
                }
            }

            // BFS
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) queue.offer(i + 1);
            }
            int minSemester = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int curCourse = queue.poll();
                    List<Integer> nextCourse = map.get(curCourse);
                    if (nextCourse != null) {
                        for (int i = 0; i < nextCourse.size(); i++) {
                            indegree[nextCourse.get(i) - 1] --;
                            if (indegree[nextCourse.get(i) - 1] == 0) queue.offer(nextCourse.get(i));
                        }
                    }
                    size --;
                }
                minSemester ++;
            }

            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] != 0) return -1;
            }

            return minSemester;
        }
    }
}
