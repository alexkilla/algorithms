package queues.callcenter;


public class CallCenterSimulator {

    public static final int NUMBER_OF_ARGS = 4;
    public static final int NUMBER_OF_AGENTS_ARGS = 0;
    public static final int NUMBER_OF_CALLS_ARGS = 1;
    public static final int MAX_CALL_DURATION_ARG = 2;
    public static final int MAX_CALL_INTERVAL_ARG = 3;

    private CallCenterSimulator(){

    }

    public static void main(String[] args) {
        assert args != null : "args cannot be null";

        if (args.length != NUMBER_OF_ARGS){
            System.out.println("Usage: CallGenerator <numberOfAgents>"
                                + "<numberOfCalls> <maxCallDuration>"
                                + "<maxCallInterval>");
            System.exit(-1);
        }

        CallCenter callCenter = new CallCenter(Integer.parseInt(args[NUMBER_OF_AGENTS_ARGS]));
        CallGenerator callGenerator = new CallGenerator(callCenter,
                Integer.parseInt(args[NUMBER_OF_CALLS_ARGS]),
                Integer.parseInt(args[MAX_CALL_DURATION_ARG]),
                Integer.parseInt(args[MAX_CALL_INTERVAL_ARG]));
        callCenter.open();
        try{
            callGenerator.generateCalls();
        }finally {
            callCenter.close();
        }
    }
}
