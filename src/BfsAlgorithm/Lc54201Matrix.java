package BfsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Lc54201Matrix {
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            // Corner case
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new int[0][0];
            }

            Queue<Integer> queue = new LinkedList<>();
            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) queue.offer(i * col + j);
                    else matrix[i][j] = Integer.MAX_VALUE;
                }
            }

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
                        if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col && matrix[next_i][next_j] == Integer.MAX_VALUE) {
                            matrix[next_i][next_j] = distance;
                            queue.offer(next_i * col + next_j);
                        }
                    }

                    size --;
                }

                distance ++;
            }

            return matrix;
        }
    }
}
