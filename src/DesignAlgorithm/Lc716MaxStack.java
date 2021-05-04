package DesignAlgorithm;

import java.util.Stack;

public class Lc716MaxStack {
    class MaxStack {
        // Fields
        private Stack<Integer> stack;
        private Stack<Integer> maxStack;

        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (maxStack.isEmpty()) maxStack.push(x);
            else {
                if (maxStack.peek() < x) maxStack.push(x);
                else maxStack.push(maxStack.peek());
            }
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int maxNum = maxStack.peek();
            Stack<Integer> temp = new Stack<>();
            while (top() != maxNum) {
                temp.push(pop());
            }
            pop();
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            return maxNum;
        }
    }
}
