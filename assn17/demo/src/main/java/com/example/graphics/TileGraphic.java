package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Interface for tile graphics.
 * Defines methods for drawing tiles and retrieving their images.
 */
public interface TileGraphic {
    /**
     * Draws the tile at the specified coordinates.
     *
     * @param gc the graphics context to draw on
     * @param x the x-coordinate where the tile should be drawn
     * @param y the y-coordinate where the tile should be drawn
     */
    void draw(GraphicsContext gc, double x, double y);
    
    /**s
     * Returns the image associated with this tile.
     *
     * @return the tile's image
     */
    Image getImage();
}
