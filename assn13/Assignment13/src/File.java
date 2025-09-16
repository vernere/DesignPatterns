/**
 * Represents a file in a file system.
 * Implements the FileSystemElement interface to allow visitor pattern usage.
 */
public class File implements FileSystemElement {
    /** Size of the file in bytes */
    public int size;
    /** Name of the file */
    public String name;

    /**
     * Creates a new file with the specified name and size.
     * 
     * @param name The name of the file
     * @param size The size of the file in bytes
     */
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    /**
     * Accepts a file system visitor by calling the appropriate visit method.
     * This is part of the Visitor pattern implementation.
     * 
     * @param visitor The visitor that will process this file
     */
    @Override
    public void acceptVisitor(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}
