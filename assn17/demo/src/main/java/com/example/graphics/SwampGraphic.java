package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * SwampGraphic implements the TileGraphic interface to represent swamp tiles in the game.
 * This class handles loading and rendering swamp terrain images.
 */
public class SwampGraphic implements TileGraphic {
    // The image resource for the swamp tile
    private Image image;
    // The size of each tile in pixels
    private final int TILE_SIZE = 60;

    /**
     * Constructor that initializes the swamp graphic by loading the image resource.
     * If the image cannot be loaded, error handling is implemented.
     */
    public SwampGraphic() {
        // Load the image from resources
        try {
            // Load the swamp image from the resources folder
            image = new Image(getClass().getResourceAsStream("/com/example/images/swamp.png"));

        } catch (Exception e) {
            // Log error if image loading fails
            System.err.println("Failed to load swamp image: " + e.getMessage());
            // The image will remain null, triggering fallback rendering
        }
    }

    /**
     * Draws the swamp tile on the provided graphics context at the specified grid coordinates.
     * If the image failed to load, a fallback colored rectangle is drawn instead.
     * 
     * @param gc The graphics context to draw on
     * @param x The x-coordinate in the grid (will be multiplied by TILE_SIZE)
     * @param y The y-coordinate in the grid (will be multiplied by TILE_SIZE)
     */
    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        if (image != null) {
            // Draw the swamp image at the calculated pixel coordinates
            gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Fallback rendering using dark green color if image is unavailable
            gc.setFill(javafx.scene.paint.Color.DARKGREEN);
            gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Returns the swamp tile image.
     * 
     * @return The Image object representing the swamp tile
     */
    @Override
    public Image getImage() {
        return image;
    }
}
