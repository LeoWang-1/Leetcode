package StackAlgorithm;

public class Lc20ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            // Corner case
            if (s == null || s.length() == 0) return true;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.push(temp);
                } else if (temp == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                } else if (temp == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                } else {
                    if (temp == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
