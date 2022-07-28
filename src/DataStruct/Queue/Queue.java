package DataStruct.Queue;

public abstract class Queue<E> {
    public abstract void enqueue(E item);

    public abstract E dequeue();

    public abstract boolean isEmpty();
}
