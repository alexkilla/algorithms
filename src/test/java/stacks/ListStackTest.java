package stacks;


public class ListStackTest extends AbstractStackTestCase{

    @Override
    protected Stack createStack() {
        return new ListStack();
    }
}
