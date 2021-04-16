package BfsAlgorithm;

import java.util.*;

public class Lc269AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            // Corner case
            if (words == null || words.length == 0) return "";

            // Build graph
            Map<Character, List<Character>> graph = new HashMap<>();
            Map<Character, Integer> indegree = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                char[] wordLetters = word.toCharArray();
                for (char unit : wordLetters) {
                    graph.put(unit, new ArrayList<>());
                    indegree.put(unit, 0);
                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                String firstWord = words[i];
                String secondWord = words[i + 1];

                if (firstWord.length() > secondWord.length() && firstWord.startsWith(secondWord)) return "";

                for (int j = 0; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                    if (firstWord.charAt(j) != secondWord.charAt(j)) {
                        graph.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                        indegree.put(secondWord.charAt(j), indegree.get(secondWord.charAt(j)) + 1);
                        break;
                    }
                }
            }

            // Find order
            StringBuilder result = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (char ch : indegree.keySet()) {
                if (indegree.get(ch) == 0) {
                    queue.offer(ch);
                }
            }

            if (queue.isEmpty()) return "";

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    char curLetter = queue.poll();
                    result.append(curLetter);
                    List<Character> list = graph.get(curLetter);
                    for (char nextLetter : list) {
                        indegree.put(nextLetter, indegree.get(nextLetter) - 1);
                        if (indegree.get(nextLetter).equals(0)) {
                            queue.offer(nextLetter);
                        }
                    }
                    size--;
                }
            }

            if (result.length() < indegree.size()) return "";

            return String.valueOf(result);
        }
    }
}
