package BinarySearchAlgorithm;

public class Lc74Searcha2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // Corner case
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

            int row = matrix.length;
            int col = matrix[0].length;
            int left = 0;
            int right = (row - 1) * col + col - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int curI = mid / col;
                int curJ = mid % col;
                if (matrix[curI][curJ] == target) return true;
                else if (matrix[curI][curJ] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
