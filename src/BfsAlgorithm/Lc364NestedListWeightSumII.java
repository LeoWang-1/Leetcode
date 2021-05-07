package BfsAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc364NestedListWeightSumII {
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            // Corner case
            if (nestedList == null || nestedList.size() == 0) return 0;

            Queue<NestedInteger> queue = new LinkedList<>();
            queue.addAll(nestedList);
            int sum = 0;
            int curLevelSum = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    NestedInteger cur = queue.poll();
                    if (cur.isInteger()) {
                        curLevelSum += cur.getInteger();
                    } else {
                        for (NestedInteger nestedInteger : cur.getList()) {
                            queue.offer(nestedInteger);
                        }
                        queue.addAll(cur.getList());
                    }
                    size --;
                }
                sum += curLevelSum;
            }
            return sum;
        }
    }

    // Created the NestedInteger class temporarily
    public class NestedInteger{
        public boolean isInteger() {
            return true;
        }

        public int getInteger() {
            return 1;
        }

        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }
}
