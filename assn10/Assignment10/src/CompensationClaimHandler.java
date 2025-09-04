
public class CompensationClaimHandler implements Handler {
    public Handler handlers[] = new Handler[4];

    public enum Type {
        // Add your enum values here, for example:
        COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, GENERAL_FEEDBACK
    }

    @Override
    public void handleMessage(Message n) {
        if (n.messageType.toString().equals(Type.COMPENSATION_CLAIM.toString())) {
            System.out.println(n.message + " Has been handled by compensation claim");
        } else {
            handlers[1].handleMessage(n);
        }
    }

    @Override
    public void setHandlers(Handler h0, Handler h1, Handler h3, Handler h4) {

        handlers[0] = h0;
        handlers[1] = h1;
        handlers[2] = h3;
        handlers[3] = h4;

    }
}
