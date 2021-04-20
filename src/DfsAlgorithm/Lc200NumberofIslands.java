package DfsAlgorithm;

public class Lc200NumberofIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            // Corner case
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];

            int numIslands = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        findNumIsland(grid, i, j, visited);
                        numIslands++;
                    }
                }
            }
            return numIslands;
        }

        private void findNumIsland(char[][] grid, int indexI, int indexJ, boolean[][] visited) {
            // Base case
            if (indexI < 0 || indexI >= grid.length || indexJ < 0 || indexJ >= grid[0].length || grid[indexI][indexJ] == '0' || visited[indexI][indexJ]) return;

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            visited[indexI][indexJ] = true;
            for (int i = 0; i < directions.length; i++) {
                findNumIsland(grid, indexI + directions[i][0], indexJ + directions[i][1], visited);
            }
        }
    }
}
