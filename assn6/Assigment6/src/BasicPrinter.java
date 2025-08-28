/**
 * A basic implementation of the Printer interface.
 * This class provides simple standard output printing functionality.
 */
public class BasicPrinter implements Printer {

    /**
     * Prints a message to the standard output.
     * 
     * @param message The message to be printed
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
