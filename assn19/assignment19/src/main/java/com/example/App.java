package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.example.controller.ChatClientController;
import com.example.controller.ChatWindowController;
import com.example.model.ChatMediator;

import java.io.IOException;

/**
 * JavaFX Chat Application demonstrating the Mediator pattern.
 * Creates multiple chat client windows that communicate through a central mediator.
 * The mediator pattern helps to reduce coupling between chat clients by having them
 * communicate through a central point instead of directly with each other.
 */
public class App extends Application {

    // The central mediator object that all chat clients will communicate through
    private ChatMediator mediator;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Create the central mediator that will handle message passing between clients
        mediator = new ChatMediator();
        
        // Create three chat clients with different usernames and position their windows
        // on the screen at different coordinates
        createChatWindow("Alice", 100, 100);  // First client positioned at (100, 100)
        createChatWindow("Bob", 400, 100);    // Second client positioned at (400, 100)
        createChatWindow("Charlie", 700, 100); // Third client positioned at (700, 100)
        
        System.out.println("Chat application started with 3 clients.");
        System.out.println("All clients can now send messages to each other through the mediator.");
    }

    /**
     * Creates a chat window with the specified username and position.
     * 
     * @param username The name of the user for this chat window
     * @param x The x-coordinate position for this window
     * @param y The y-coordinate position for this window
     * @throws IOException If the FXML file cannot be loaded
     */
    private void createChatWindow(String username, double x, double y) throws IOException {
        // Load the FXML file that defines the UI for the chat window
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("chat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500); // Create scene with width 400 and height 500
        
        // Get the UI controller that was defined in the FXML file
        ChatWindowController uiController = fxmlLoader.getController();
        
        // Create the business logic controller (chat client) with the user's name and reference to the mediator
        ChatClientController chatClient = new ChatClientController(username, mediator);
        
        // Connect the UI controller with the business logic controller
        // This allows the UI to delegate actions to the chat client
        uiController.setChatClient(chatClient);
        
        // Create and configure the window (stage)
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username); // Set the window title to include the username
        stage.setScene(scene);
        stage.setX(x);   // Position the window at the specified x-coordinate
        stage.setY(y);   // Position the window at the specified y-coordinate
        stage.setResizable(false); // Prevent window resizing
        
        // Handle window closing event to properly disconnect the client
        stage.setOnCloseRequest(event -> {
            chatClient.disconnect(); // Notify the chat client to disconnect from the mediator
            System.out.println(username + " disconnected from chat.");
        });
        
        // Display the window
        stage.show();
    }

    /**
     * Main entry point for the application.
     * Launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch();
    }
}