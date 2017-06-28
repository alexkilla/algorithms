package lists;


import arrays.iteration.Iterator;
import arrays.iteration.IteratorOutOfBoundsException;
import org.testng.annotations.Test;

import static junit.framework.TestCase.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public abstract class AbstractListTestCase {

    protected static final Object VALUE_A = "A";
    protected static final Object VALUE_B = "B";
    protected static final Object VALUE_C = "C";

    protected abstract List createList();

    @Test
    public void testInsertIntoEmptyList() {
        List list = createList();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        list.insert(0, VALUE_A);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertSame(VALUE_A, list.get(0));
    }

    @Test
    public void testInsertBetweenElements() {
        List list = createList();
        list.insert(0, VALUE_A);
        list.insert(1, VALUE_B);
        list.insert(1, VALUE_C);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_C, list.get(1));
        assertSame(VALUE_B, list.get(2));
    }

    @Test
    public void testInsertBeforeFirstElement() {
        List list = createList();
        list.insert(0, VALUE_A);
        list.insert(0, VALUE_B);
        assertEquals(2, list.size());
        assertSame(VALUE_B, list.get(0));
        assertSame(VALUE_A, list.get(1));
    }

    @Test
    public void testInsertAfterLastElement() {
        List list = createList();
        list.insert(0, VALUE_A);
        list.insert(1, VALUE_B);
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
    }

    @Test
    public void testInsertOutOfBounds() {
        List list = createList();
        try {
            list.insert(-1, VALUE_A);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected
        }
        try {
            list.insert(1, VALUE_B);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected
        }
    }

    @Test
    public void testAdd() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_C);
        list.add(VALUE_B);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_C, list.get(1));
        assertSame(VALUE_B, list.get(2));
    }

    @Test
    public void testSet() {
        List list = createList();
        list.insert(0, VALUE_A);

        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.set(0, VALUE_B));
        assertSame(VALUE_B, list.get(0));
    }

    @Test
    public void testGetOutOfBounds() {
        List list = createList();
        try {
            list.get(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
        try {
            list.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
        list.add(VALUE_A);
        try {
            list.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testSetOutOfBounds() {
        List list = createList();
        try {
            list.set(-1, VALUE_A);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
        try {
            list.set(0, VALUE_B);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
        list.insert(0, VALUE_C);
        try {
            list.set(1, VALUE_C);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testDeleteOnlyElement() {
        List list = createList();
        list.add(VALUE_A);
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.delete(0));
        assertEquals(0, list.size());
    }

    @Test
    public void testDeleteFirstElement() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertSame(VALUE_C, list.get(2));
        assertSame(VALUE_A, list.delete(0));
        assertEquals(2, list.size());
        assertSame(VALUE_B, list.get(0));
        assertSame(VALUE_C, list.get(1));
    }

    @Test
    public void testDeleteLastElement() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertSame(VALUE_C, list.get(2));
        assertSame(VALUE_C, list.delete(2));
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
    }

    @Test
    public void testDeleteMiddleElement() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_C);
        list.add(VALUE_B);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_C, list.get(1));
        assertSame(VALUE_B, list.get(2));
        assertSame(VALUE_C, list.delete(1));
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
    }

    @Test
    public void testDeleteOutOfBounds() {
        List list = createList();
        try {
            list.delete(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {// expected
        }
        try {
            list.delete(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testDeleteByValue() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_A);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertSame(VALUE_A, list.get(2));
        assertTrue(list.delete(VALUE_A));
        assertEquals(2, list.size());
        assertSame(VALUE_B, list.get(0));
        assertSame(VALUE_A, list.get(1));
        assertTrue(list.delete(VALUE_A));
        assertEquals(1, list.size());
        assertSame(VALUE_B, list.get(0));
        assertFalse(list.delete(VALUE_C));
        assertEquals(1, list.size());
        assertSame(VALUE_B, list.get(0));
        assertTrue(list.delete(VALUE_B));
        assertEquals(0, list.size());
    }

    @Test
    public void testEmptyIteration() {
        List list = createList();
        Iterator iterator = list.iterator();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testEmptyIterationGeneric() {
        List list = createList();
        Iterator iterator = list.iterator();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testForwardIteration() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
        Iterator iterator = list.iterator();
        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(VALUE_A, iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(VALUE_B, iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(VALUE_C, iterator.current());
        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testReverseIteration() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
        Iterator iterator = list.iterator();
        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(VALUE_C, iterator.current());
        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(VALUE_B, iterator.current());
        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(VALUE_A, iterator.current());
        iterator.previous();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
    }

    @Test
    public void testIndexOf() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_A);
        assertEquals(0, list.indexOf(VALUE_A));
        assertEquals(1, list.indexOf(VALUE_B));
        assertEquals(-1, list.indexOf(VALUE_C));
    }

    @Test
    public void testContains() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_A);
        assertTrue(list.contains(VALUE_A));
        assertTrue(list.contains(VALUE_B));
        assertFalse(list.contains(VALUE_C));
    }

    @Test
    public void testClear() {
        List list = createList();
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testEquals() {
        List listOne = createList();
        List listTwo = createList();
        List listThree = createList();
        addAllDefaultValuesTo(listOne);
        addAllDefaultValuesTo(listTwo);
        listThree.add(VALUE_A);
        listThree.add(VALUE_B);
        assertThat(listOne.equals(listTwo), is(true));
        assertThat(listTwo.equals(listOne), is(true));
        assertThat(listTwo.equals(listThree), is(false));
        assertThat(listOne.equals(listThree), is(false));

    }

    @Test
    public void testToString() {
        List list = createList();
        addAllDefaultValuesTo(list);
        String expected = "[" + VALUE_A + "," + VALUE_B + "," + VALUE_C + "]";
        assertThat(list.toString(), equalTo(expected));
    }

    private void addAllDefaultValuesTo(List list) {
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);
    }
}
