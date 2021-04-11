package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc46Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return new ArrayList<>();

            List<List<Integer>> allPermutes = new ArrayList<>();
            findAllPermutes(allPermutes, new ArrayList<>(), nums);

            return allPermutes;
        }

        private void findAllPermutes(List<List<Integer>> allPermutes, List<Integer> singlePath, int[] nums) {
            // Wall
            // Success
            if (singlePath.size() == nums.length) {
                allPermutes.add(new ArrayList<>(singlePath));
                return;
            }

            // Failure
            for (int i = 0; i < nums.length; i++) {
                if (singlePath.contains(nums[i])) continue;
                singlePath.add(nums[i]);
                findAllPermutes(allPermutes, singlePath, nums);
                singlePath.remove(singlePath.size() - 1);
            }

        }
    }
}
