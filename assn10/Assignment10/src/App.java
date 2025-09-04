
public class App {

    public static void main(String[] args) throws Exception {

        Handler handler0 = new CompensationClaimHandler();
        Handler handler1 = new ContactRequestHandler();
        Handler handler2 = new DevelopmentSuggestionHandler();
        Handler handler3 = new GeneralFeedbackHandler();

        handler0.setHandlers(handler0, handler1, handler2, handler3);
        handler1.setHandlers(handler0, handler1, handler2, handler3);
        handler2.setHandlers(handler0, handler1, handler2, handler3);
        handler3.setHandlers(handler0, handler1, handler2, handler3);

        Message msg1 = new Message("I need help", "I have been having this compensation problem", "COMPENSATION_CLAIM");
        Message msg2 = new Message("I need help2", "I have been having this compensation problem2",
                "Development_SUGGESTION");
        Message msg3 = new Message("I need help3", "I have been having this compensation problem3", "CONTACT_REQUEST");
        Message msg4 = new Message("I need help4", "I have been having this compensation problem4", "GENERAL_FEEDBACK");

        handler0.handleMessage(msg1);
        handler0.handleMessage(msg2);
        handler0.handleMessage(msg3);
        handler0.handleMessage(msg4);

    }
}
