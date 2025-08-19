/**
 * WildernessMap represents a wilderness-themed map in the game.
 * It extends the base Map class and generates wilderness-specific tiles.
 */
public class WildernessMap extends Map {

    /**
     * Constructor for WildernessMap.
     * Creates a wilderness map with default dimensions of 10x5.
     */
    public WildernessMap() {
        super(10, 5); // Using default values, adjust as needed
        // No need to redefine width and height as they're inherited from Map
    }

    /**
     * Creates a random tile appropriate for a wilderness map.
     * Overrides the createTile method from the parent Map class.
     * 
     * @return A randomly selected wilderness tile (Swamp, Water, or Forest)
     */
    @Override
    public Tile createTile() {
        // Generate a random number between 0-2
        int randomTile = (int) (Math.random() * 3);

        // Return different tile types based on the random number
        switch (randomTile) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                return new SwampTile(); // Default case
        }
    }
}
