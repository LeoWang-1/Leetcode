package DesignAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc244ShortestWordDistanceII {
    class WordDistance {
        // Fields
        private Map<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            // Corner case
            if (wordsDict == null || wordsDict.length == 0) return;

            map = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                if (map.containsKey(wordsDict[i])) {
                    map.get(wordsDict[i]).add(i);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.put(wordsDict[i], temp);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> indexWord1 = map.get(word1);
            List<Integer> indexWord2 = map.get(word2);

            int startWord1 = 0;
            int startWord2 = 0;
            int minDistance = Integer.MAX_VALUE;

            while (startWord1 < indexWord1.size() && startWord2 < indexWord2.size()) {
                minDistance = Math.min(minDistance, Math.abs(indexWord1.get(startWord1) - indexWord2.get(startWord2)));
                if (indexWord1.get(startWord1) <= indexWord2.get(startWord2)) {
                    startWord1 ++;
                } else {
                    startWord2 ++;
                }
            }

            return minDistance;
        }
    }
}
