package DfsAlgorithm;

public class Lc79WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            // Corner case
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
            if (word == null || word.length() == 0) return false;

            int row = board.length;
            int col = board[0].length;
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if(findWordSearch(board, word, i, j, 0, visited)) return true;
                    }
                }
            }

            return false;
        }

        private boolean findWordSearch(char[][] board, String word, int index_i, int index_j, int index, boolean[][] visited) {
            // Base case
            if (index == word.length()) return true;
            if (index_i < 0 || index_i >= board.length || index_j < 0 || index_j >= board[0].length || board[index_i][index_j] != word.charAt(index) || visited[index_i][index_j]) return false;

            // Next step
            visited[index_i][index_j] = true;
            boolean tempResult = findWordSearch(board, word, index_i + 1, index_j, index + 1, visited)
                    || findWordSearch(board, word, index_i - 1, index_j, index + 1, visited)
                    || findWordSearch(board, word, index_i, index_j + 1, index + 1, visited)
                    || findWordSearch(board, word, index_i, index_j - 1, index + 1, visited);

            // Set back
            visited[index_i][index_j] = false;

            return tempResult;
        }
    }
}
