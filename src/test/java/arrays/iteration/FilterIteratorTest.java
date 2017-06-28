package arrays.iteration;


import org.testng.annotations.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertSame;

public class FilterIteratorTest {

    public static final Object[] ARRAY = {"A", "B", "C"};

    @Test
    public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {
        Iterator expectedIterator = new ArrayIterator(ARRAY);
        Iterator underlyingIterator = new ArrayIterator(ARRAY);
        Iterator iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));
        iterator.first();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[0], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[1], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(ARRAY[2], equalTo(iterator.current()));
        iterator.next();
        assertThat(iterator.isDone(), is(true));
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
        assertThat(expectedIterator.isDone(), is(true));
        assertThat(underlyingIterator.isDone(), is(true));
    }

    @Test
    public void testForwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
        Iterator expectedIterator = new ArrayIterator(ARRAY);
        Iterator underlyingIterator = new ArrayIterator(ARRAY);
        Iterator iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(false, expectedIterator));
        iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    @Test
    public void testBackwardsIterationIncludesItemsWhenPredicateReturnsTrue() {
        Iterator expectedIterator = new ReverseIterator(new ArrayIterator(ARRAY));
        Iterator underlyingIterator = new ArrayIterator(ARRAY);
        Iterator iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(true, expectedIterator));
        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());
        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());
        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());
        iterator.previous();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    @Test
    public void testBackwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
        Iterator expectedIterator = new ReverseIterator(new ArrayIterator(ARRAY));
        Iterator underlyingIterator = new ArrayIterator(ARRAY);
        Iterator iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(false, expectedIterator));
        iterator.last();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
            assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    public class DummyPredicate implements Predicate {

        private final Iterator _iterator;
        private final boolean _result;

        public DummyPredicate(boolean result, Iterator iterator) {
            _iterator = iterator;
            _result = result;
            _iterator.first();
        }

        public boolean evaluate(Object o) {
            assertThat(_iterator.current(), equalTo(o));
            _iterator.next();
            return _result;
        }
    }
}
