package StackAlgorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Lc1249MinimumRemovetoMakeValidParentheses {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            // Corner case
            if (s == null || s.length() == 0) return "";

            Set<Integer> removeIndex = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == '(') {
                    stack.push(i);
                } else if (cur == ')') {
                    if (stack.isEmpty()) removeIndex.add(i);
                    else stack.pop();
                }
            }

            while (!stack.isEmpty()) {
                removeIndex.add(stack.pop());
            }

            for (int i = 0; i < s.length(); i++) {
                if (!removeIndex.contains(i)) {
                    res.append(s.charAt(i));
                }
            }
            return res.toString();
        }
    }
}
