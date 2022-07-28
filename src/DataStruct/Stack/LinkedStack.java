package DataStruct.Stack;

import java.util.Iterator;

public class LinkedStack<E> extends Stack<E> implements Iterable<E> {
    private Node first = null;

    private class Node {
        E item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(E item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedStack<String> a = new LinkedStack<>();
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
