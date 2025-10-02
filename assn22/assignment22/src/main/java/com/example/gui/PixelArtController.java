package com.example.gui;

import com.example.invokers.CommandInvoker;
import com.example.receivers.PixelGrid;
import javafx.stage.Stage;

/**
 * Main controller that coordinates all GUI components and handles their interactions.
 * This class follows the MVC pattern, acting as the controller that manages the model
 * (PixelGrid) and the views (PixelGridView and ControlPanel).
 */
public class PixelArtController {
    // Core model and command pattern components
    private final PixelGrid pixelGrid;              // The model - holds the pixel data
    private final CommandInvoker commandInvoker;    // Handles command execution and undo/redo
    
    // View components
    private final PixelGridView pixelGridView;      // Visual representation of the pixel grid
    private final ControlPanel controlPanel;        // UI controls for the application
    private final KeyboardInputHandler keyboardInputHandler;  // Handles keyboard shortcuts
    
    /**
     * Creates a new PixelArtController.
     * Initializes all components and establishes connections between them.
     */
    public PixelArtController() {
        this(null);
    }
    
    /**
     * Creates a new PixelArtController with a parent stage reference.
     * Initializes all components and establishes connections between them.
     * @param parentStage The parent stage for modal dialogs
     */
    public PixelArtController(Stage parentStage) {
        // Initialize model and command invoker
        this.pixelGrid = new PixelGrid();
        this.commandInvoker = new CommandInvoker();
        
        // Initialize GUI components, passing necessary dependencies
        this.pixelGridView = new PixelGridView(pixelGrid);
        this.controlPanel = new ControlPanel(commandInvoker, pixelGrid, parentStage);
        this.keyboardInputHandler = new KeyboardInputHandler(commandInvoker, pixelGrid, parentStage);
        
        // Set up listener connections using Observer pattern
        setupListeners();
    }
    
    /**
     * Sets up the listener connections between model and view.
     * Implements the Observer pattern to keep views synchronized with model changes.
     */
    private void setupListeners() {
        // Add the grid view as a listener to the pixel grid
        // This ensures the view updates whenever pixels are modified
        pixelGrid.addListener(pixelGridView);
        
        // Add listener for cursor position updates in control panel
        // Uses an anonymous inner class to handle cursor movement events
        pixelGrid.addListener(new com.example.receivers.Listener() {
            @Override
            public void onPixelChanged(int x, int y) {
                // No action needed for control panel on pixel change
                // Control panel only cares about cursor position, not pixel changes
            }
            
            @Override
            public void onCursorMoved(int x, int y) {
                // Update the control panel to display the new cursor position
                controlPanel.updateCursorPosition();
            }
        });
    }
    
    /**
     * Gets the pixel grid view component.
     * @return The pixel grid view that displays the pixel canvas
     */
    public PixelGridView getPixelGridView() {
        return pixelGridView;
    }
    
    /**
     * Gets the control panel component.
     * @return The control panel containing UI controls
     */
    public ControlPanel getControlPanel() {
        return controlPanel;
    }
    
    /**
     * Gets the keyboard input handler.
     * @return The keyboard input handler for shortcut processing
     */
    public KeyboardInputHandler getKeyboardInputHandler() {
        return keyboardInputHandler;
    }
    
    /**
     * Gets the pixel grid model.
     * @return The pixel grid model containing the application state
     */
    public PixelGrid getPixelGrid() {
        return pixelGrid;
    }
    
    /**
     * Gets the command invoker.
     * @return The command invoker for executing and managing commands
     */
    public CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
}