package sorting;

import arrays.iteration.Iterator;
import lists.LinkedList;
import lists.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sorting.comparator.NaturalComparator;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public abstract class AbstractListSorterTest {

    private List _unsortedList;
    private List _sortedList;

    protected abstract ListSorter createListSorter(Comparator comparator);

    @BeforeTest
    protected void setUp(){
        _unsortedList = new LinkedList();
        _unsortedList.add("test");
        _unsortedList.add("driven");
        _unsortedList.add("development");
        _unsortedList.add("is");
        _unsortedList.add("one");
        _unsortedList.add("small");
        _unsortedList.add("step");
        _unsortedList.add("for");
        _unsortedList.add("a");
        _unsortedList.add("programmer");
        _unsortedList.add("but");
        _unsortedList.add("it’s");
        _unsortedList.add("one");
        _unsortedList.add("giant");
        _unsortedList.add("leap");
        _unsortedList.add("for");
        _unsortedList.add("programming");
        _sortedList = new LinkedList();
        _sortedList.add("a");
        _sortedList.add("but");
        _sortedList.add("development");
        _sortedList.add("driven");
        _sortedList.add("for");
        _sortedList.add("for");
        _sortedList.add("giant");
        _sortedList.add("is");
        _sortedList.add("it’s");
        _sortedList.add("leap");
        _sortedList.add("one");
        _sortedList.add("one");
        _sortedList.add("programmer");
        _sortedList.add("programming");
        _sortedList.add("small");
        _sortedList.add("step");
        _sortedList.add("test");
    }

    @AfterTest
    public void tearDown(){
        _sortedList = null;
        _unsortedList = null;
    }

    @Test
    public void testListSorterCanSortSampleList() {
        ListSorter sorter = createListSorter(NaturalComparator.INSTANCE);
        List result = sorter.sort(_unsortedList);
        assertEquals(result.size(), _sortedList.size());
        Iterator actual = result.iterator();
        actual.first();
        Iterator expected = _sortedList.iterator();
        expected.first();
        while (!expected.isDone()) {
            assertEquals(expected.current(), actual.current());
            expected.next();
            actual.next();
        }
    }
}
