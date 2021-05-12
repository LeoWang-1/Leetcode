package SudokuAlgorithm;

public class Lc37SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            // Corner case
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;

            solveSudokuHelper(board);
        }

        private boolean solveSudokuHelper(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j ++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c ++) {
                            if (isValid(i, j, board, c)) {
                                board[i][j] = c;
                                if (solveSudokuHelper(board)) return true;
                                else board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(int row, int col, char[][] board, char c) {
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.' && board[row][i] == c) return false;
                if (board[i][col] != '.' && board[i][col] == c) return false;
                if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row /3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
            }
            return true;
        }
    }
}
