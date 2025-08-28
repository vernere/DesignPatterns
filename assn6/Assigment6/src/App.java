/**
 * Main application class demonstrating the Decorator pattern for printers.
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create a basic printer without any decorators
        Printer printer = new BasicPrinter();
        
        // Create a printer with multiple decorators:
        // BasicPrinter wrapped by XMLPrinter, then wrapped by EncryptedPrinter
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        
        // Create a printer with a single decorator:
        // BasicPrinter wrapped by XMLPrinter
        Printer printer3 = new XMLPrinter(new BasicPrinter());

        // Print "Hello World!" using each printer
        printer.print("Hello World!");   // Prints with no formatting or encryption
        printer2.print("Hello World!");  // Prints with XML formatting and encryption
        printer3.print("Hello World!");  // Prints with XML formatting only
    }
}
