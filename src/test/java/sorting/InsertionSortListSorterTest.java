package sorting;


import java.util.Comparator;

public class InsertionSortListSorterTest extends AbstractListSorterTest{
    @Override
    protected ListSorter createListSorter(Comparator comparator) {
        return new InsertionSortListSorter(comparator);
    }
}
