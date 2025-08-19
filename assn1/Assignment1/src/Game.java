/**
 * Game class responsible for managing game functionalities.
 */
public class Game {

    /**
     * Creates a map based on the user's choice.
     * 
     * @param choice An integer representing the map type selection:
     *               1 for Wilderness map, any other value for City map
     */
    public void createMap(int choice) {
        if (choice == 1) {
            // Create and display a wilderness map
            Map map = new WildernessMap();
            map.generateMap();
            map.display();

        } else {
            // Create and display a city map
            Map map = new CityMap();
            map.generateMap();
            map.display();
        }
    }
}
