package sorting;

import lists.ArrayList;
import lists.List;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sorting.comparator.CallCountingComparator;
import sorting.comparator.NaturalComparator;

public class ListSorterCallCountingTest {

    private static final int TEST_SIZE = 1000;
    private final List _sortedArrayList = new ArrayList(TEST_SIZE);
    private final List _reversedArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    @Rule
    public TestName name = new TestName();

    @BeforeMethod
    void setUp() {
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);
        _sortedArrayList.clear();
        _randomArrayList.clear();
        _reversedArrayList.clear();
        for (int i = 1; i < TEST_SIZE; ++i) {
            _sortedArrayList.add(new Integer(i));
        }

        for (int i = TEST_SIZE; i > 0; --i) {
            _reversedArrayList.add(new Integer(i));
        }

        for (int i = 1; i < TEST_SIZE; ++i) {
            _randomArrayList.add(new Integer((int) (TEST_SIZE * Math.random())));
        }
    }

    @Test
    public void testWorstCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testWorstSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testWorstCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testBestCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testBestSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testBestCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testAverageCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testAverageSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls(_comparator.getCallCount());
    }

    @Test
    public void testAverageCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls(_comparator.getCallCount());
    }


    private void reportCalls(int callCount) {
        System.out.println(name.getMethodName() + ": " + callCount + " calls");
    }

}
