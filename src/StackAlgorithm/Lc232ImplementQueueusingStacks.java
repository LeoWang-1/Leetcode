package StackAlgorithm;

import java.util.Stack;

public class Lc232ImplementQueueusingStacks {
    class MyQueue {
        // Fields
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.isEmpty() ? null : stackOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.isEmpty() ? null : stackOut.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
