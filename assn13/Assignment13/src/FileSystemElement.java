/**
 * Interface for elements in a file system.
 * This interface follows the Visitor design pattern, allowing operations to be
 * performed on elements of the file system structure.
 * 
 * Implementing classes must provide a method to accept a visitor,
 * which will perform some operation on the element.
 */
public interface FileSystemElement {
    public void acceptVisitor(FileSystemVisitor visitor);
}
