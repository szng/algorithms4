package DataStruct.Question;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> deque1;
    private Deque<Integer> deque2;

    public MyQueue() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int x) {
        deque1.push(x);
    }

    public int pop() {
        if (!deque2.isEmpty()) {
            return deque2.pop();
        }
        while (!deque1.isEmpty()) {
            deque2.push(deque1.pop());
        }
        return deque2.pop();
    }

    public int peek() {
        if (!deque2.isEmpty()) {
            return deque2.peek();
        }
        while (!deque1.isEmpty()) {
            deque2.push(deque1.pop());
        }
        return deque2.peek();
    }

    public boolean empty() {
        return deque1.isEmpty() && deque2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();
        queue.pop();
        queue.peek();
        queue.pop();
    }
}
