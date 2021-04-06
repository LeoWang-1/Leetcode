package BfsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Lc286WallsandGates {
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            // Corner case
            if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;

            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int row = rooms.length;
            int col = rooms[0].length;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    if (rooms[i][j] == 0) queue.offer(i * col + j);
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
                        if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col && rooms[next_i][next_j] == Integer.MAX_VALUE) {
                            rooms[next_i][next_j] = distance;
                            queue.offer(next_i * col + next_j);
                        }
                    }

                    size --;
                }

                distance ++;
            }
        }
    }
}
