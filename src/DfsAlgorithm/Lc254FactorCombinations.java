package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc254FactorCombinations {
    class Solution {
        public List<List<Integer>> getFactors(int n) {
            // Corner case
            if (n == 0 || n == 1) return new ArrayList<>();

            List<List<Integer>> allCombinations = new ArrayList<>();

            findAllCombinations(allCombinations, new ArrayList<>(), n, 2);
            return allCombinations;
        }

        private void findAllCombinations(List<List<Integer>> allCombinations, List<Integer> single, int n, int index) {
            // Base case
            if (n == 1 && single.size() > 1) {
                allCombinations.add(new ArrayList<>(single));
                return;
            }
            if (n < 1) return;

            // Next step
            for (int i = index; i <= n; i++) {
                if (n % i == 0) {
                    single.add(i);
                    findAllCombinations(allCombinations, single, n / i, i);
                    single.remove(single.size() - 1);
                }
            }
        }
    }
}
