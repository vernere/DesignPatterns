/**
 * Main application class that demonstrates the Adapter design pattern.
 * This example shows how to adapt legacy Calendar functionality to a new date
 * interface.
 */
public class App {
    /**
     * Entry point for the application.
     * Creates a calendar adapter and demonstrates date manipulation operations.
     * 
     * @param args Command line arguments (not used)
     * @throws Exception If any error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        // Initialize the adapter with a specific date (April 20, 2005)
        CalendarToNewDateAdapter ada = new CalendarToNewDateAdapter(20, 4, 2005);

        // Display the initial date
        System.out.println("Date: " + ada.getDay() + "." + ada.getMonth() + "." + ada.getYear());

        // Advance by 10 days and display the result
        ada.advanceDays(10);
        System.out.println("Date: " + ada.getDay() + "." + ada.getMonth() + "." + ada.getYear());

        // Advance by another 10 days and display the result
        ada.advanceDays(10);
        System.out.println("Date: " + ada.getDay() + "." + ada.getMonth() + "." + ada.getYear());
    }
}
