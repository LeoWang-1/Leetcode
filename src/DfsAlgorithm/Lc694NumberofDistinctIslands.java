package DfsAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Lc694NumberofDistinctIslands {
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            // Corner case
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            Set<String> distinctIslands = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        String path = findDistinctIslands(grid, i, j, visited, "S");
                        distinctIslands.add(path);
                    }
                }
            }
            return distinctIslands.size();
        }

        private String findDistinctIslands(int[][] grid, int indexI, int indexJ, boolean[][] visited, String direction) {
            // Base case
            if (indexI < 0 || indexI >= grid.length || indexJ < 0 || indexJ >= grid[0].length || grid[indexI][indexJ] == 0 || visited[indexI][indexJ]) return "E";

            visited[indexI][indexJ] = true;

            String left = findDistinctIslands(grid, indexI , indexJ - 1, visited, "L");
            String right = findDistinctIslands(grid, indexI, indexJ + 1, visited, "R");
            String up = findDistinctIslands(grid, indexI - 1, indexJ, visited, "U");
            String down = findDistinctIslands(grid, indexI + 1, indexJ, visited, "D");

            return direction + left + right + up + down;
        }
    }
}
