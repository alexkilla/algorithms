package sorting.comparator;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NaturalComparatorTest {

    @Test
    public void testLessThan(){
        assertThat(NaturalComparator.INSTANCE.compare("A", "B") < 0, is(true));
    }

    @Test
    public void testGreaterThan(){
        assertThat(NaturalComparator.INSTANCE.compare("B", "A") > 0, is(true));
    }

    @Test
    public void testEqualTo(){
        assertThat(NaturalComparator.INSTANCE.compare("A", "A") == 0, is(true));
    }

}
