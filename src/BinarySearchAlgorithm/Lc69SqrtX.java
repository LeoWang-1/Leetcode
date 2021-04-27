package BinarySearchAlgorithm;

public class Lc69SqrtX {
    class Solution {
        public int mySqrt(int x) {
            // Corner case
            if (x <= 0) return 0;

            long num;
            int left = 1, right = x;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                num = (long)mid * mid;
                if (num == x) return mid;
                else if (num > x) right = mid;
                else left = mid;
            }
            if (left * left < x) return left;
            return right;
        }
    }
}
