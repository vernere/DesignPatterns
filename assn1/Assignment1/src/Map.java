/**
 * Abstract base class representing a game map.
 * Uses the Factory Method pattern for creating tiles.
 */
public abstract class Map {

    /** 2D array to store all tiles in the map */
    public Tile[][] tiles;

    /** Width of the map (number of columns) */
    public int width;

    /** Height of the map (number of rows) */
    public int height;

    /**
     * Constructor to initialize the map dimensions.
     * 
     * @param x Width of the map
     * @param y Height of the map
     */
    public Map(int x, int y) {
        this.width = x;
        this.height = y;
        this.tiles = new Tile[height][width];
    }

    /**
     * Populates the entire map with tiles.
     * Uses the factory method pattern by calling createTile().
     */
    public void generateMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = createTile(); // Use the factory method to create tiles
            }
        }
    }

    /**
     * Factory method that subclasses must implement to create specific tile types.
     * 
     * @return A new Tile instance
     */
    public abstract Tile createTile();

    /**
     * Displays the map in a grid format with borders.
     * Each tile is represented by its character.
     */
    public void display() {
        // Print top border
        System.out.print("+");
        for (int x = 0; x < width; x++) {
            System.out.print("-+");
        }
        System.out.println();

        // Print each row with left/right borders
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (tiles[y][x] != null) {
                    System.out.print(tiles[y][x].getCharacter());
                } else {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();

            // Print row separator
            System.out.print("+");
            for (int x = 0; x < width; x++) {
                System.out.print("-+");
            }
            System.out.println();
        }
    }
}
