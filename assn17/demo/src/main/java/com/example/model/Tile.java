package com.example.model;
/**
 * Represents a tile in a game environment.
 * A tile is a basic element of the game that can be interacted with.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2023-XX-XX
 */
public interface Tile {

    public String getCharacter();

    public String getDescription();

    public String action();

    public String getType();
}
