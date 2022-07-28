package DataStruct.Stack;

import java.lang.reflect.Array;
import java.util.Iterator;

public class FixedCapacityStack<E> extends Stack<E> {
    private E[] s;
    private int N = 0;

    public FixedCapacityStack(int capacity) {
        s = (E[]) Array.newInstance(Object.class, capacity);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(E item) {
        s[N++] = item;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E temp = s[--N];
        s[N] = null;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new FixedIterator();
    }

    private class FixedIterator implements Iterator<E> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i != 0;
        }

        @Override
        public E next() {
            return s[--i];
        }
    }

    public static void main(String[] args) {
        Stack<String> a = new FixedCapacityStack<>(10);
        a.push("a");
        a.push("b");
        a.push("c");
        a.push("d");
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(a.pop());

    }
}
