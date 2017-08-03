package sorting;


import lists.List;

import java.util.Comparator;

public class BubbleSortListSorter implements ListSorter {

    private final Comparator _comparator;

    public BubbleSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        this._comparator = comparator;
    }

    public List sort(List list) {
        int size = list.size();
        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                if (_comparator.compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
        }
        return list;
    }

    private void swap(List list, int left, int right) {
        Object leftValue = list.set(left, list.get(right));
        list.set(right, leftValue);
    }
}
