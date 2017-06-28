package arrays.iteration;

public class FilterIterator implements Iterator{

    private final Iterator _iterator;
    private final Predicate _predicate;

    public FilterIterator(Iterator underlyingIterator, Predicate predicate) {
        assert underlyingIterator != null : "iterator must not be null";
        assert predicate != null : "predicate must not be null";

        _iterator = underlyingIterator;
        _predicate = predicate;
    }

    public void first() {
        _iterator.first();
        filterForwards();
    }

    public void last() {
        _iterator.last();
        filterBackwards();
    }

    public boolean isDone() {
        return _iterator.isDone();
    }

    public void next() {
        _iterator.next();
        filterForwards();
    }

    public void previous() {
        _iterator.previous();
        filterBackwards();
    }

    private void filterBackwards() {
        while (!_iterator.isDone() && !_predicate.evaluate(_iterator.current())){
            _iterator.previous();
        }
    }

    public Object current() {
            return _iterator.current();
    }

    private void filterForwards(){
        while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current())){
            _iterator.next();
        }
    }
}
