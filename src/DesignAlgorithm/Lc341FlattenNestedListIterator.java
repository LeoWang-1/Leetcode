package DesignAlgorithm;

import java.util.*;

public class Lc341FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {
        // Fields
        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            findAllNestedInteger(nestedList);
        }

        private void findAllNestedInteger(List<NestedInteger> nestedList) {
            // Base case
            if (nestedList == null || nestedList.size() == 0) return;

            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.add(nestedInteger.getInteger());
                } else {
                    findAllNestedInteger(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) return null;
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
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
