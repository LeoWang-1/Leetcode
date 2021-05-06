package DesignAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1188DesignBoundedBlockingQueue {
    class BoundedBlockingQueue {
        // Fields
        private Queue<Integer> queue;
        private int capacity;
        private final Object mutex = new Object();

        public BoundedBlockingQueue(int capacity) {
            queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public void enqueue(int element) throws InterruptedException {
            synchronized(mutex) {
                while (size() >= capacity) {
                    mutex.wait();
                }
                queue.add(element);
                mutex.notifyAll();
            }
        }

        public int dequeue() throws InterruptedException {
            int removeNum;
            synchronized(mutex) {
                while (size() <= 0) {
                    mutex.wait();
                }
                removeNum = queue.remove();
                mutex.notifyAll();
            }
            return removeNum;
        }

        public int size() {
            return queue.size();
        }
    }
}
