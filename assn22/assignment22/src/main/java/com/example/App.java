package com.example;

import com.example.gui.PixelArtController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX Pixel Art Editor Application
 * Main entry point for the pixel art editor application.
 * Sets up the UI components, keyboard controls, and window properties.
 */
public class App extends Application {

    /**
     * Starts the JavaFX application and initializes the UI.
     * 
     * @param stage The primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        // Create the main controller that manages the pixel grid and user interactions
        PixelArtController controller = new PixelArtController(stage);
        
        // Create root layout using BorderPane for flexible positioning
        BorderPane root = new BorderPane();
        
        // Create main content area for the center of the window
        VBox centerContent = new VBox();
        centerContent.setAlignment(Pos.CENTER); // Center align all children
        centerContent.setSpacing(20); // Add 20px spacing between children
        centerContent.setPadding(new Insets(20)); // Add 20px padding around edges
        
        // Add title label at the top of the center content
        Label titleLabel = new Label("Pixel Art Editor");
        titleLabel.setStyle(
            "-fx-font-size: 24px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #333333;"
        );
        
        // Add title and pixel grid to the center content area
        centerContent.getChildren().addAll(
            titleLabel,
            controller.getPixelGridView()
        );
        
        // Set up the main layout structure
        root.setCenter(centerContent); // Place grid in center
        root.setRight(controller.getControlPanel()); // Place controls on right side
        
        // Create scene with specified dimensions
        Scene scene = new Scene(root, 900, 650);
        
        // Set up keyboard input handling for arrow keys and spacebar
        scene.setOnKeyPressed(controller.getKeyboardInputHandler());
        
        // Configure window properties
        stage.setTitle("Pixel Art Editor - Use Arrow Keys to Move, Space to Toggle");
        stage.setScene(scene);
        stage.setMinWidth(800); // Set minimum window width
        stage.setMinHeight(600); // Set minimum window height
        stage.setResizable(false); // Prevent window resizing
        
        // Ensure the scene is focusable so it can receive keyboard input
        scene.getRoot().setFocusTraversable(true);
        scene.getRoot().requestFocus();
        
        // Display the window
        stage.show();
        
        // Print initial instructions to console for user reference
        System.out.println("=== Pixel Art Editor Started ===");
        System.out.println("Controls:");
        System.out.println("  Arrow Keys - Move cursor");
        System.out.println("  Space - Toggle pixel on/off");
        System.out.println("  Ctrl+C - Generate code (or use button)");
        System.out.println("================================");
    }

    /**
     * Main entry point for the application.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        launch(); // Launch the JavaFX application
    }
}