package lists;

import arrays.iteration.ArrayIterator;
import arrays.iteration.Iterator;

public class ArrayList extends AbstractList{

    private static int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] _array;
    private int _capacity;
    private int _size;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        assert initialCapacity > 0 : "Initial capacity should be greater than 0";
        _capacity = initialCapacity;
        clear();
    }

    public ArrayList(Object[] array) {
        assert array != null: "Array cannot be null";
        _capacity = array.length;
        clear();

        this._array = array;
        _size = array.length;
    }

    public void insert(int index, Object value) {
        assert value != null : "value should not be null";

        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }

        ensureCapacity(_size + 1);
        System.arraycopy(_array, index, _array, index + 1, _size - index);
        _array[index] = value;
        _size ++;

    }

    private void ensureCapacity(int capacity) {
        if (_array.length < capacity) {
            Object[] temp = new Object[capacity + capacity / 2];
            System.arraycopy(_array, 0, temp, 0, _size);
            _array = temp;
        }
    }

    public void add(Object value) {
        assert value != null : "value should not be null";
        ensureCapacity(_size + 1);
        _array[_size] = value;
        _size++;
    }

    public Object delete(int index){
        if (index < 0 || index >= _size){
            throw new IndexOutOfBoundsException();
        }
        Object value = _array[index];
        int copyFromIndex = index + 1;
        if (copyFromIndex < _size) {
            System.arraycopy(_array, index + 1, _array, index, _size - index);
        }
        _array[--_size] = null;
        return value;
    }

    public boolean delete(Object value) {
        for(int index = 0; index < _size; index++){
            if (_array[index].equals(value)){
                System.arraycopy(_array, index + 1, _array, index, _size - index);
                --_size;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        _array = new Object[_capacity];
        _size = 0;
    }

    public Object set(int index, Object value) {
        if (index < 0 || index >= _size){
            throw new IndexOutOfBoundsException();
        }
        Object oldValue = _array[index];
        _array[index] = value;
        return oldValue;
    }

    public Object get(int index) {
        if (index < 0 || index >= _size){
            throw new IndexOutOfBoundsException();
        }
        return _array[index];
    }

    public int indexOf(Object value) {
        for(int index = 0; index < _size; index++){
            if (_array[index].equals(value)){
                return index;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        for(int index = 0; index < _size; index++){
            if (_array[index].equals(value)){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public Iterator iterator() {
        //This is just to prove GenericListIteratorWorks
        //return new GenericListIterator(this);
        return new ArrayIterator(_array, 0, _size);
    }
}
