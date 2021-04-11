package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc78Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return new ArrayList<>();

            List<List<Integer>> allSubsets = new ArrayList<>();
            findAllSubsets(allSubsets, new ArrayList<>(), nums, 0);

            return allSubsets;
        }

        private void findAllSubsets(List<List<Integer>> allSubsets, List<Integer> singleSubset, int[] nums, int curIndex) {
            // Wall
            if (curIndex == nums.length) {
                allSubsets.add(new ArrayList<>(singleSubset));
                return;
            }

            // Add number
            singleSubset.add(nums[curIndex]);
            findAllSubsets(allSubsets, singleSubset, nums, curIndex + 1);
            singleSubset.remove(singleSubset.size() - 1);

            // Don't add number
            findAllSubsets(allSubsets, singleSubset, nums, curIndex + 1);
        }
    }
}
