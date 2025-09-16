import java.sql.Date;

/**
 * A proxy implementation for the Document class that adds access control.
 * This class implements the IDocument interface and delegates to a real Document
 * object after performing permission checks.
 */
public class DocumentProxy implements IDocument {
    // Singleton instance of the access control service
    private AccessControlService instance = AccessControlService.getInstance();
    // The actual document being proxied
    private Document document;

    /**
     * Constructor that takes the real document to proxy
     * @param document The document object to be wrapped
     */
    public DocumentProxy(Document document){
        this.document = document;
    }

    /**
     * Gets the content of the document if the user has proper access rights
     * @param user The user requesting access to the document content
     * @return The content of the document if access is granted
     * @throws UnsupportedOperationException if the user doesn't have access
     */
    @Override
    public String getContent(User user) {
        // Check if the user has permission to access the document
        if (instance.isAllowed(document.getIdentifier(), user.username)) {
            // Delegate to the real document if access is allowed
            return document.getContent(user);
        } else {
            // Deny access if the user doesn't have permission
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Gets the creation date of the document if the user has proper access rights
     * @param user The user requesting access to the document creation date
     * @return The creation date of the document if access is granted
     * @throws UnsupportedOperationException if the user doesn't have access
     */
    @Override
    public Date getCreationDate(User user) {
        // Check if the user has permission to access the document
        if (instance.isAllowed(document.getIdentifier(), user.username)) {
            // Delegate to the real document if access is allowed
            return document.getCreationDate(user);
        } else {
            // Deny access if the user doesn't have permission
            throw new UnsupportedOperationException();
        }
    }
}
