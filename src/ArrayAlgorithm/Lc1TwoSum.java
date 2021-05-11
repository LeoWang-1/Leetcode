package ArrayAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Lc1TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // Corner case
            if (nums == null || nums.length == 0) return new int[0];

            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                    break;
                }
                map.put(target - nums[i], i);
            }
            return res;
        }
    }
}
