package lists;

import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;
import static org.testng.AssertJUnit.assertEquals;

public class ArrayListTest extends AbstractListTestCase{

    @Override
    protected List createList() {
        return new ArrayList();
    }

    @Test
    public void testResizeBeyondInitialCapacity() {
        List list = new ArrayList(1);
        list.add(VALUE_A);
        list.add(VALUE_A);
        list.add(VALUE_A);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.get(1));
        assertSame(VALUE_A, list.get(2));
    }

    @Test
    public void testDeleteFromLastElementInArray() {
        List list = new ArrayList(1);
        list.add(new Object());
        list.delete(0);
    }
}
