package DataStruct.Stack;

public abstract class Stack<E> implements Iterable<E> {
    public abstract void push(E item);

    public abstract E pop();

    public abstract boolean isEmpty();
}
