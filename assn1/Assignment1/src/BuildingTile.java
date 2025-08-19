/**
 * Represents a building tile in the game world.
 * Implements the Tile interface.
 */
public class BuildingTile implements Tile {
    /** Character representation of the building tile on the map */
    public String chara = "B";

    /** Description of the building tile */
    public String desc = "A building tile.";

    /**
     * Returns the character representation of this tile.
     * 
     * @return A string containing the character representation
     */
    public String getCharacter() {
        return chara;
    };

    /**
     * Returns the description of this tile.
     * 
     * @return A string containing the tile description
     */
    public String getDescription() {
        return desc;
    };

    /**
     * Performs an action when a player interacts with this tile.
     * 
     * @return A string representing the result of the action
     */
    public String action() {
        return "Action";
    };

    /**
     * Returns the type of this tile.
     * 
     * @return A string indicating this is a building tile
     */
    public String getType() {
        return "Building";
    }
}
