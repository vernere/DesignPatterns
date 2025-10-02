package com.example.gui;

import com.example.receivers.Listener;
import com.example.receivers.PixelGrid;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Custom JavaFX component that visualizes the 8x8 pixel grid.
 * Implements the Listener interface to receive updates from the PixelGrid model.
 * This view follows the Observer pattern, automatically updating when the model changes.
 */
public class PixelGridView extends GridPane implements Listener {
    // Grid dimensions - fixed 8x8 pixel grid
    private static final int GRID_SIZE = 8;
    
    // Visual appearance constants
    private static final double CELL_SIZE = 40.0; // Size of each pixel cell in pixels
    private static final Color PIXEL_ON_COLOR = Color.BLACK; // Color for active pixels
    private static final Color PIXEL_OFF_COLOR = Color.WHITE; // Color for inactive pixels
    private static final Color CURSOR_COLOR = Color.RED; // Color for cursor highlight
    private static final Color GRID_LINE_COLOR = Color.GRAY; // Color for grid borders
    
    // 2D array holding all cell rectangles for efficient access
    private Rectangle[][] cells;
    
    // Reference to the model this view observes
    private PixelGrid pixelGrid;
    
    // Track cursor position to optimize cursor movement updates
    private int currentCursorX = 0;
    private int currentCursorY = 0;
    
    /**
     * Creates a new PixelGridView with the specified PixelGrid model.
     * Initializes the visual grid and performs initial rendering.
     * @param pixelGrid The model to visualize
     */
    public PixelGridView(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
        this.cells = new Rectangle[GRID_SIZE][GRID_SIZE];
        
        // Build the UI structure
        initializeGrid();
        // Sync with initial model state
        updateDisplay();
    }
    
    /**
     * Initializes the grid with Rectangle nodes and styling.
     * Creates an 8x8 grid of Rectangle cells with borders.
     */
    private void initializeGrid() {
        // Set gaps between cells to create grid lines
        setHgap(1);
        setVgap(1);
        // Set background color for grid lines
        setStyle("-fx-background-color: " + toHexString(GRID_LINE_COLOR) + ";");
        
        // Create and configure each cell in the grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                // Create rectangular cell with specified size
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(PIXEL_OFF_COLOR); // Start with "off" state
                cell.setStroke(GRID_LINE_COLOR); // Border color
                cell.setStrokeWidth(0.5); // Thin border
                
                // Store reference for later updates
                cells[row][col] = cell;
                // Add to GridPane at specified position
                add(cell, col, row);
            }
        }
    }
    
    /**
     * Updates the entire display based on the current state of the PixelGrid.
     * This is a full refresh - used for initialization or complete state changes.
     */
    public void updateDisplay() {
        // Get current pixel states from model
        boolean[][] pixels = pixelGrid.getPixels();
        
        // Update each cell to match model state
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = cells[row][col];
                
                // Set pixel color based on on/off state
                if (pixels[row][col]) {
                    cell.setFill(PIXEL_ON_COLOR); // Pixel is on
                } else {
                    cell.setFill(PIXEL_OFF_COLOR); // Pixel is off
                }
                
                // Highlight cursor position with red border
                if (row == pixelGrid.getCursorX() && col == pixelGrid.getCursorY()) {
                    cell.setStroke(CURSOR_COLOR);
                    cell.setStrokeWidth(3.0); // Thicker border for visibility
                } else {
                    cell.setStroke(GRID_LINE_COLOR);
                    cell.setStrokeWidth(0.5); // Normal border
                }
            }
        }
    }
    
    /**
     * Converts a Color object to a hex string for CSS styling.
     * Formats as #RRGGBB where each component is a 2-digit hex value.
     * @param color The color to convert
     * @return Hex string representation (e.g., "#FF0000" for red)
     */
    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
            (int) (color.getRed() * 255),   // Red component (0-255)
            (int) (color.getGreen() * 255), // Green component (0-255)
            (int) (color.getBlue() * 255)); // Blue component (0-255)
    }
    
    // Listener interface implementations
    // These methods are callbacks invoked by the PixelGrid model
    
    /**
     * Called when a single pixel changes state in the model.
     * Only updates the affected cell for efficiency.
     * @param x Row coordinate of changed pixel
     * @param y Column coordinate of changed pixel
     */
    @Override
    public void onPixelChanged(int x, int y) {
        // Validate coordinates are within grid bounds
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            Rectangle cell = cells[x][y];
            // Get current state from model
            boolean pixelState = pixelGrid.getPixels()[x][y];
            
            // Update cell color to match new state
            if (pixelState) {
                cell.setFill(PIXEL_ON_COLOR); // Turn on
            } else {
                cell.setFill(PIXEL_OFF_COLOR); // Turn off
            }
        }
    }
    
    /**
     * Called when the cursor moves to a new position in the model.
     * Updates visual highlight by removing old cursor and adding new one.
     * @param x New row coordinate of cursor
     * @param y New column coordinate of cursor
     */
    @Override
    public void onCursorMoved(int x, int y) {
        // Remove cursor highlight from previous position
        if (currentCursorX >= 0 && currentCursorX < GRID_SIZE && 
            currentCursorY >= 0 && currentCursorY < GRID_SIZE) {
            Rectangle oldCell = cells[currentCursorX][currentCursorY];
            oldCell.setStroke(GRID_LINE_COLOR); // Restore normal border
            oldCell.setStrokeWidth(0.5);
        }
        
        // Add cursor highlight to new position
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            Rectangle newCell = cells[x][y];
            newCell.setStroke(CURSOR_COLOR); // Apply cursor highlight
            newCell.setStrokeWidth(3.0); // Thicker border
            
            // Update tracked position for next cursor move
            currentCursorX = x;
            currentCursorY = y;
        }
    }
}