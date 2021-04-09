package BfsAlgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lc752OpentheLock {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>();
            for (String deadNum : deadends) deadSet.add(deadNum);
            // Corner case
            if (deadSet.contains("0000")) return -1;
            if (target.equals("0000")) return 0;

            Set<String> usedNums = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            usedNums.add("0000");
            queue.offer("0000");

            int steps = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    String curNum = queue.poll();
                    char[] curNumDigits = curNum.toCharArray();
                    for (int i = 0; i < curNumDigits.length; i++) {
                        for (int j = -1; j <= 1; j += 2) {
                            int changedNum = (curNumDigits[i] - '0' + j + 10) % 10;
                            String newNum = curNum.substring(0, i) + String.valueOf(changedNum) + curNum.substring(i + 1);
                            if (newNum.equals(target)) return steps;
                            if (deadSet.contains(newNum) || usedNums.contains(newNum)) continue;
                            queue.offer(newNum);
                            usedNums.add(newNum);
                        }
                    }
                    size --;
                }
                steps ++;
            }
            return -1;
        }
    }
}
