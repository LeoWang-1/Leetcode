package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc320GeneralizedAbbreviation {
    class Solution {
        public List<String> generateAbbreviations(String word) {
            // Corner case
            if (word == null || word.length() == 0) return new ArrayList<>();

            List<String> allAbbreviations = new ArrayList<>();
            findAllAbbreviations(allAbbreviations, new StringBuilder(), word, 0, 0);

            return allAbbreviations;
        }

        private void findAllAbbreviations(List<String> allAbbreviations, StringBuilder singlePath, String word, int index, int count) {
            // Base case
            if (index == word.length()) {
                if (count > 0) singlePath.append(count);
                allAbbreviations.add(String.valueOf(singlePath));
                return;
            }

            int len = singlePath.length();
            // Keep the letter
            if (count > 0) singlePath.append(count);
            singlePath.append(word.charAt(index));
            findAllAbbreviations(allAbbreviations, singlePath, word, index + 1, 0);
            singlePath.setLength(len);

            // Change to number
            findAllAbbreviations(allAbbreviations, singlePath, word, index + 1, count + 1);
        }
    }
}
