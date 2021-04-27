package BinarySearchAlgorithm;

public class Lc278FirstBadVersion {
    class solution {
        public int firstBadVersion(int n) {
            // Corner case
            if (n == 0) return -1;

            int left = 1;
            int right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean isBadVersion(int mid) {
            return true;
        }
    }
}
