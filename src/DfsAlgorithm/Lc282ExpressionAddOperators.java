package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc282ExpressionAddOperators {
    class Solution {
        public List<String> addOperators(String num, int target) {
            // Corner case
            if (num == null || num.length() == 0) return new ArrayList<>();

            List<String> allOperators = new ArrayList<>();
            findAllOperators(allOperators, new StringBuilder(), num, target, 0);

            return allOperators;
        }

        private void findAllOperators(List<String> allOperators, StringBuilder singlePath, String num, int target, int index) {
            // Base case
            if (index == num.length()) {
                if (calculator(String.valueOf(singlePath)) == target) {
                    allOperators.add(String.valueOf(singlePath));
                    return;
                }
            }

            // Next step
            int len = singlePath.length();
            for (int i = index + 1; i < num.length(); i++) {
                long value = Long.valueOf(num.substring(index, i));
                if (singlePath.length() == 0) {
                    singlePath.append(value);
                    findAllOperators(allOperators, singlePath, num, target, i);
                    singlePath.setLength(len);
                } else {
                    // +
                    singlePath.append("+" + value);
                    findAllOperators(allOperators, singlePath, num, target, i);
                    singlePath.setLength(len);

                    // -
                    singlePath.append("-" + value);
                    findAllOperators(allOperators, singlePath, num, target, i);
                    singlePath.setLength(len);

                    // *
                    singlePath.append("*" + value);
                    findAllOperators(allOperators, singlePath, num, target, i);
                    singlePath.setLength(len);
                }
                if (value == 0) break;
            }
        }

        private int calculator(String str) {
            // Corner case
            if (str == null || str.length() == 0) return 0;

            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            char sign = '+';
            int num = 0;

            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    num = str.charAt(i) - '0';
                    while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                        num = num * 10 + str.charAt(i + 1) - '0';
                        i ++;
                    }
                }
                if (!Character.isDigit(str.charAt(i)) || i == str.length() - 1) {
                    if (sign == '+') stack.push(num);
                    if (sign == '-') stack.push(-num);
                    if (sign == '*') stack.push(stack.pop() * num);
                    sign = str.charAt(i);
                    num = 0;
                }
            }
            for (int number : stack) {
                sum += number;
                if (sum <= Integer.MIN_VALUE || sum > Integer.MAX_VALUE) return 0;
            }

            return sum;
        }
    }
}
