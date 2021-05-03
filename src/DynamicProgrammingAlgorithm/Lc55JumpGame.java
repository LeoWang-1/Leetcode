package DynamicProgrammingAlgorithm;

public class Lc55JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return false;

            int len = nums.length;
            boolean[] dp = new boolean[len];
            dp[len - 1] = true;

            for (int i = len - 2; i >= 0; i--) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < len && dp[i + j] == true) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }
}
