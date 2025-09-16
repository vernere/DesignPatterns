import java.sql.Date;

/**
 * Represents a document in the system.
 * Implements the IDocument interface to provide document functionality.
 */
public class Document implements IDocument {

    /** Unique identifier for the document */
    public int identifier;
    /** Date when the document was created */
    public Date creationDate;
    /** The textual content of the document */
    public String content;

    /**
     * Constructs a new Document with the specified identifier and content.
     * The creation date is automatically set to the current time.
     * 
     * @param identifier Unique identifier for the document
     * @param content The textual content of the document
     */
    public Document(int identifier, String content){
        this.identifier = identifier;
        this.content = content;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    /**
     * Retrieves the content of the document.
     * 
     * @param user The user requesting access to the content
     * @return The content of the document
     */
    @Override
    public String getContent(User user) {
        return content;
    }

    /**
     * Retrieves the creation date of the document.
     * 
     * @param user The user requesting access to the creation date
     * @return The creation date of the document
     */
    @Override
    public Date getCreationDate(User user) {
        return creationDate;
    }

    /**
     * Retrieves the identifier of the document.
     * 
     * @return The identifier of the document
     */
    public int getIdentifier(){
        return identifier;
    }
}
