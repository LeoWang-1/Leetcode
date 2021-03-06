package DynamicProgrammingAlgorithm;

public class Lc53MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
