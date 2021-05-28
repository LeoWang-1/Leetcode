package DfsAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc47PermutationsII {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return new ArrayList<>();

            Arrays.sort(nums);
            List<List<Integer>> allUniquePermute = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            findAllUniquePermute(allUniquePermute, new ArrayList<>(), nums, visited);

            return allUniquePermute;
        }

        private void findAllUniquePermute(List<List<Integer>> allUniquePermute, List<Integer> single, int[] nums, boolean[] visited) {
            // Base case
            if (single.size() == nums.length) {
                allUniquePermute.add(new ArrayList<>(single));
                return;
            }

            // Current stage
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                single.add(nums[i]);
                visited[i] = true;
                findAllUniquePermute(allUniquePermute, single, nums, visited);
                single.remove(single.size() - 1);
                visited[i] = false;
            }
        }
    }
}
