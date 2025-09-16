/**
 * SearchVisitor implements the FileSystemVisitor interface to search for files with a specific name.
 * This class is part of the Visitor design pattern implementation for file system traversal.
 */
public class SearchVisitor implements FileSystemVisitor {
    /** The file name to search for */
    public String search;
    /** Counter for the number of matches found */
    public int match;

    /**
     * Constructor that initializes the search criteria
     * @param search The file name to search for
     */
    public SearchVisitor(String search) {
        this.search = search;
        this.match = 0; // Initialize match counter to zero
    }

    /**
     * Visits a file and checks if its name matches the search criteria
     * @param file The file to check
     */
    @Override
    public void visitFile(File file) {
        if (file.name.equals(search)) { // Should use equals() instead of == for string comparison
            match++;
        }
    }

    /**
     * Visits a directory and recursively visits all elements within it
     * @param directory The directory to traverse
     */
    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.collection) {
            element.acceptVisitor(this);
        }
    }
}
