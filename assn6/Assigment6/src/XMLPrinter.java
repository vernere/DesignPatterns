/**
 * XMLPrinter is a decorator that wraps messages in XML tags.
 * This class implements the Decorator pattern to enhance any Printer implementation
 * with XML formatting capabilities.
 */
public class XMLPrinter extends Decorator {

    private Printer printer;

    /**
     * Constructs an XMLPrinter that decorates the specified Printer.
     * 
     * @param printer The underlying printer to be decorated with XML formatting
     */
    public XMLPrinter(Printer printer) {
        super(printer);
        this.printer = printer;

    }

    /**
     * Prints the message wrapped in XML tags.
     * Encloses the original message within <message> tags before delegating
     * to the decorated printer.
     * 
     * @param message The message to be formatted as XML and printed
     */
    @Override
    public void print(String message) {
        String newMessage = "<message>" + message + "</message>";
        printer.print(newMessage);
    }
}
