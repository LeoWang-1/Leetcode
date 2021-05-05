package BinarySearchAlgorithm;

public class Lc367ValidPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            // Corner case
            if (num < 2) return true;
            long left = 1;
            long right = num / 2;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (num == mid * mid) return true;
                else if (num > mid * mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
