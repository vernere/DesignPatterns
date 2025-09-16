/**
 * Main application class demonstrating document access control system
 */
public class App {
    public static void main(String[] args) {
        try {
            // Create users for testing the system
            User user1 = new User("user1");
            User user2 = new User("user2");
            User user3 = new User("user3");
            User user4 = new User("user4");

            // Create a library to store and manage documents
            Library library = new Library();

            // Create unprotected documents with ID and content
            Document doc1 = new Document(1, "Hello World 1 - Unprotected document");
            Document doc3 = new Document(3, "Hello World 3 - Unprotected document");

            // Add both protected and unprotected documents to the library
            library.addUnprotectedDocument(1, doc1);
            library.addProtectedDocument(2, "Hello World 2 - Protected for user2");
            library.addUnprotectedDocument(3, doc3);
            library.addProtectedDocument(4, "Hello World 4 - Protected for user4");

            // Configure access permissions using the Access Control Service
            AccessControlService acs = AccessControlService.getInstance();
            acs.setPermission(user2.username, 2);  // Grant user2 access to document 2
            acs.setPermission(user4.username, 4);  // Grant user4 access to document 4

            // DEMONSTRATION 1: Accessing unprotected documents (should always work)
            System.out.println("User1 accessing unprotected document 1:");
            IDocument doc1Access = library.getDocument(1, user1);
            System.out.println(doc1Access.getContent(user1));

            // DEMONSTRATION 2: User with permission accessing protected document
            System.out.println("\nUser2 accessing protected document 2 (has permission):");
            IDocument doc2Access = library.getDocument(2, user2);
            System.out.println(doc2Access.getContent(user2));

            // DEMONSTRATION 3: Another unprotected document access
            System.out.println("\nUser3 accessing unprotected document 3:");
            IDocument doc3Access = library.getDocument(3, user3);
            System.out.println(doc3Access.getContent(user3));

            // DEMONSTRATION 4: Another user with permission accessing protected document
            System.out.println("\nUser4 accessing protected document 4 (has permission):");
            IDocument doc4Access = library.getDocument(4, user4);
            System.out.println(doc4Access.getContent(user4));

            // DEMONSTRATION 5: User without permission attempting to access protected document
            try {
                System.out.println("\nUser1 accessing protected document 2 (no permission):");
                IDocument doc2AccessDenied = library.getDocument(2, user1);
                System.out.println(doc2AccessDenied.getContent(user1));
            } catch (UnsupportedOperationException e) {
                // Expected behavior: access should be denied
                System.out.println("Access denied: User1 does not have permission to access document 2");
            }

            // DEMONSTRATION 6: Another user without permission attempting to access protected document
            try {
                System.out.println("\nUser3 accessing protected document 4 (no permission):");
                IDocument doc4AccessDenied = library.getDocument(4, user3);
                System.out.println(doc4AccessDenied.getContent(user3));
            } catch (UnsupportedOperationException e) {
                // Expected behavior: access should be denied
                System.out.println("Access denied: User3 does not have permission to access document 4");
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions
            e.printStackTrace();
        }
    }
}
