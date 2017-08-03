package sorting.comparator;

import java.util.Comparator;

public class ReverseComparator implements Comparator{

    private final Comparator _comparator;

    public ReverseComparator(Comparator comparator) {
        _comparator = comparator;
    }

    public int compare(Object left, Object right) {
        return _comparator.compare(right, left);
    }
}
