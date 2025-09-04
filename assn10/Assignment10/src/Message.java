
public class Message {
    public String message;
    public String email;

    public enum Type {
        // Add your enum values here, for example:
        COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, GENERAL_FEEDBACK
    }

    public Type messageType;

    public Message(String message, String email, String type) {
        this.message = message;
        this.email = email;

        // Convert the String to the corresponding enum value
        switch (type.toUpperCase()) {
            case "COMPENSATION_CLAIM":
                this.messageType = Type.COMPENSATION_CLAIM;
                break;
            case "DEVELOPMENT_SUGGESTION":
                this.messageType = Type.DEVELOPMENT_SUGGESTION;
                break;
            case "GENERAL_FEEDBACK":
                this.messageType = Type.GENERAL_FEEDBACK;
                break;
            case "CONTACT_REQUEST":
                this.messageType = Type.CONTACT_REQUEST;
                break;
            default:
                throw new IllegalArgumentException("Invalid message type: " + type);
        }
    }

}
