/**
 * Observer implementation that displays temperature updates with a comment.
 * This observer specifically provides a "cold" comment regardless of the
 * temperature.
 */
public class ObserverA implements Observer {

    /**
     * Updates the observer with the latest temperature.
     * Displays the temperature in Celsius along with a fixed comment.
     * 
     * @param temp The current temperature in Celsius
     */
    @Override
    public void update(Double temp) {
        System.out.println("=== Observer A Update ===");
        System.out.printf("Temperature: %.1f°C\n", temp);
        System.out.println("Comment: Brr that's cold!");
        System.out.println("========================");
    }
}
