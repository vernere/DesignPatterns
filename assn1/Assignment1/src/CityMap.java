/**
 * CityMap class that extends the base Map class.
 * Represents an urban environment with buildings, roads, and forests.
 */
public class CityMap extends Map {

    /**
     * Constructor for CityMap.
     * Creates a city map with fixed dimensions of 10x5.
     */
    public CityMap() {
        super(10, 5); // This already sets width and height in the parent class
        // No need to redefine width and height here
    }

    /**
     * Creates a random tile appropriate for a city environment.
     * Overrides the createTile method from the parent Map class.
     * 
     * @return A new Tile object (BuildingTile, RoadTile, or ForestTile)
     */
    @Override
    public Tile createTile() {
        // Generate a random number between 0-3 (adding forest tiles)
        int randomTile = (int) (Math.random() * 4);

        // Return different tile types based on the random number
        switch (randomTile) {
            case 0:
                return new BuildingTile(); // 25% chance for building
            case 1:
                return new RoadTile(); // 25% chance for road
            case 2:
                return new ForestTile(); // 25% chance for forest
            case 3:
                return new BuildingTile(); // Another 25% chance for building (more buildings for urban feel)
            default:
                return new RoadTile(); // Default case (shouldn't occur with current random range)
        }
    }
}
