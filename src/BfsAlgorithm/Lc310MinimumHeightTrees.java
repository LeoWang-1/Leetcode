package BfsAlgorithm;

import java.util.*;

public class Lc310MinimumHeightTrees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> allPossibleRoot = new ArrayList<>();
            // Corner case
            if (n == 1) {
                allPossibleRoot.add(0);
                return allPossibleRoot;
            }

            int[] degree = new int[n];
            Map<Integer, List<Integer>> nodeGraph = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                int[] pair = edges[i];

                if (nodeGraph.containsKey(pair[0])) nodeGraph.get(pair[0]).add(pair[1]);
                else nodeGraph.put(pair[0], new ArrayList<>(Arrays.asList(pair[1])));

                if (nodeGraph.containsKey(pair[1])) nodeGraph.get(pair[1]).add(pair[0]);
                else nodeGraph.put(pair[1], new ArrayList<>(Arrays.asList(pair[0])));

                degree[pair[0]] ++;
                degree[pair[1]] ++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i= 0; i < degree.length; i++) {
                if (degree[i] == 1) queue.offer(i);
            }

            while (!queue.isEmpty()) {
                List<Integer> allPossibleTemp = new ArrayList<>();
                int size = queue.size();
                while (size > 0) {
                    int curNode = queue.poll();
                    allPossibleTemp.add(curNode);

                    for (int neighbor : nodeGraph.get(curNode)) {
                        degree[neighbor] --;
                        if (degree[neighbor] == 1) queue.offer(neighbor);
                    }
                    size --;
                }
                allPossibleRoot = allPossibleTemp;
            }
            return allPossibleRoot;
        }
    }
}
