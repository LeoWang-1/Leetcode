package BfsAlgorithm;

import java.util.*;

public class Lc126WordLadderII {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // Corner case
            if(beginWord == endWord) return new ArrayList<>();
            if(beginWord == null || endWord == null) return new ArrayList<>();
            if(wordList == null || wordList.size() == 0) return new ArrayList<>();


            List<List<String>> allShortestPaths = new ArrayList<>();
            Set<String> restWords = new HashSet<>(wordList);
            Set<String> usedWordSameLevel = new HashSet<>();
            Map<String, List<String>> wordGraph = new HashMap<>();
            if (restWords.contains(beginWord)) restWords.remove(beginWord);
            Queue<String> queue = new LinkedList<>();
            boolean found = false;
            queue.offer(beginWord);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    String curWord = queue.poll();
                    char[] curWordLetters = curWord.toCharArray();
                    for (int i = 0; i < curWordLetters.length; i++) {
                        char curLetter = curWordLetters[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            curWordLetters[i] = j;
                            String newWord = String.valueOf(curWordLetters);
                            if (restWords.contains(newWord)) {
                                if (newWord.equals(endWord)) found = true;

                                if (usedWordSameLevel.contains(newWord)) {
                                    List<String> tempList = wordGraph.get(newWord);
                                    tempList.add(curWord);
                                    wordGraph.put(newWord, tempList);
                                } else {
                                    usedWordSameLevel.add(newWord);
                                    List<String> tempList = new ArrayList<>();
                                    tempList.add(curWord);
                                    wordGraph.put(newWord, tempList);
                                    usedWordSameLevel.add(newWord);
                                    queue.offer(newWord);
                                }
                            }
                        }
                        curWordLetters[i] = curLetter;
                    }
                    size --;
                }
                if (found) break;
                restWords.removeAll(usedWordSameLevel);
                usedWordSameLevel.clear();
            }

            findAllPaths(allShortestPaths, new ArrayList<>(), wordGraph, endWord, beginWord);

            return allShortestPaths;
        }

        private void findAllPaths(List<List<String>> allShortestPaths, List<String> singlePath, Map<String, List<String>> wordGraph, String curWord, String beginWord) {
            if (curWord.equals(beginWord)) {
                singlePath.add(0, curWord);
                allShortestPaths.add(new ArrayList<>(singlePath));
                singlePath.remove(0);
                return;
            }

            singlePath.add(0, curWord);
            if (wordGraph.get(curWord) != null) {
                for (String word : wordGraph.get(curWord)) {
                    findAllPaths(allShortestPaths, singlePath, wordGraph, word, beginWord);
                }
            }

            singlePath.remove(0);
        }
    }
}
