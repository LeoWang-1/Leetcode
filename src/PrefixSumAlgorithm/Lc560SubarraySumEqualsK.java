package PrefixSumAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Lc560SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // Corner case
            if (nums == null || nums.length == 0) return 0;

            Map<Integer, Integer> prefixSum = new HashMap<>();
            int sum = 0;
            int count = 0;
            prefixSum.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (prefixSum.containsKey(sum - k)) {
                    count += prefixSum.get(sum - k);
                }
                prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

            }

            return count;
        }
    }
}
