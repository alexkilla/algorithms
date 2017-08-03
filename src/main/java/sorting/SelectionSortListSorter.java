package sorting;

import lists.List;

import java.util.Comparator;


public class SelectionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    public SelectionSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }

    public List sort(List list) {
        int size = list.size();
        for (int slot = 0; slot < size; ++slot) {
            for (int check = slot + 1; check < size;++check){
                int change = slot;
                if (_comparator.compare(list.get(slot), list.get(check)) > 0){
                    change = check;
                }
                swap(list, slot, change);
            }
        }
        return list;
    }

    private void swap(List list, int left, int right) {
        if(left == right){
            return;
        }
        Object oldLeft = list.set(left, list.get(right));
        list.set(right, oldLeft);
    }
}
