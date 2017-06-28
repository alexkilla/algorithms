package arrays.iteration;

public class ReverseIterator implements Iterator{

    private final ArrayIterator _arrayIterator;

    public ReverseIterator(ArrayIterator arrayIterator) {
         _arrayIterator = arrayIterator;
    }

    public void first() {
        _arrayIterator.last();
    }

    public boolean isDone() {
        return _arrayIterator.isDone();
    }


    public Object current() {
        return _arrayIterator.current();
    }

    public void next() {
        _arrayIterator.previous();
    }

    public void last() {
        _arrayIterator.first();
    }

    public void previous() {
        _arrayIterator.next();
    }
}
