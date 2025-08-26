/**
 * WeatherStation class that simulates a weather station with temperature
 * updates.
 * This class implements the Runnable interface to run as a separate thread.
 * It follows the Observer pattern to notify registered observers about
 * temperature changes.
 */
public class WeatherStation implements Runnable {
    public Observer[] observers; // Array to store registered observers
    public Double temperature; // Current temperature value
    public final Double tempMax = 50.00; // Maximum allowed temperature
    public final Double tempMin = -50.00; // Minimum allowed temperature

    /**
     * Constructor initializes the observer array and sets a random starting
     * temperature.
     */
    public WeatherStation() {
        this.observers = new Observer[10]; // Initialize with capacity for 10 observers
        this.temperature = tempMin + Math.random() * (tempMax - tempMin); // Random initial temperature
    }

    /**
     * Adds an observer to the first available null slot in the observers array.
     * 
     * @param observer The observer to add
     */
    public void addObserver(Observer observer) {
        Observer[] newlist = observers.clone(); // Create a copy of the current observers array
        for (int i = 0; i < observers.length; i++) {
            if (observers[i] == null) {
                newlist[i] = observer; // Add the observer to the first empty slot
                break;
            }
        }
        observers = newlist; // Replace the original array with the updated one
    }

    /**
     * Removes a specific observer from the array.
     * 
     * @param observer The observer to remove
     */
    public void removeObserver(Observer observer) {
        Observer[] newlist = observers.clone(); // Create a copy of the current observers array
        for (int i = 0; i < observers.length; i++) {
            if (observers[i] == observer) {
                newlist[i] = null; // Remove the observer by setting its position to null
                break;
            }
        }
        observers = newlist; // Replace the original array with the updated one
    }

    /**
     * Method to notify observers about updates.
     * Currently not implemented.
     */
    public void notifyUpdate() {
        // Empty method, notification is handled in the run method
        // Notify all registered observers about the temperature update
        for (Observer observer : observers) {
            if (observer != null) {
                observer.update(temperature);
            }
        }
    }

    /**
     * Stops the weather station simulation by interrupting the current thread.
     * This method allows for a clean shutdown of the simulation thread.
     */
    public void stopSimulation() {
        Thread.currentThread().interrupt();
    }

    /**
     * The run method that executes when the thread starts.
     * Continuously updates temperature at random intervals and notifies observers.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Sleep for random interval between 1-5 seconds
                int sleepTime = 1000 + (int) (Math.random() * 4000);
                Thread.sleep(sleepTime);

                // Generate a random temperature change between -5 and +5 degrees
                double tempChange = -1 + Math.random() * 10;
                double newTemp = temperature + tempChange;

                // Ensure the temperature stays within the defined bounds
                if (newTemp > tempMax) {
                    temperature = tempMax;
                } else if (newTemp < tempMin) {
                    temperature = tempMin;
                } else {
                    temperature = newTemp;
                }

                notifyUpdate();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                break; // Exit the loop if thread is interrupted
            }
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
