package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc216CombinationSumIII {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            // Corner case
            if (k == 0 || n == 0) return new ArrayList<>();

            List<List<Integer>> allCombinations = new ArrayList<>();
            findAllCombinations(allCombinations, new ArrayList<>(), k, n, 1);

            return allCombinations;
        }

        private void findAllCombinations(List<List<Integer>> allCombinations, List<Integer> singlePath, int k, int n, int curNum) {
            // Wall
            // Success
            if (singlePath.size() == k && n == 0) {
                allCombinations.add(new ArrayList<>(singlePath));
                return;
            }

            // Failure
            if (singlePath.size() > k || n < 0) return;

            // Add number or not
            for (int i = curNum; i <= 9; i++) {
                singlePath.add(i);
                findAllCombinations(allCombinations, singlePath, k, n - i, i + 1);
                singlePath.remove(singlePath.size() - 1);
            }
        }
    }
}
