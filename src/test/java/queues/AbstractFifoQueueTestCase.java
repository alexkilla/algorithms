package queues;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractFifoQueueTestCase {

    public static final String VALUE_A = "A";
    public static final String VALUE_B = "B";
    public static final String VALUE_C = "C";

    private Queue _queue;

    @BeforeTest
    public void setUp() throws Exception {
        _queue = createFifoQueue();
    }

    protected abstract Queue createFifoQueue();

    @Test
    public void testAccessAnEmptyQueue(){
        assertThat(_queue.size(), is(0));
        assertThat(_queue.isEmpty(), is(true));

        try {
            _queue.dequeue();
            fail();
        }catch (EmptyQueueException e){
            //expected
        }
    }

    @Test
    public void testEnqueueDequeue(){
        enqueueAllTestValues();
        assertThat(_queue.size(), equalTo(3));
        assertThat(_queue.isEmpty(), is(false));

        assertThat(_queue.dequeue().equals(VALUE_B), is(true));
        assertThat(_queue.size(), is(2));
        assertThat(_queue.isEmpty(), is(true));

        assertThat(_queue.dequeue().equals(VALUE_A), is(true));
        assertThat(_queue.size(), is(1));
        assertThat(_queue.isEmpty(), is(false));

        assertThat(_queue.dequeue().equals(VALUE_C), is(true));
        assertThat(_queue.size(), is(0));
        assertThat(_queue.isEmpty(), is(true));

        try{
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e){
            //expected
        }
    }

    private void enqueueAllTestValues() {
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_C);
    }

    @Test
    public void testClear(){
        enqueueAllTestValues();

        assertThat(_queue.isEmpty(), is(false));

        _queue.clear();

        assertThat(_queue.size(), equalTo(0));
        assertThat(_queue.isEmpty(), is(true));

        try{
            _queue.dequeue();
            fail();
        }catch (EmptyQueueException e){
            // expected
        }
    }

}
