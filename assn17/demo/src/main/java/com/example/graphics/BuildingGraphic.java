package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Represents a building graphic that can be drawn on a tile-based map.
 * Implements the TileGraphic interface for consistent rendering.
 */
public class BuildingGraphic implements TileGraphic {
    // The image that represents the building
    private Image image;
    // The size of each tile in pixels
    private final int TILE_SIZE = 60;
    
    /**
     * Constructor that initializes the building graphic by loading the appropriate image.
     * Includes error handling for when the image cannot be loaded.
     */
    public BuildingGraphic() {
        // Load the image from resources
        try {
            // Attempt to load the house image from the resources folder
            image = new Image(getClass().getResourceAsStream("/com/example/images/house.png"));

        } catch (Exception e) {
            // Log error message if image loading fails
            System.err.println("Failed to load building image: " + e.getMessage());
            // image will remain null, triggering the fallback rendering
        }
    }

    /**
     * Draws the building graphic at the specified grid coordinates.
     * 
     * @param gc The GraphicsContext to draw on
     * @param x The x-coordinate in the grid (will be multiplied by TILE_SIZE)
     * @param y The y-coordinate in the grid (will be multiplied by TILE_SIZE)
     */
    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        if (image != null) {
            // Draw the building image at the calculated pixel coordinates
            gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Fallback rendering if image loading failed - draw a dark green rectangle
            gc.setFill(javafx.scene.paint.Color.DARKGREEN);
            gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Returns the image used for this building graphic.
     * 
     * @return The building image
     */
    @Override
    public Image getImage() {
        return image;
    }
}
