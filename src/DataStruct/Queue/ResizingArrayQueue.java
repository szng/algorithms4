package DataStruct.Queue;

import java.lang.reflect.Array;

public class ResizingArrayQueue<E> extends Queue<E> {
    private E[] s;
    private int first, last;

    public ResizingArrayQueue() {
        s = (E[]) new Object[2];
    }

    private void resize(int capacity) {
        E[] copy = (E[]) Array.newInstance(Object.class, capacity);
        int i = 0;
        while ((first % s.length) != last) {
            copy[i++] = s[first++];
        }
        first = 0;
        last = i;
        s = copy;
    }

    @Override
    public void enqueue(E item) {
        if ((last + 1) % s.length == first) {
            resize(2 * s.length);
        }
        s[last] = item;
        last = (last + 1) % s.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E item = s[first];
        first = (first + 1) % s.length;
        if ((last + s.length - first) % s.length == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == last;
    }

    public static void main(String[] args) {
        Queue<String> a = new ResizingArrayQueue<>();
        System.out.println(a.dequeue());
        a.enqueue("abc");
        System.out.println(a.dequeue());
        a.enqueue("abc");
        System.out.println(a.dequeue());
        a.enqueue("abc");
        System.out.println(2/4);
    }
}
