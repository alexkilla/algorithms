package sorting;

import lists.LinkedList;
import lists.List;

import java.util.Comparator;


public class InsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    public InsertionSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }

    public List sort(List list) {

        List sortedList = new LinkedList();
        int size = list.size();
        for (int pass = 0; pass < size; ++pass) {
            int slot = sortedList.size();
            while (slot > 0) {
                if (_comparator.compare(list.get(pass), sortedList.get(slot - 1)) >= 0) {
                    break;
                }
                slot--;
            }
            sortedList.insert(slot, list.get(pass));
        }
        return sortedList;
    }
}
