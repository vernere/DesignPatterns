import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton logger class that writes messages to a text file.
 * This implementation ensures only one logger instance exists throughout the
 * application.
 */
public class Logger {
    // Singleton instance
    private static Logger logger;
    // Name of the log file
    private String fileName;
    // Writer for writing to the log file
    private FileWriter fileWriter;

    /**
     * Private constructor to prevent instantiation outside of this class.
     * Initializes the logger with a default log file name.
     */
    private Logger() {
        this.fileName = "log.txt";
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    /**
     * Returns the singleton instance of the Logger.
     * Creates a new instance if one doesn't exist yet.
     * 
     * @return The singleton Logger instance
     */
    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    /**
     * Changes the log file name and reopens the FileWriter.
     * 
     * @param name The new log file name
     */
    public void setFileName(String name) {
        try {
            // Close the existing writer if it exists
            if (fileWriter != null) {
                fileWriter.close();
            }

            // Update the filename and create a new writer
            fileName = name;
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            System.err.println("Error changing log file: " + e.getMessage());
        }
    }

    /**
     * Writes a message to the log file.
     * 
     * @param message The message to write
     */
    public void write(String message) {
        try {
            fileWriter.write(message + System.lineSeparator());
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    /**
     * Closes the FileWriter resource.
     * Should be called when logging is no longer needed.
     */
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error closing writer: " + e.getMessage());
        }
    }
}
