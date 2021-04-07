package BfsAlgorithm;

import java.util.*;

public class Lc127WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //Corner Case
            if(beginWord == endWord) return 0;
            if(beginWord == null || endWord == null) return 0;
            if(wordList == null || wordList.size() == 0) return 0;

            Queue<String> queue = new LinkedList<>();
            Set<String> restWords = new HashSet<>(wordList);
            if (restWords.contains(beginWord)) restWords.remove(beginWord);
            queue.offer(beginWord);

            int shortestTransSeq = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    String curWord = queue.poll();
                    char[] letters = curWord.toCharArray();
                    for (int i = 0; i < letters.length; i++) {
                        char tempLetter = letters[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            letters[i] = j;
                            String newWord = String.valueOf(letters);
                            if (restWords.contains(newWord)) {
                                if (newWord.equals(endWord)) return shortestTransSeq + 1;
                                queue.offer(newWord);
                                restWords.remove(newWord);
                            }
                        }
                        letters[i] = tempLetter;
                    }
                    size --;
                }
                shortestTransSeq ++;
            }

            return 0;
        }
    }
}
