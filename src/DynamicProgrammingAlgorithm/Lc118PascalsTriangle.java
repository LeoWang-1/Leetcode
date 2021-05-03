package DynamicProgrammingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc118PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // Corner case
            if (numRows == 0) return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            res.add(temp);

            for (int i = 1; i < numRows; i++) {
                List<Integer> curRow = new ArrayList<>();
                List<Integer> preRow = res.get(i - 1);
                curRow.add(1);
                for (int j = 1; j < i; j++) {
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
                curRow.add(1);
                res.add(curRow);
            }
            return res;
        }
    }
}
