package DataStruct.Queue;

public class LinkedQueue<E> extends Queue<E> {
    private Node first, last;

    private class Node {
        E item;
        Node next;
    }

    @Override
    public void enqueue(E item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Queue<String> a = new LinkedQueue<>();
        System.out.println(a.dequeue());
        a.enqueue("abc");
        System.out.println(a.dequeue());
    }
}
