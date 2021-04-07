package BfsAlgorithm;

import java.util.*;

public class Lc417PacificAtlanticWaterFlow {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            // Corner case
            if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
                return new ArrayList<>();
            }

            int row = heights.length;
            int col = heights[0].length;
            boolean[][] toPacificSucceed = new boolean[row][col];
            boolean[][] toAtlanticSucceed = new boolean[row][col];
            Queue<Integer> queue = new LinkedList<>();
            List<List<Integer>> toPacificAtlantic = new ArrayList<>();

            // Check Pacific Ocean
            for (int j = 0; j < col; j++) {
                toPacificSucceed[0][j] = true;
                queue.offer(0 * col + j);
            }

            for (int i = 0; i< row; i++) {
                toPacificSucceed[i][0] = true;
                queue.offer(i * col + 0);
            }

            isValidToOcean(queue, heights, toPacificSucceed);
            queue.clear();

            // Check Atlantic Ocean
            for (int j = 0; j < col; j++) {
                toAtlanticSucceed[row - 1][j] = true;
                queue.offer((row - 1) * col + j);
            }

            for (int i = 0; i < row; i++) {
                toAtlanticSucceed[i][col - 1] = true;
                queue.offer(i * col + (col - 1));
            }

            isValidToOcean(queue, heights, toAtlanticSucceed);

            for (int i = 0; i < toPacificSucceed.length; i++) {
                for (int j = 0; j < toPacificSucceed[i].length; j++) {
                    if (toPacificSucceed[i][j] && toAtlanticSucceed[i][j]) {
                        toPacificAtlantic.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }

            return toPacificAtlantic;
        }

        private void isValidToOcean(Queue<Integer> queue, int[][] heights, boolean[][] toOceanSucceed) {
            int row = heights.length;
            int col = heights[0].length;
            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0 , -1}};

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int curPos = queue.poll();
                    int cur_i = curPos / col;
                    int cur_j = curPos % col;
                    toOceanSucceed[cur_i][cur_j] = true;
                    for (int i = 0; i < direction.length; i++) {
                        int next_i = cur_i + direction[i][0];
                        int next_j = cur_j + direction[i][1];
                        if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col && heights[cur_i][cur_j] <= heights[next_i][next_j] && !toOceanSucceed[next_i][next_j]) {
                            queue.offer(next_i * col + next_j);
                        }
                    }
                    size --;
                }
            }
        }
    }
}
