package StackAlgorithm;

import java.util.Stack;

public class Lc402RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            // Corner case
            if (num == null || num.length() == 0) return "0";
            if (k >= num.length()) return "0";

            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (int i = 0; i < num.length(); i++) {
                while (!stack.isEmpty() && stack.peek() > num.charAt(i) && count < k) {
                    stack.pop();
                    count ++;
                }
                stack.push(num.charAt(i));
            }

            while (count < k) {
                stack.pop();
                count ++;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }

            return sb.toString().replaceFirst("^0+(?!$)", "");
        }
    }
}
