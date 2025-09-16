import java.util.HashMap;

/**
 * Represents a library that manages a collection of documents.
 * The library supports both protected and unprotected documents.
 */
public class Library {
    // Storage for all documents, indexed by document ID
    public HashMap<Integer, IDocument> books;

    /**
     * Constructor for the Library class.
     * Initializes an empty collection of documents.
     */
    public Library() {
        this.books = new HashMap<Integer, IDocument>();
    }

    /**
     * Adds an unprotected document to the library.
     * The document can be accessed directly without authentication.
     * 
     * @param docId    The document ID to use as a key in the collection
     * @param document The unprotected document to add
     */
    public void addUnprotectedDocument(int docId, IDocument document) {
        books.put(docId, document);
    }

    /**
     * Creates and adds a protected document to the library.
     * The document is wrapped in a DocumentProxy for access control.
     * 
     * @param docId    The document ID to use as a key in the collection
     * @param content  The content of the document to be protected
     */
    public void addProtectedDocument(int docId, String content) {
        Document realDoc = new Document(docId, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        books.put(docId, proxy);
    }

    /**
     * Retrieves a document from the library.
     * If the document is protected, access control will be handled by its proxy.
     * 
     * @param docId The document ID to retrieve
     * @param user  The user requesting access to the document
     * @return The document if it exists (access control handled by proxy if applicable)
     * @throws IllegalArgumentException if the document doesn't exist
     */
    public IDocument getDocument(int docId, User user) {
        IDocument document = books.get(docId);
        if (document == null) {
            throw new IllegalArgumentException("Document not found");
        }
        return document;
    }
}
