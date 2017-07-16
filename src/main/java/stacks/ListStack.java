package stacks;


import lists.LinkedList;
import lists.List;
import queues.EmptyQueueException;

public class ListStack implements Stack {

    private final List _list = new LinkedList();

    public void push(Object value) {
        _list.add(value);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _list.delete(size() - 1);
    }

    public Object peek() {
        Object value = pop();
        push(value);
        return value;
    }

    public void enqueue(Object value) {
        push(value);
    }

    public Object dequeue() {
        try {
            return pop();
        } catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
}
