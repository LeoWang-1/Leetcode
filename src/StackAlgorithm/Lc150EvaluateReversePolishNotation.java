package StackAlgorithm;

import java.util.Stack;

public class Lc150EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            // Corner case
            if (tokens == null || tokens.length == 0) return 0;

            Stack<Integer> stack = new Stack<>();
            for (String str : tokens) {
                int num1 = 0;
                int num2 = 0;
                if (str.equals("+")) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                } else if (str.equals("-")) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                } else if (str.equals("*")) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                } else if (str.equals("/")) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                } else {
                    stack.push(Integer.parseInt(str));
                }
            }
            return stack.pop();
        }
    }
}
