package sorting;

import java.util.Comparator;

public class BubbleSortListSorterTest extends AbstractListSorterTest{


    @Override
    protected ListSorter createListSorter(Comparator comparator) {
        return new BubbleSortListSorter(comparator);
    }
}
