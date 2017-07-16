package queues.callcenter;

public class Call {
    private final int _id;
    private final int _duration;
    private final long _startTime;

    public Call(int duration, int id) {
        assert duration >= 0 : "callTime cannot be < 0";

        _duration = duration;
        _id = id;
        _startTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Call{" +
                "_id=" + _id +
                '}';
    }

    public void answer() {
        System.out.println(this + " answered; waited "
                + (System.currentTimeMillis() - _startTime)
                + " milliseconds");
        try {
            Thread.sleep(_duration);
        } catch (InterruptedException e) {
            // Ignore
        }
    }

}
