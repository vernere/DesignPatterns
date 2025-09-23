package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Represents a forest tile graphic for the game map
 * Implements the TileGraphic interface for drawing forest tiles
 */
public class ForestGraphic implements TileGraphic {
    private Image image; // Holds the forest tile image
    private final int TILE_SIZE = 60; // Set the size of each tile in pixels
    
    /**
     * Constructor initializes the forest graphic
     * Attempts to load the forest image from resources
     */
    public ForestGraphic() {
        // Load the image from resources
        try {
            // Load the forest image from the specified path
            image = new Image(getClass().getResourceAsStream("/com/example/images/forest.png"));

        } catch (Exception e) {
            System.err.println("Failed to load forest image: " + e.getMessage());
            // Image will remain null, fallback rendering will be used
        }
    }

    /**
     * Draws the forest tile at the specified grid coordinates
     * @param gc The GraphicsContext to draw on
     * @param x The x-coordinate in the grid
     * @param y The y-coordinate in the grid
     */
    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        if (image != null) {
            // Draw the forest image at the calculated pixel position
            gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Fallback rendering if image loading failed - draw a dark green rectangle
            gc.setFill(javafx.scene.paint.Color.DARKGREEN);
            gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Returns the forest image
     * @return The forest tile image, may be null if loading failed
     */
    @Override
    public Image getImage() {
        return image;
    }
}
