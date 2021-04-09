package BfsAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc339NestedListWeightSum {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            // Corner case
            if (nestedList == null || nestedList.size() == 0) return 0;

            Queue<NestedInteger> queue = new LinkedList<>();
            for (NestedInteger nestedInteger : nestedList) {
                queue.offer(nestedInteger);
            }

            int depthSum = 0;
            int depth = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    NestedInteger curNestedInteger = queue.poll();
                    if (curNestedInteger.isInteger()) {
                        depthSum += depth * curNestedInteger.getInteger();
                    } else {
                        for (NestedInteger nextNestedInteger : curNestedInteger.getList()) {
                            queue.offer(nextNestedInteger);
                        }
                    }
                    size --;
                }
                depth ++;
            }
            return depthSum;
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
