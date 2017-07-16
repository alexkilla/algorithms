package stacks;

import org.testng.annotations.Test;

import static junit.framework.TestCase.*;
import static org.testng.Assert.assertSame;
import static org.testng.AssertJUnit.assertEquals;

public abstract class AbstractStackTestCase {
    public static final String VALUE_A = "A";
    public static final String VALUE_B = "B";
    public static final String VALUE_C = "C";

    protected abstract Stack createStack();

    @Test
    public void testPushAndPop() {
        Stack stack = createStack();
        stack.push(VALUE_B);
        stack.push(VALUE_A);
        stack.push(VALUE_C);
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        assertSame(VALUE_C, stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertSame(VALUE_A, stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertSame(VALUE_B, stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testCantPopFromAnEmptyStack() {
        Stack stack = createStack();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
        }
    }

    @Test
    public void testPeek() {
        Stack stack = createStack();
        stack.push(VALUE_C);
        stack.push(VALUE_A);
        assertEquals(2, stack.size());
        assertSame(VALUE_A, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testCantPeekIntoAnEmptyStack() {
        Stack stack = createStack();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        try {
            stack.peek();
            fail();
        } catch (EmptyStackException e) {
        }
    }

    @Test
    public void testClear() {
        Stack stack = createStack();
        stack.push(VALUE_A);
        stack.push(VALUE_B);
        stack.push(VALUE_C);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
// expected
        }
    }
}
