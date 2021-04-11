package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc22GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            // Corner case
            if (n == 0) return new ArrayList<>();

            List<String> allParenthesis = new ArrayList<>();
            buildAllParenthesis(allParenthesis, new StringBuilder(), 0, 0, n);

            return allParenthesis;
        }

        private void buildAllParenthesis(List<String> allParenthesis, StringBuilder singlePath, int leftNum, int rightNum, int n) {
            // Wall
            // Success
            if (leftNum == n && rightNum == n) {
                allParenthesis.add(String.valueOf(singlePath));
                return;
            }

            // Failure
            if (rightNum - leftNum > 0 || leftNum > n || rightNum > n) {
                return;
            }

            int len = singlePath.length();
            // Append "("
            singlePath.append("(");
            buildAllParenthesis(allParenthesis, singlePath, leftNum + 1, rightNum, n);
            singlePath.setLength(len);

            // Append ")"
            singlePath.append(")");
            buildAllParenthesis(allParenthesis, singlePath, leftNum, rightNum + 1, n);
            singlePath.setLength(len);
        }
    }
}
