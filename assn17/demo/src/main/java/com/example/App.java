package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX App without FXML dependencies, using Canvas for rendering.
 * This is the main application class that initializes the JavaFX framework.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Create the controller which will handle the application logic
        PrimaryController controller = new PrimaryController();
        
        // Get the content (UI elements) from the controller
        // BorderPane is a layout container that manages content in 5 regions (top, right, bottom, left, center)
        BorderPane root = controller.createContent();
        
        // Set up the scene with the root layout and dimensions (640x480 pixels)
        Scene scene = new Scene(root, 640, 480);
        
        // Configure the primary stage (window)
        stage.setTitle("Map Generator"); // Set the window title
        stage.setScene(scene);           // Attach the scene to the stage
        stage.show();                    // Display the window
    }

    /**
     * The main entry point for the application.
     * JavaFX will call the start() method after initializing.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(); // Launch the JavaFX application
    }
}
