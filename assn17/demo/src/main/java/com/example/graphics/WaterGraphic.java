package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Implementation of TileGraphic that represents water tiles in the game.
 * This class handles loading and drawing water tile images.
 */
public class WaterGraphic implements TileGraphic {
    private Image image; // The water tile image
    private final int TILE_SIZE = 60; // Size of each tile in pixels
    
    /**
     * Constructor that loads the water tile image from resources.
     * If image loading fails, it will use a fallback rendering.
     */
    public WaterGraphic() {
        // Load the image from resources
        try {
            // Attempt to load the water image from the resources directory
            image = new Image(getClass().getResourceAsStream("/com/example/images/water.png"));
        } catch (Exception e) {
            System.err.println("Failed to load water image: " + e.getMessage());
            // Image will remain null, triggering fallback rendering
        }
    }

    /**
     * Draws the water tile at the specified grid coordinates.
     * 
     * @param gc The GraphicsContext to draw on
     * @param x The x-coordinate in the grid (will be multiplied by TILE_SIZE)
     * @param y The y-coordinate in the grid (will be multiplied by TILE_SIZE)
     */
    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        if (image != null) {
            // Draw the water image at the specified grid position
            gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Fallback rendering if image loading failed - draw a blue rectangle
            gc.setFill(javafx.scene.paint.Color.DARKGREEN);
            gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Returns the image used for this tile.
     * 
     * @return The water tile image
     */
    @Override
    public Image getImage() {
        return image;
    }
}
