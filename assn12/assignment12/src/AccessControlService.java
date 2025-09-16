import java.util.HashMap;

/**
 * AccessControlService - Singleton class that manages document access permissions
 * Implements access control by maintaining a whitelist of user-document permissions
 */
public class AccessControlService {
    // Singleton instance
    private static AccessControlService instance;
    // Map to store access permissions (key: "documentId:username", value: hasAccess)
    private java.util.Map<String, Boolean> whitelist = new HashMap<String, Boolean>();

    /**
     * Gets the singleton instance of AccessControlService
     * Creates a new instance if one doesn't exist
     * @return The singleton instance
     */
    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    /**
     * Checks if a user has access to a specific document
     * @param documentId The ID of the document to check access for
     * @param username The username to check permissions for
     * @return true if the user has access, false otherwise
     */
    public boolean isAllowed(int documentId, String username) {
        String key = documentId + ":" + username;
        Boolean hasAccess = whitelist.get(key);
        return hasAccess != null && hasAccess;
    }

    /**
     * Grants access permission to a user for a specific document
     * @param username The username to grant permission to
     * @param docId The document ID to grant access for
     */
    public void setPermission(String username, int docId) {
        String key = docId + ":" + username;
        whitelist.put(key, true);
    }
}
