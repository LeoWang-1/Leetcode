package BfsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Lc317ShortestDistancefromAllBuildings {
    class Solution {
        public int shortestDistance(int[][] grid) {
            // Corner case
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;

            int row = grid.length;
            int col = grid[0].length;
            int[][] distanceSum = new int[row][col];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        updateDistanceSum(i, j, grid, distanceSum);
                    }
                }
            }

            int shortestDistance = Integer.MAX_VALUE;
            for (int i = 0; i < distanceSum.length; i++) {
                for (int j = 0; j < distanceSum[i].length; j++) {
                    if (grid[i][j] == 0 && distanceSum[i][j] != 0) {
                        shortestDistance = Math.min(shortestDistance, distanceSum[i][j]);
                    }
                }
            }

            if (shortestDistance == Integer.MAX_VALUE) return -1;
            return shortestDistance;
        }

        private void updateDistanceSum(int index_i, int index_j, int[][] grid, int[][] distanceSum) {
            Queue<Integer> queue = new LinkedList<>();
            int row = grid.length;
            int col = grid[0].length;
            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            boolean[][] visited = new boolean[row][col];
            queue.offer(index_i * col + index_j);

            int distance = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int curPos = queue.poll();
                    int cur_i = curPos / col;
                    int cur_j = curPos % col;
                    for (int i = 0; i < direction.length; i++) {
                        int next_i = cur_i + direction[i][0];
                        int next_j = cur_j + direction[i][1];
                        if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col && grid[next_i][next_j] == 0 && !visited[next_i][next_j]) {
                            distanceSum[next_i][next_j] += distance;
                            queue.offer(next_i * col + next_j);
                            visited[next_i][next_j] = true;
                        }
                    }
                    size --;
                }
                distance ++;
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0 && !visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }
        }
    }
}
