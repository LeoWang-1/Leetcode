package ArrayAlgorithm;

public class Lc243ShortestWordDistance {
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            // Corner case
            if (wordsDict == null || wordsDict.length == 0) return 0;

            int shortDistance = Integer.MAX_VALUE;
            int indexOfWord1 = -1;
            int indexOfWord2 = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) indexOfWord1 = i;
                if (wordsDict[i].equals(word2)) indexOfWord2 = i;
                if (indexOfWord1 != -1 && indexOfWord2 != -1) {
                    shortDistance = Math.min(shortDistance, Math.abs(indexOfWord1 - indexOfWord2));
                }
            }
            return shortDistance;
        }
    }
}
