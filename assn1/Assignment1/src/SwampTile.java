/**
 * Represents a swamp tile in the game world.
 * Implements the Tile interface.
 */
public class SwampTile implements Tile {
    // The character representation of the swamp tile on the map
    public String chara = "S";
    // Description of the swamp tile
    public String desc = "A swamp tile.";

    /**
     * Returns the character representation of this tile.
     * 
     * @return A string containing the character that represents this tile
     */
    public String getCharacter() {
        return chara;
    };

    /**
     * Returns the description of this tile.
     * 
     * @return A string containing the description of this tile
     */
    public String getDescription() {
        return desc;
    };

    /**
     * Performs the action associated with this tile.
     * 
     * @return A string representing the result of the action
     */
    public String action() {
        return "Action";
    };

    /**
     * Returns the type of this tile.
     * 
     * @return A string representing the type of this tile
     */
    public String getType() {
        return "Swamp";
    }
}
