/**
 * ObserverB implements the Observer interface to receive temperature updates.
 * This observer prints a formatted message when notified of temperature
 * changes.
 */
public class ObserverB implements Observer {

    /**
     * Updates this observer with the current temperature.
     * Displays the temperature along with a fixed comment about warmth.
     *
     * @param temp The current temperature in Celsius
     */
    @Override
    public void update(Double temp) {
        System.out.println("=== Observer B Update ===");
        System.out.printf("Temperature: %.1f°C\n", temp);
        System.out.println("Comment: Pheew that's really warm!");
        System.out.println("========================");
    }
}
