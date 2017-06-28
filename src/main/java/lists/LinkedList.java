package lists;

import arrays.iteration.Iterator;
import arrays.iteration.IteratorOutOfBoundsException;

public class LinkedList extends AbstractList{

    private final Element _headAndTail = new Element(null);
    private int _size;

    public LinkedList() {
        clear();
    }

    public void insert(int index, Object value) {
        assert value != null : "value should not be null";

        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }

        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }

    private void checkIndexOutOfBounds(int index) {
        if (isIndexOutOfBound(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isIndexOutOfBound(int index) {
        return index < 0 || index >= _size;
    }

    private Element getElement(int index) {

        Element element = _headAndTail.getNext();
        for (int i = index; i > 0; i--) {
            element = element.getNext();
        }
        return element;
    }

    public void add(Object value) {
        insert(_size, value);
    }

    public Object delete(int index) {
        checkIndexOutOfBounds(index);
        Element element = getElement(index);
        element.detach();
        _size--;
        return element.getValue();
    }

    public boolean delete(Object value) {
        Element found = getElementByValue(value);
        if (found == null) {
            return false;
        }
        found.detach();
        _size--;
        return true;
    }

    private Element getElementByValue(Object value) {
        Element element = _headAndTail.getNext();
        for (int i = 0; i < _size; i++) {
            if (element.getValue() == value) {
                return element;
            }
            element = element.getNext();
        }
        return null;
    }

    public void clear() {
        _headAndTail.setNext(_headAndTail);
        _headAndTail.setPrevious(_headAndTail);
        _size = 0;
    }

    public Object set(int index, Object value) {
        checkIndexOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public Object get(int index) {
        checkIndexOutOfBounds(index);
        return getElement(index).getValue();
    }

    public int indexOf(Object value) {
        Element element = _headAndTail.getNext();
        for (int i = 0; i < _size; i++) {
            if (value.equals(element.getValue())) {
                return i;
            }
            element = element.getNext();
        }
        return -1;
    }


    public boolean contains(Object value) {
        return indexOf(value) < 0 ? false : true;
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public Iterator iterator() {
        return new ValueIterator();
    }

    private final class ValueIterator implements Iterator {

        private Element current = _headAndTail;

        public void first() {
            current = _headAndTail.getNext();
        }

        public void last() {
            current = _headAndTail.getPrevious();
        }

        public boolean isDone() {
            return current == _headAndTail;
        }

        public void next() {
            current = current.getNext();
        }

        public void previous() {
            current = current.getPrevious();
        }

        public Object current() {
            if(isDone()){
                throw new IteratorOutOfBoundsException();
            }
            return current.getValue();
        }
    }
}
