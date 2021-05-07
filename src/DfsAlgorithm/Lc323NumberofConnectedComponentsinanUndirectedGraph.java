package DfsAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc323NumberofConnectedComponentsinanUndirectedGraph {
    class Solution {
        public int countComponents(int n, int[][] edges) {
            // Corner case
            if (n == 0) return -1;

            // Build graph
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int firstNum = edge[0];
                int secondNum = edge[1];
                if (graph.containsKey(firstNum)) {
                    graph.get(firstNum).add(secondNum);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(secondNum);
                    graph.put(firstNum, temp);
                }

                if (graph.containsKey(secondNum)) {
                    graph.get(secondNum).add(firstNum);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(firstNum);
                    graph.put(secondNum, temp);
                }
            }

            // DFS
            int res = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    findConnectNodes(i, visited, graph);
                    res ++;
                }
            }

            return res;
        }

        private void findConnectNodes(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
            // Base case
            if (visited[node]) return;
            if (!graph.containsKey(node)) return;

            // Next steps
            visited[node] = true;
            for (int i = 0; i < graph.get(node).size(); i++) {
                findConnectNodes(graph.get(node).get(i), visited, graph);
            }
        }
    }
}
