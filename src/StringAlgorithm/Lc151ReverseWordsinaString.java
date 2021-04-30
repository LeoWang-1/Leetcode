package StringAlgorithm;

public class Lc151ReverseWordsinaString {
    class Solution {
        public String reverseWords(String s) {
            // Corner case
            if (s == null || s.length() == 0) return "";

            StringBuilder reversedWord = new StringBuilder();
            String[] processedStr = s.trim().split("\\s+");

            for (int i = processedStr.length - 1; i >= 0; i--) {
                reversedWord.append(processedStr[i]);
                reversedWord.append(" ");
            }

            return reversedWord.toString().trim();
        }
    }
}
