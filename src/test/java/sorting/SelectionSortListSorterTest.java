package sorting;


import java.util.Comparator;

public class SelectionSortListSorterTest extends AbstractListSorterTest{
    @Override
    ListSorter createListSorter(Comparator comparator) {
        return new SelectionSortListSorter(comparator);
    }
}
