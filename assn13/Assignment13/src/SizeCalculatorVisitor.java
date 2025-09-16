/**
 * A visitor that calculates the total size of a file system structure.
 * Implements the FileSystemVisitor interface to traverse files and directories.
 */
public class SizeCalculatorVisitor implements FileSystemVisitor {
    /** Stores the accumulated total size of all visited files */
    public int totalSize;

    /**
     * Visits a file and adds its size to the total.
     * @param file The file being visited
     */
    @Override
    public void visitFile(File file) {
        totalSize += file.size;
    }

    /**
     * Visits a directory and recursively visits all its contents.
     * @param directory The directory being visited
     */
    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.collection) {
            element.acceptVisitor(this);
        }
    }
}
