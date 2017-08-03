package sorting.comparator;

import org.testng.annotations.Test;

import static junit.framework.TestCase.assertTrue;

public class ReverseComparatorTest {

    @Test
    public void testLessThanBecomesGreaterThan() {
        ReverseComparator comparator =
                new ReverseComparator(NaturalComparator.INSTANCE);
        assertTrue(comparator.compare("A", "B") > 0);
    }

    @Test
    public void testGreaterThanBecomesLessThan() {
        ReverseComparator comparator =
                new ReverseComparator(NaturalComparator.INSTANCE);
        assertTrue(comparator.compare("B", "A") < 0);
    }

    @Test
    public void testEqualsRemainsUnchanged() {
        ReverseComparator comparator =
                new ReverseComparator(NaturalComparator.INSTANCE);
        assertTrue(comparator.compare("A", "A") == 0);
    }
}
