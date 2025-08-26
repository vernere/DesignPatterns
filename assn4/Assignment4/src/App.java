/**
 * Main application class that demonstrates the Observer pattern.
 */
public class App {
    /**
     * Entry point of the application.
     * Creates a weather station and observers, then registers observers with
     * the weather station and starts the simulation.
     * 
     * @param args Command line arguments (not used)
     * @throws Exception If an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        // Create the subject (observable)
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();

        // Register observers with the subject
        weatherStation.addObserver(observerA);
        weatherStation.addObserver(observerB);

        // Start the weather station simulation
        new Thread(weatherStation).start();

        // Let the simulation run for a while
        try {
            Thread.sleep(10000); // Run for 5 seconds with both observers
            System.out.println("\n--- Removing ObserverA from the weather station ---\n");
            weatherStation.removeObserver(observerA);

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
    }
}
