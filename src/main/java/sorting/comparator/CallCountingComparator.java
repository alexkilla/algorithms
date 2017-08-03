package sorting.comparator;

import java.util.Comparator;

public class CallCountingComparator implements Comparator {

    private final Comparator _comparator;
    private int callCount;

    public CallCountingComparator(Comparator comparator) {
        callCount = 0;
        _comparator = comparator;
    }


    public int compare(Object left, Object right) {
        ++callCount;
        return _comparator.compare(left, right);
    }

    public int getCallCount(){
        return callCount;
    }
}

