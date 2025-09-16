/**
 * The FileSystemVisitor interface defines methods for the Visitor pattern implementation
 * that allows operations to be performed on File and Directory elements.
 * <p>
 * This interface is part of the Visitor design pattern which enables adding new operations
 * to existing object structures without modifying those structures.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2023-12-01
 */
public interface FileSystemVisitor {
    public void visitFile(File file);
    public void visitDirectory(Directory directory);
}
