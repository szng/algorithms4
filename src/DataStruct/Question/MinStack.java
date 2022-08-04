package DataStruct.Question;
/*
leetcode 155
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinStack {
    private PriorityQueue<Integer> MinValue;
    private Deque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
        MinValue = new PriorityQueue<>();
    }

    public void push(int val) {
        MinValue.offer(val);
        stack.push(val);
    }

    public void pop() {
        Integer t = stack.pop();
        MinValue.remove(t);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MinValue.peek();
    }

    public static void main(String[] args) {
        MinStack a = new MinStack();
        a.push(5);
        a.push(3);
        a.push(4);
        a.getMin();
        a.pop();
        a.pop();
        a.top();
        a.getMin();
    }
}
