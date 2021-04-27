package BinarySearchAlgorithm;

public class Lc374GuessNumberHigherorLower {
    class Solution {
        public int guessNumber(int n) {
            // Corner case
            if (n == 0) return -1;
            if (n == 1) return 1;

            int left = 1;
            int right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (guess(mid) == 0) return mid;
                else if (guess(mid) < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int guess(int mid) {
            return 0;
        }
    }
}
