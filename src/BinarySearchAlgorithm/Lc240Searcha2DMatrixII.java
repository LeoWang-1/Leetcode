package BinarySearchAlgorithm;

public class Lc240Searcha2DMatrixII {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // Corner case
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

            int row = matrix.length;
            int col = matrix[0].length;
            int x = row - 1;
            int y = 0;
            while (x >= 0 && y <= col - 1) {
                if (matrix[x][y] == target) return true;
                else if (matrix[x][y] > target) x -= 1;
                else y += 1;
            }
            return false;
        }
    }
}
