package com.example.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * RoadGraphic implements the TileGraphic interface to represent road tiles in the game.
 * This class handles loading and drawing road images on the game canvas.
 */
public class RoadGraphic implements TileGraphic {
    private Image image;
    private final int TILE_SIZE = 60; // Size in pixels for each road tile
    
    /**
     * Constructor initializes the road graphic by loading the road image from resources.
     * If image loading fails, the error is caught and logged.
     */
    public RoadGraphic() {
        // Load the image from resources
        try {
            // Attempt to load the road image from the resources folder
            image = new Image(getClass().getResourceAsStream("/com/example/images/road.png"));

        } catch (Exception e) {
            System.err.println("Failed to load road image: " + e.getMessage());
            // Image will remain null, triggering fallback rendering
        }
    }

    /**
     * Draws the road tile at the specified grid coordinates.
     * 
     * @param gc The GraphicsContext to draw on
     * @param x The x-coordinate in the grid (will be multiplied by TILE_SIZE)
     * @param y The y-coordinate in the grid (will be multiplied by TILE_SIZE)
     */
    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        if (image != null) {
            // Draw the road image at the calculated pixel coordinates
            gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Fallback rendering if image loading failed - draw a dark green rectangle
            gc.setFill(javafx.scene.paint.Color.DARKGREEN);
            gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Returns the road image.
     * 
     * @return The Image object representing the road tile
     */
    @Override
    public Image getImage() {
        return image;
    }
}
