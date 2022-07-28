package DataStruct.Stack;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ResizingArrayStack<E> extends Stack<E> {
    private E[] s;
    private int N = 0;

    public ResizingArrayStack() {
        s = (E[]) Array.newInstance(Object.class, 1);
    }

    private void resize(int capacity) {
        E[] copy = (E[]) Array.newInstance(Object.class, capacity);
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    @Override
    public void push(E item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ResizingIterator();
    }

    private class ResizingIterator implements Iterator<E> {
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
        Stack<String> a = new ResizingArrayStack<>();
        a.push("a");
        a.push("b");
        a.push("c");
        a.push("d");
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(a.pop());
        System.out.println(a.getClass());
    }
}
