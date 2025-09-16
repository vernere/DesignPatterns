import java.util.Collection;

/**
 * Directory class implements FileSystemElement interface to represent a directory
 * in a file system hierarchy. It can contain other FileSystemElements (files or directories).
 * This class is part of the Visitor pattern implementation.
 */
public class Directory implements FileSystemElement {
    /** Collection to store the child elements (files and subdirectories) */
    public Collection<FileSystemElement> collection;
    
    /**
     * Accepts a visitor according to the Visitor design pattern.
     * Calls the appropriate visit method on the visitor.
     * 
     * @param visitor The FileSystemVisitor that will perform operations on this Directory
     */
    @Override
    public void acceptVisitor(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }

    /**
     * Adds a new element (file or directory) to this directory.
     * 
     * @param el The FileSystemElement to add to this directory
     */
    public void addElement(FileSystemElement el){
        collection.add(el);
    }
}
