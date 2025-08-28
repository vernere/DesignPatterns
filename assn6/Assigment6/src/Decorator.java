/**
 * Abstract decorator class that implements the Printer interface.
 * This class is part of the Decorator design pattern which attaches
 * additional responsibilities to objects dynamically.
 * 
 * The Decorator pattern allows for functionality to be added to an object
 * without affecting other objects of the same class.
 */
public abstract class Decorator implements Printer {

    /** The wrapped printer instance that will be decorated */
    private Printer printer;

    /**
     * Constructor that takes a Printer object to be decorated.
     * Subclasses will extend this constructor to add their specific behavior.
     * 
     * @param printer The printer object to be wrapped by this decorator
     */
    public Decorator(Printer printer) {
        this.printer = printer;
    }

    /**
     * Gets the wrapped printer object.
     * This method allows access to the decorated printer instance.
     * 
     * @return The printer object being decorated
     */
    public Printer getPrinter(){
        return this.printer;
    }

}
