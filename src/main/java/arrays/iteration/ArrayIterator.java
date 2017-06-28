package arrays.iteration;

public class ArrayIterator implements arrays.iteration.Iterator {

    private final Object[] _array;
    private final int _startPosition;
    private final int _endPosition;
    private int _current = -1;

    public ArrayIterator(Object[] array, int startPosition, int itemCount) {
        assert array != null : "array must contain something";
        assert startPosition >= 0 : "array starting position should be >= 0";
        assert startPosition < array.length : "array end position should be < than array lenght";
        assert itemCount >= 0 : "array item count should be > 0";

        _array = array;
        _startPosition = startPosition;
        _endPosition = startPosition + itemCount - 1;

        assert _endPosition < array.length : "end position cannot be > length";
    }

    public ArrayIterator(Object[] _array) {
        this._array = _array;
        this._startPosition = 0;
        this._endPosition = _array.length - 1;
    }

    public void first() {
        _current = _startPosition;
    }

    public boolean isDone() {
        return _current < _startPosition || _current > _endPosition;
    }

    public Object current() {
        if(isDone()){
            throw new IteratorOutOfBoundsException();
        }
        return _array[_current];
    }

    public void next() {
        ++_current;
    }

    public void last() {
        _current = _endPosition;
    }

    public void previous() {
        --_current;
    }
}
