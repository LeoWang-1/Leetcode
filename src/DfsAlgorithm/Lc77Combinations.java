package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc77Combinations {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            // Corner case
            if (n == 0 || k == 0) return new ArrayList<>();

            List<List<Integer>> allCombines = new ArrayList<>();
            findAllCombines(allCombines, new ArrayList<>(), n, k, 1);

            return allCombines;
        }

        private void findAllCombines(List<List<Integer>> allCombines, List<Integer> singlePath, int n, int k, int index) {
            // Wall
            // Success
            if (singlePath.size() == k) {
                allCombines.add(new ArrayList<>(singlePath));
                return;
            }

            // Add number
            for (int i = index; i <= n; i++) {
                singlePath.add(i);
                findAllCombines(allCombines, singlePath, n, k, i + 1);
                singlePath.remove(singlePath.size() - 1);
            }
        }
    }
}
