package queues;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase{


    @Override
    protected Queue createFifoQueue() {
        return new ListFifoQueue();
    }
}
