package queues.callcenter;


import queues.Queue;

public class CustomerServiceAgent implements Runnable{

    public static final Call GO_HOME =  new Call(-1, 0);

    private final int _id;
    private final Queue _calls;

    public CustomerServiceAgent(int id, Queue calls) {
        assert calls != null : " calls cannot be null";
        _id = id;
        _calls = calls;
    }

    @Override
    public String toString() {
        return "CustomerServiceAgent{" +
                "_id=" + _id +
                '}';
    }

    public void run() {
        System.out.println(this + " clocked on");

        while (true){
            System.out.println(this + "waiting");

            Call call = (Call) _calls.dequeue();
            System.out.println(this + "answering " + call);
             if (call == GO_HOME){
                 break;
             }

            call.answer();
        }
        System.out.println(this + " going home");
    }
}
