package lists;

import arrays.iteration.Iterator;
import arrays.iteration.IteratorOutOfBoundsException;

public class GenericListIterator implements Iterator{
    private final List _list;
    private int _current;

    public GenericListIterator(List list) {
        assert list != null : "list cannot be null";
        _list = list;
    }

    public void first() {
        _current = 0;
    }

    public void last() {
        _current = _list.size() - 1;
    }

    public boolean isDone() {
        return _current < 0 || _current >= _list.size();
    }

    public void next() {
        _current++;
    }

    public void previous() {
        _current--;
    }

    public Object current() {
        if (isDone()){
            throw new IteratorOutOfBoundsException();
        }
        return _list.get(_current);
    }
}
