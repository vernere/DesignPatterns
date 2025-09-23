package com.example;

import com.example.model.Game;
import com.example.model.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Controller class that manages the game UI and interactions between the game model and view.
 * Handles the creation of the user interface and map rendering.
 */
public class PrimaryController {
    // Game model reference
    private Game game;
    // Canvas for drawing the map
    private Canvas canvas;
    // Graphics context for drawing operations
    private GraphicsContext gc;
    // Renderer for map visualization
    private MapRenderer mr;
    // Current map being displayed
    private Map map;
    
    /**
     * Constructor that initializes the game and rendering components.
     */
    public PrimaryController() {
        // Initialize the game model
        game = new Game();
        
        // Create a canvas with defined dimensions for rendering the map
        canvas = new Canvas(600, 400);
        // Get the graphics context for drawing on the canvas
        gc = canvas.getGraphicsContext2D();
        // Initialize the map renderer
        mr = new MapRenderer();
        // Set the graphics context for the renderer
        mr.setCanvas(gc);
    }
    
    /**
     * Creates and returns the main UI layout with map display and control buttons.
     * @return BorderPane containing the complete UI
     */
    public BorderPane createContent() {
        // Create buttons for map selection
        Button wildernessButton = new Button("Wilderness Map");
        Button cityButton = new Button("City Map");

        // Set action for wilderness map button
        wildernessButton.setOnAction(e -> {
            // Create wilderness map (type 1)
            map = game.createMap(1);
            // Render the created map
            renderMap(map);
        });

        // Set action for city map button
        cityButton.setOnAction(e -> {
            // Create city map (type 2)
            map = game.createMap(2);
            // Render the created map
            renderMap(map);
        });

        // Create horizontal button container with spacing
        HBox buttonBar = new HBox(10, wildernessButton, cityButton);
        // Create the main layout container
        BorderPane root = new BorderPane();
        // Place the canvas in the center
        root.setCenter(canvas);
        // Place the buttons at the bottom
        root.setBottom(buttonBar);
        
        return root;
    }
    
    /**
     * Renders the provided map on the canvas.
     * Clears the previous content and draws the new map.
     * @param map The map to be rendered
     */
    private void renderMap(Map map) {
        // Clear any existing content on the canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Set the map to be rendered
        mr.setMap(map);
        // Render the map tiles
        mr.renderTiles();
    }
}
