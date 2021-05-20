package ProbabilityAlgorithm;

public class Lc528RandomPickwithWeight {
    class Solution {
        // Fields
        int[] weight;
        int totalWeight;

        public Solution(int[] w) {
            // Corner case
            if (w == null || w.length == 0) return;

            this.weight = new int[w.length];
            int totalSum = 0;
            for (int i = 0; i < w.length; i++) {
                totalSum += w[i];
                this.weight[i] = totalSum;
            }
            this.totalWeight = totalSum;
        }

        public int pickIndex() {
            double targetNum = Math.random() * totalWeight;
            int left = 0;
            int right = weight.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (weight[mid] < targetNum) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }
}
