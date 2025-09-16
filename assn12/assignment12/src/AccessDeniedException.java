/**
 * Exception that is thrown when access to a resource is denied.
 * This can happen when a user tries to access a resource they don't have permission for.
 */
public class AccessDeniedException extends Exception {
    /** Error message explaining why access was denied */
    public String err;
    
    /**
     * Constructs a new AccessDeniedException with a specific error message.
     * 
     * @param err The error message detailing why access was denied
     */
    public AccessDeniedException(String err){
        super(err);
        this.err = err;
    }
}
