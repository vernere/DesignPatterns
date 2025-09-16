/**
 * Main application demonstrating the Visitor Pattern with a file system structure.
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create directory structure (Composite pattern)
        Directory dir1 = new Directory();  // Root directory
        dir1.collection = new java.util.ArrayList<>();
        
        Directory dir2 = new Directory();  // First subdirectory
        dir2.collection = new java.util.ArrayList<>();
        
        Directory dir3 = new Directory();  // Second subdirectory (nested in dir2)
        dir3.collection = new java.util.ArrayList<>();

        // Build directory hierarchy
        dir1.addElement(dir2);  // Add dir2 as child of dir1
        dir2.addElement(dir3);  // Add dir3 as child of dir2

        // Create file objects
        File file1 = new File("Hello1", 1);  // File with name "Hello1" and size 1
        File file2 = new File("Hello2", 2);  // File with name "Hello2" and size 2
        File file3 = new File("Hello3", 3);  // File with name "Hello3" and size 3

        // Add files to directories
        dir1.addElement(file1);  // Add file1 to root directory
        dir2.addElement(file2);  // Add file2 to first subdirectory
        dir3.addElement(file3);  // Add file3 to second subdirectory

        // Create visitors for different operations
        SizeCalculatorVisitor sizeV = new SizeCalculatorVisitor();  // Visitor to calculate total file size
        SearchVisitor searchV = new SearchVisitor("Hello1");  // Visitor to search for files with name "Hello1"

        // Apply visitors to traverse the directory structure
        dir1.acceptVisitor(searchV);  // Search for files named "Hello1"
        dir1.acceptVisitor(sizeV);    // Calculate total size of all files
        
        // Output results
        System.out.println("Total size: " + sizeV.totalSize);
        System.out.println("Files matching 'Hello1': " + searchV.match);
    }
}
