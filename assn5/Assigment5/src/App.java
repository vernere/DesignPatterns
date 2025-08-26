/**
 * App class that demonstrates the usage of a Logger singleton.
 */
public class App {
    /**
     * Main method - entry point of the application.
     * 
     * @param args command line arguments
     * @throws Exception if an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        // Get the singleton instance of Logger
        Logger logger = Logger.getInstance();

        // Set the file name for logging
        logger.setFileName("logtry.txt");
        // Write log messages to the file
        logger.write("Hello World!");
        logger.write("hmmmm");

        // Close the logger to release resources
        logger.close();
    }
}
