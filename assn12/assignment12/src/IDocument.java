import java.sql.Date;

/**
 * Interface representing a document in the system.
 * Provides methods to retrieve document content and creation date.
 * Access to document information is controlled by user permissions.
 */
public interface IDocument {

    public String getContent(User user);
    public Date getCreationDate(User user);

}
