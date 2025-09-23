package com.example.model;
/**
 * Represents a water tile in the game world.
 * Implements the Tile interface.
 */
public class WaterTile implements Tile {
    /** Character representation of the water tile */
    public String chara = "W";
    /** Description of the water tile */
    public String desc = "A water tile. You can swim across it.";

    /**
     * Returns the character representation of this tile.
     * 
     * @return the character that represents this tile
     */
    public String getCharacter() {
        return chara;
    };

    /**
     * Returns the description of this tile.
     * 
     * @return the description of this tile
     */
    public String getDescription() {
        return desc;
    };

    /**
     * Performs the action associated with this tile.
     * 
     * @return a message describing the action performed
     */
    public String action() {
        return "You swim across the water.";
    };

    /**
     * Returns the type of this tile.
     * 
     * @return the type name ("Water")
     */
    public String getType() {
        return "Water";
    }
}
