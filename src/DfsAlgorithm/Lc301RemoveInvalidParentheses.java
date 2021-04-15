package DfsAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301RemoveInvalidParentheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            // Corner case
            if (s == null || s.length() == 0) return new ArrayList<>();
            if(s == ""){
                List<String> res = new ArrayList<>();
                res.add("");
                return res;
            }

            int extraLeftParenthese = 0;
            int extraRightParenthese = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') extraLeftParenthese++;
                if (s.charAt(i) == ')') {
                    if (extraLeftParenthese > 0) extraLeftParenthese--;
                    else extraRightParenthese++;
                }
            }

            Set<String> allPossibleResults = new HashSet<>();
            findAllPossibleResults(allPossibleResults, new StringBuilder(), extraLeftParenthese, extraRightParenthese, 0, 0, s);

            return new ArrayList<>(allPossibleResults);
        }

        private void findAllPossibleResults(Set<String> allPossibleResults, StringBuilder singlePath, int extraLeftParenthese, int extraRightParenthese, int delta, int index, String s) {
            // Base case
            if (index == s.length() && extraLeftParenthese == 0 && extraRightParenthese == 0 && delta == 0) {
                allPossibleResults.add(String.valueOf(singlePath));
                return;
            }
            if (index >= s.length() || extraLeftParenthese < 0 || extraRightParenthese < 0 || delta < 0) return;

            char ch = s.charAt(index);
            int len = singlePath.length();

            if (ch == '(') {
                // Don't add '('
                findAllPossibleResults(allPossibleResults, singlePath, extraLeftParenthese - 1, extraRightParenthese, delta, index + 1, s);

                // Add '('
                singlePath.append('(');
                findAllPossibleResults(allPossibleResults, singlePath, extraLeftParenthese, extraRightParenthese, delta + 1, index + 1, s);
                singlePath.setLength(len);
            } else if (ch == ')') {
                // Don't add ')'
                findAllPossibleResults(allPossibleResults, singlePath, extraLeftParenthese, extraRightParenthese - 1, delta, index + 1, s);

                // Add ')'
                singlePath.append(')');
                findAllPossibleResults(allPossibleResults, singlePath, extraLeftParenthese, extraRightParenthese, delta - 1, index + 1, s);
                singlePath.setLength(len);
            } else {
                // Have letter
                singlePath.append(ch);
                findAllPossibleResults(allPossibleResults, singlePath, extraLeftParenthese, extraRightParenthese, delta, index + 1, s);
                singlePath.setLength(len);
            }
        }
    }
}