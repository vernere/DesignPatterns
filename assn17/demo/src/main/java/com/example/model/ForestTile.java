package com.example.model;

/**
 * Represents a forest tile in the game map.
 * Implements the Tile interface.
 */
public class ForestTile implements Tile {
    /** Character representation of the forest tile on the map */
    public String chara = "F";
    /** Description of the forest tile */
    public String desc = "A forested tile.";

    /**
     * Returns the character representation of this tile.
     * 
     * @return The character that represents this tile on the map
     */
    public String getCharacter() {
        return chara;
    };

    /**
     * Returns the description of this tile.
     * 
     * @return A description of the forest tile
     */
    public String getDescription() {
        return desc;
    };

    /**
     * Performs an action when the player interacts with this tile.
     * 
     * @return The result of the action
     */
    public String action() {
        return "Action";
    };

    /**
     * Returns the type of this tile.
     * 
     * @return The string "Forest" representing the tile type
     */
    public String getType() {
        return "Forest";
    }
}
