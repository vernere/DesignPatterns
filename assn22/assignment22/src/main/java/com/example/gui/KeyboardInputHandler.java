package com.example.gui;

import com.example.commands.*;
import com.example.invokers.CommandInvoker;
import com.example.receivers.PixelGrid;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Handles keyboard input for the pixel art editor.
 * Maps key presses to appropriate commands.
 */
public class KeyboardInputHandler implements EventHandler<KeyEvent> {
    /** The command invoker used to execute commands */
    private final CommandInvoker commandInvoker;
    
    // Commands
    /** Command to move the cursor up */
    private final MoveCursorUpCommand moveCursorUpCommand;
    /** Command to move the cursor down */
    private final MoveCursorDownCommand moveCursorDownCommand;
    /** Command to move the cursor left */
    private final MoveCursorLeftCommand moveCursorLeftCommand;
    /** Command to move the cursor right */
    private final MoveCursorRightCommand moveCursorRightCommand;
    /** Command to toggle the pixel at the current cursor position */
    private final TogglePixelCommand togglePixelCommand;
    /** Command to generate code from the current pixel grid */
    private final GenerateCodeCommand generateCodeCommand;
    
    /**
     * Creates a new KeyboardInputHandler.
     * Initializes all command objects with the provided pixel grid.
     * 
     * @param commandInvoker The command invoker to execute commands
     * @param pixelGrid The pixel grid model
     */
    public KeyboardInputHandler(CommandInvoker commandInvoker, PixelGrid pixelGrid) {
        this(commandInvoker, pixelGrid, null);
    }
    
    /**
     * Creates a new KeyboardInputHandler with a parent stage reference.
     * Initializes all command objects with the provided pixel grid.
     * 
     * @param commandInvoker The command invoker to execute commands
     * @param pixelGrid The pixel grid model
     * @param parentStage The parent stage for modal dialogs
     */
    public KeyboardInputHandler(CommandInvoker commandInvoker, PixelGrid pixelGrid, Stage parentStage) {
        this.commandInvoker = commandInvoker;
        
        // Initialize commands with the pixel grid receiver
        this.moveCursorUpCommand = new MoveCursorUpCommand(pixelGrid);
        this.moveCursorDownCommand = new MoveCursorDownCommand(pixelGrid);
        this.moveCursorLeftCommand = new MoveCursorLeftCommand(pixelGrid);
        this.moveCursorRightCommand = new MoveCursorRightCommand(pixelGrid);
        this.togglePixelCommand = new TogglePixelCommand(pixelGrid);
        this.generateCodeCommand = new GenerateCodeCommand(pixelGrid, parentStage);
    }
    
    /**
     * Handles keyboard events and maps them to commands.
     * Supported keys:
     * - Arrow keys: Move cursor
     * - Space: Toggle pixel
     * - Ctrl+C: Generate code
     * 
     * @param event The keyboard event to handle
     */
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                // Move cursor up one row
                commandInvoker.executeCommand(moveCursorUpCommand);
                event.consume();
                break;
                
            case DOWN:
                // Move cursor down one row
                commandInvoker.executeCommand(moveCursorDownCommand);
                event.consume();
                break;
                
            case LEFT:
                // Move cursor left one column
                commandInvoker.executeCommand(moveCursorLeftCommand);
                event.consume();
                break;
                
            case RIGHT:
                // Move cursor right one column
                commandInvoker.executeCommand(moveCursorRightCommand);
                event.consume();
                break;
                
            case SPACE:
                // Toggle the pixel at current cursor position
                commandInvoker.executeCommand(togglePixelCommand);
                event.consume();
                break;
                
            case C:
                // Generate code when Ctrl+C is pressed
                if (event.isControlDown()) {
                    commandInvoker.executeCommand(generateCodeCommand);
                    event.consume();
                }
                break;
                
            default:
                // Ignore unhandled keys
                break;
        }
    }
}