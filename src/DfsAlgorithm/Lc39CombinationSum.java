package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc39CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // Corner case
            if (candidates == null || candidates.length == 0) return new ArrayList<>();

            List<List<Integer>> allCombinationSum = new ArrayList<>();
            findAllCombinations(allCombinationSum, new ArrayList<>(), candidates, target, 0);

            return allCombinationSum;
        }

        private void findAllCombinations(List<List<Integer>> allCombinationSum, List<Integer> singlePath, int[] candidates, int target, int index) {
            // Wall
            // Success
            if (target == 0) {
                allCombinationSum.add(new ArrayList<>(singlePath));
            }

            // Failure
            if (target < 0) return;

            // Add number or not
            for (int i = index; i < candidates.length; i++) {
                singlePath.add(candidates[i]);
                findAllCombinations(allCombinationSum, singlePath, candidates, target - candidates[i], i);
                singlePath.remove(singlePath.size() - 1);
            }
        }
    }
}
