import java.util.Scanner;

/**
 * Main application class that demonstrates the Builder pattern for computer configuration
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Build a gaming computer
        // Initialize the gaming computer builder with user input capability
        ComputerBuilder gamingBuilder = new GamingComputerBuilder(scanner);
        // Create a director to manage the building process
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        // Construct the gaming computer through the director
        Computer gamingComputer = gamingDirector.buildComputer();
        // Display the gaming computer configuration
        gamingComputer.printConfiguration();

        // Build an office computer
        // Initialize the office computer builder with user input capability
        ComputerBuilder officeBuilder = new OfficeComputerBuilder(scanner);
        // Create a director to manage the building process
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        // Construct the office computer through the director
        Computer officeComputer = officeDirector.buildComputer();
        // Display the office computer configuration
        officeComputer.printConfiguration();

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
