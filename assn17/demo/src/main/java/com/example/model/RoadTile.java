package com.example.model;
/**
 * Represents a road tile in the game world.
 * Implements the Tile interface.
 */
public class RoadTile implements Tile {
    /** Character representation of this tile on the map */
    public String chara = "R";

    /** Description of the road tile */
    public String desc = "A road tile.";

    /**
     * Returns the character that represents this tile.
     * 
     * @return The tile's character representation
     */
    public String getCharacter() {
        return chara;
    };

    /**
     * Returns the description of this tile.
     * 
     * @return The tile's description
     */
    public String getDescription() {
        return desc;
    };

    /**
     * Performs the action associated with this tile.
     * 
     * @return The result of the action
     */
    public String action() {
        return "Action";
    };

    /**
     * Returns the type of this tile.
     * 
     * @return The string "Road"
     */
    public String getType() {
        return "Road";
    }
}
