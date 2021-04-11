package DfsAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc40CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // Corner case
            if (candidates == null || candidates.length == 0) return new ArrayList<>();

            List<List<Integer>> allCombinations = new ArrayList<>();
            Arrays.sort(candidates);
            findAllConbinations(allCombinations, new ArrayList<>(), candidates, target, 0);

            return allCombinations;
        }

        private void findAllConbinations(List<List<Integer>> allCombinations, List<Integer> singlePath, int[] candidates, int target, int index) {
            // Wall
            // Success
            if (target == 0) {
                allCombinations.add(new ArrayList<>(singlePath));
            }

            // Failure
            if (target < 0) return;

            // Add number or not
            for (int i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] == candidates[i - 1]) continue;
                singlePath.add(candidates[i]);
                findAllConbinations(allCombinations, singlePath, candidates, target - candidates[i], i + 1);
                singlePath.remove(singlePath.size() - 1);
            }
        }
    }
}
