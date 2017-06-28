package lists;

import arrays.iteration.Iterable;

public interface List extends Iterable {

    void insert(int index, Object value);

    void add(Object value);

    Object delete(int index) throws IndexOutOfBoundsException;

    boolean delete(Object value);

    void clear();

    Object set(int index, Object value);

    Object get(int index);

    int indexOf(Object value);

    boolean contains(Object value);

    int size();

    boolean isEmpty();
}
