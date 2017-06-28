package arrays.iteration;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseIteratorTest {

    private static final Object[] ARRAY = new Object[]{"A", "B", "C"};

    @Test
    public void testForwardsIterationBecomesBackwards() {
        ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));
        iterator.first();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[2], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[1], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[0], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(true));

        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }

    @Test
    public void testBackwardsIterationBecomesForwards() {
        ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));
        iterator.last();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[0], equalTo(iterator.current()));
        iterator.previous();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[1], equalTo(iterator.current()));
        iterator.previous();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[2], equalTo(iterator.current()));
        iterator.previous();
        assertThat(iterator.isDone(), is(true));

        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }
}
