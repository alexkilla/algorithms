package arrays.iteration;


import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayIteratorTest {

    @Test
    public void testIterationRespectsBounds() {
        Object[] array = new Object[]{"A", "B", "C", "D", "E", "F"};
        ArrayIterator iterator = new ArrayIterator(array, 1, 3);
        iterator.first();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[1], equalTo(iterator.current()));

        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[2], equalTo(iterator.current()));

        iterator.next();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[3], equalTo(iterator.current()));

        iterator.next();
        assertThat(iterator.isDone(), is(true));
        try{
            iterator.current();
            fail();
        }catch (IteratorOutOfBoundsException e){
            //expected
        }
    }

    @Test
    public void testBackwardsIteration() {
        Object[] array = new Object[]{"A", "B", "C", "D", "E", "F"};
        ArrayIterator iterator = new ArrayIterator(array, 1, 3);
        iterator.last();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[3], equalTo(iterator.current()));

        iterator.previous();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[2], equalTo(iterator.current()));

        iterator.previous();
        assertThat(iterator.isDone(), is(false));
        assertThat(array[1], equalTo(iterator.current()));

        iterator.previous();
        assertThat(iterator.isDone(), is(true));
        try{
            iterator.current();
            fail();
        }catch (IteratorOutOfBoundsException e){
            //expected
        }
    }

}
