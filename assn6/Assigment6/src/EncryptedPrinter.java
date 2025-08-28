/**
 * EncryptedPrinter is a decorator that adds encryption functionality to a
 * Printer implementation.
 * It extends the Decorator class and encrypts messages using Base64 encoding
 * before delegating the printing to the wrapped Printer object.
 */
public class EncryptedPrinter extends Decorator {

    private Printer printer;

    /**
     * Constructor that takes a Printer object to be decorated.
     * 
     * @param printer The Printer to be decorated with encryption functionality
     */
    public EncryptedPrinter(Printer printer) {
        super(printer);
        this.printer = printer;
    }

    /**
     * Encrypts the message using Base64 encoding and delegates printing
     * to the wrapped Printer object.
     * 
     * @param message The message to be encrypted and printed
     */
    @Override
    public void print(String message) {
        String encryptedMessage = java.util.Base64.getEncoder().encodeToString(message.getBytes());
        printer.print(encryptedMessage);
    }

}
