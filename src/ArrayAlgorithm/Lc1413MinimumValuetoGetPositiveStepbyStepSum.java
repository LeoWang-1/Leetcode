package ArrayAlgorithm;

public class Lc1413MinimumValuetoGetPositiveStepbyStepSum {
    class Solution {
        public int minStartValue(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return -1;

            int sum=0;
            int min=0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                min = Math.min(min, sum);
            }

            return 1 - min;
        }
    }
}
