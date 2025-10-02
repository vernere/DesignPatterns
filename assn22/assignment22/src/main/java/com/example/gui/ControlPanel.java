package com.example.gui;

import com.example.commands.GenerateCodeCommand;
import com.example.invokers.CommandInvoker;
import com.example.receivers.PixelGrid;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Control panel for the pixel art editor containing buttons and information.
 * This panel displays instructions, cursor position, and provides controls
 * for generating code from the pixel art.
 */
public class ControlPanel extends VBox {
    /** The command invoker used to execute commands */
    private final CommandInvoker commandInvoker;
    
    /** The pixel grid model containing the pixel art data */
    private final PixelGrid pixelGrid;
    
    /** Command for generating code from the pixel grid */
    private final GenerateCodeCommand generateCodeCommand;
    
    /** Label displaying user instructions */
    private Label instructionsLabel;
    
    /** Label showing the current cursor position */
    private Label cursorPositionLabel;
    
    /** Button to trigger code generation */
    private Button generateCodeButton;
    
    /**
     * Creates a new ControlPanel.
     * Initializes all components and sets up the layout.
     * 
     * @param commandInvoker The command invoker to execute commands
     * @param pixelGrid The pixel grid model
     */
    public ControlPanel(CommandInvoker commandInvoker, PixelGrid pixelGrid) {
        this(commandInvoker, pixelGrid, null);
    }
    
    /**
     * Creates a new ControlPanel with a parent stage reference.
     * Initializes all components and sets up the layout.
     * 
     * @param commandInvoker The command invoker to execute commands
     * @param pixelGrid The pixel grid model
     * @param parentStage The parent stage for modal dialogs
     */
    public ControlPanel(CommandInvoker commandInvoker, PixelGrid pixelGrid, Stage parentStage) {
        this.commandInvoker = commandInvoker;
        this.pixelGrid = pixelGrid;
        this.generateCodeCommand = new GenerateCodeCommand(pixelGrid, parentStage);
        
        // Set up all UI components
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        
        // Display initial cursor position
        updateCursorPosition();
    }
    
    /**
     * Initializes the UI components with their styles and properties.
     * Creates the instructions label, cursor position label, and generate code button.
     */
    private void initializeComponents() {
        // Create instructions label with keyboard shortcuts
        instructionsLabel = new Label(
            "Instructions:\n" +
            "• Use arrow keys to move cursor\n" +
            "• Press SPACE to toggle pixel\n" +
            "• Ctrl+C to generate code"
        );
        // Style the instructions with a light gray background
        instructionsLabel.setStyle(
            "-fx-font-size: 12px; " +
            "-fx-text-fill: #333333; " +
            "-fx-background-color: #f0f0f0; " +
            "-fx-padding: 10px; " +
            "-fx-border-color: #cccccc; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px;"
        );
        
        // Create label to display current cursor coordinates
        cursorPositionLabel = new Label("Cursor: (0, 0)");
        cursorPositionLabel.setStyle(
            "-fx-font-size: 14px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #333333;"
        );
        
        // Create the generate code button with green styling
        generateCodeButton = new Button("Generate Code");
        generateCodeButton.setStyle(
            "-fx-font-size: 14px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-background-color: #4CAF50; " +
            "-fx-text-fill: white; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px;"
        );
        generateCodeButton.setPrefWidth(150);
        
        // Add hover effect - darken the button when mouse enters
        generateCodeButton.setOnMouseEntered(e -> 
            generateCodeButton.setStyle(
                "-fx-font-size: 14px; " +
                "-fx-padding: 10px 20px; " +
                "-fx-background-color: #45a049; " +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;"
            )
        );
        
        // Restore original color when mouse exits
        generateCodeButton.setOnMouseExited(e -> 
            generateCodeButton.setStyle(
                "-fx-font-size: 14px; " +
                "-fx-padding: 10px 20px; " +
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;"
            )
        );
    }
    
    /**
     * Sets up the layout of the control panel.
     * Configures spacing, padding, alignment, and adds all components.
     */
    private void setupLayout() {
        // Set vertical spacing between components
        setSpacing(15);
        
        // Add padding around the entire panel
        setPadding(new Insets(20));
        
        // Center-align all components at the top
        setAlignment(Pos.TOP_CENTER);
        
        // Add all components to the panel in order
        getChildren().addAll(
            instructionsLabel,
            cursorPositionLabel,
            generateCodeButton
        );
        
        // Set light background color for the panel
        setStyle("-fx-background-color: #fafafa;");
    }
    
    /**
     * Sets up event handlers for the components.
     * Configures the generate code button to execute the command.
     */
    private void setupEventHandlers() {
        // When button is clicked, execute the generate code command
        generateCodeButton.setOnAction(event -> {
            commandInvoker.executeCommand(generateCodeCommand);
        });
    }
    
    /**
     * Updates the cursor position display with the current coordinates.
     * Should be called whenever the cursor moves in the pixel grid.
     */
    public void updateCursorPosition() {
        // Get current cursor coordinates from the pixel grid
        int x = pixelGrid.getCursorX();
        int y = pixelGrid.getCursorY();
        
        // Update the label to show the current position
        cursorPositionLabel.setText(String.format("Cursor: (%d, %d)", x, y));
    }
}