package DfsAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17LetterCombinationsofaPhoneNumber {
    class Solution {
        // Fields
        private Map<Character, String> numToLetter = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            // Corner case
            if (digits == null || digits.length() == 0) return new ArrayList<>();
            if (digits.contains("1")) return new ArrayList<>();

            // Build map
            numToLetter.put('2', "abc");
            numToLetter.put('3', "def");
            numToLetter.put('4', "ghi");
            numToLetter.put('5', "jkl");
            numToLetter.put('6', "mno");
            numToLetter.put('7', "pqrs");
            numToLetter.put('8', "tuv");
            numToLetter.put('9', "wxyz");

            List<String> allCombinations = new ArrayList<>();
            findAllCombinations(allCombinations, new StringBuilder(), digits, 0);
            return allCombinations;
        }

        private void findAllCombinations(List<String> allCombinations, StringBuilder singleStr, String digits, int index) {
            // Base case
            if (index > digits.length() - 1) {
                allCombinations.add(String.valueOf(singleStr));
                return;
            }

            // Next steps
            char num = digits.charAt(index);
            String toLetter = numToLetter.get(num);
            int len = singleStr.length();
            for (int i = 0; i < toLetter.length(); i++) {
                singleStr.append(toLetter.charAt(i));
                findAllCombinations(allCombinations, singleStr, digits, index + 1);
                singleStr.setLength(len);
            }
        }
    }
}
