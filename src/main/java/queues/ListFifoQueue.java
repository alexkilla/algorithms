package queues;


import lists.LinkedList;
import lists.List;

public class ListFifoQueue implements Queue {

    private final List _list;

    public ListFifoQueue(List list) {
        assert list != null : "list cannot be null";
        _list = list;
    }

    public ListFifoQueue() {
        this(new LinkedList());
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() {
        if (isEmpty()){
            throw new EmptyQueueException();
        }
        return _list.delete(0);
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
