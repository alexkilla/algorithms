package lists;


import arrays.iteration.Iterator;

public abstract class AbstractList implements List {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof List && equals((List) obj);
    }

    public boolean equals(List other) {
        if (other == null || size() != other.size()) {
            return false;
        }

        Iterator i = iterator();
        Iterator j = other.iterator();

        for (i.first(), j.first();
             !i.isDone() && !j.isDone();
             i.next(), j.next()) {

            if (!i.current().equals(j.current())) {
                break;
            }
        }

        return i.isDone() && j.isDone();
    }

    @Override
    public String toString() {
        Iterator iterator = iterator();
        String toString = "[";
        boolean first = true;
        for (iterator.first();
             !iterator.isDone();
             iterator.next()) {
            toString += (first) ? "" : ",";
            first = false;
            toString += iterator.current();
        }
        return toString + "]";
    }

    public int indexOf(Object value) {
        assert value != null : "value cannot be null";
        Iterator iterator = iterator();
        int index = 0;
        for (iterator.first();!iterator.isDone();iterator.next()){
            if (iterator.current().equals(value)){
                return index;
            }
            ++index;
        }
        return -1;
    }
}
