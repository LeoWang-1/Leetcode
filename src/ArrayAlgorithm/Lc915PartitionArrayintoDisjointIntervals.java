package ArrayAlgorithm;

public class Lc915PartitionArrayintoDisjointIntervals {
    class Solution {
        public int partitionDisjoint(int[] A) {
            // Corner case
            if (A == null || A.length == 0) return -1;

            int[] maxLeft = new int[A.length];
            int[] minRight = new int[A.length];

            int max = A[0];
            for (int i = 0; i < A.length; i++) {
                max = Math.max(max, A[i]);
                maxLeft[i] = max;
            }

            int min = A[A.length - 1];
            for (int i = A.length - 1; i >= 0; i--) {
                min = Math.min(min, A[i]);
                minRight[i] = min;
            }

            for (int i = 0; i < A.length - 1; i++) {
                if (maxLeft[i] <= minRight[i + 1]) return i + 1;
            }

            return -1;
        }
    }
}
