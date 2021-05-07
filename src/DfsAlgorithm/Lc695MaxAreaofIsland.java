package DfsAlgorithm;

public class Lc695MaxAreaofIsland {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            // Corner case
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];

            int maxArea = Integer.MIN_VALUE;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        int curArea = findConnectLands(i, j, grid, visited);
                        maxArea = Math.max(maxArea, curArea);
                    }
                }
            }
            if (maxArea == Integer.MIN_VALUE) return 0;
            return maxArea;
        }

        private int findConnectLands(int indexI, int indexJ, int[][] grid, boolean[][] visited) {
            // Base case
            if (indexI < 0 || indexI >= grid.length || indexJ < 0 || indexJ >= grid[0].length || grid[indexI][indexJ] != 1 || visited[indexI][indexJ]) return 0;

            // Next step
            visited[indexI][indexJ] = true;

            return findConnectLands(indexI + 1, indexJ, grid, visited) +
                    findConnectLands(indexI - 1, indexJ, grid, visited) +
                    findConnectLands(indexI, indexJ + 1, grid, visited) +
                    findConnectLands(indexI, indexJ - 1, grid, visited) + 1;
        }
    }
}
