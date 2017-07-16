package stacks;

import queues.Queue;

public interface Stack extends Queue {

    void push(Object value);

    Object pop();

    Object peek();

    void clear();

    int size();

    boolean isEmpty();

}
