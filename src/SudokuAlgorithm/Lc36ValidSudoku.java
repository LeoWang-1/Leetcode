package SudokuAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Lc36ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Corner case
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;

            for (int i = 0; i < 9; i++) {
                Set<Character> row = new HashSet<>();
                Set<Character> col = new HashSet<>();
                Set<Character> cube = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                    if (board[j][i] != '.' && !col.add(board[j][i])) return false;

                    int cubeRowIndex = 3 * (i / 3);
                    int cubeColIndex = 3 * (i % 3);
                    if (board[cubeRowIndex + j / 3][cubeColIndex + j % 3] != '.' && !cube.add(board[cubeRowIndex + j / 3][cubeColIndex + j % 3])) return false;
                }
            }
            return true;
        }
    }
}
