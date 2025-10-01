package com.example.controller;

import java.util.List;
import java.util.UUID;

import com.example.model.ChatClient;
import com.example.model.Mediator;
import com.example.model.Message;

/**
 * ChatClientController implements the ChatClient interface and serves as the business logic
 * layer for a chat client. It communicates with the mediator and integrates with the UI controller.
 * This controller acts as an intermediary between the UI and the chat mediator system.
 */
public class ChatClientController implements ChatClient {
    // Client identification information
    private String username;        // User's display name
    private String clientId;        // Unique identifier for this client
    private Mediator mediator;      // Reference to the mediator for client communication
    private ChatWindowController uiController; // Reference to UI controller for display updates
    private boolean active;         // Flag indicating if this client is currently active

    /**
     * Creates a new chat client controller with the specified username and mediator.
     * Automatically registers this client with the mediator upon creation.
     *
     * @param username The display name for this chat client
     * @param mediator The mediator through which messages will be sent/received
     */
    public ChatClientController(String username, Mediator mediator){
        this.username = username;
        this.clientId = UUID.randomUUID().toString();  // Generate a unique client ID
        this.mediator = mediator;
        this.active = true;  // Client is active by default
        this.mediator.registerClient(this);  // Register with the mediator
    }

    /**
     * Sends a message to another client through the mediator.
     * Validates client state and message content before sending.
     *
     * @param content The text content of the message
     * @param receiver The target client to receive the message
     * @throws IllegalStateException if client is not active
     * @throws IllegalArgumentException if content is empty or receiver is null
     */
    public void sendMessage(String content, ChatClient receiver){
        if (!active) {
            throw new IllegalStateException("Client is not active");
        }
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver cannot be null");
        }
        
        Message message = new Message(this, receiver, content);
        mediator.sendMessage(message);
    }

    /**
     * Receives a message from the mediator and forwards it to the UI controller.
     * Only processes messages if the client is active and UI controller is set.
     *
     * @param msg The message received from another client
     */
    @Override
    public void receiveMessage(Message msg) {
        if (uiController != null && active) {
            uiController.displayMessage(msg);
        }
    }

    /**
     * Returns the username of this chat client.
     *
     * @return The client's username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the unique identifier for this client.
     *
     * @return The client's unique ID
     */
    @Override
    public String getClientId() {
        return clientId;
    }

    /**
     * Checks if this client is currently active.
     *
     * @return true if client is active, false otherwise
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Called by the mediator when the client list is updated.
     * Forwards the update to the UI controller for display refresh.
     *
     * @param clients The updated list of available chat clients
     */
    @Override
    public void notifyClientListUpdated(List<ChatClient> clients) {
        if (uiController != null && active) {
            uiController.updateRecipientList(clients);
        }
    }

    /**
     * Sets the UI controller reference for integration between business logic and UI.
     * This creates the connection between the model and view components.
     *
     * @param uiController The UI controller to handle visual updates
     */
    public void setUIController(ChatWindowController uiController) {
        this.uiController = uiController;
    }

    /**
     * Requests an update of the client list from the mediator.
     * Used to refresh the available clients in the UI.
     */
    public void requestClientListUpdate() {
        if (mediator != null) {
            List<ChatClient> clients = mediator.getAvailableClients();
            notifyClientListUpdated(clients);
        }
    }

    /**
     * Deactivates this client and unregisters from the mediator.
     * Called when the user logs out or closes the application.
     */
    public void disconnect() {
        this.active = false;
        if (mediator != null) {
            mediator.unregisterClient(this);
        }
    }

    /**
     * Compares this client with another object for equality.
     * Clients are considered equal if they have the same clientId.
     *
     * @param obj The object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChatClientController that = (ChatClientController) obj;
        return clientId.equals(that.clientId);
    }

    /**
     * Returns a hash code value for this client.
     * Based on the client's unique ID for consistency with equals method.
     *
     * @return The hash code for this client
     */
    @Override
    public int hashCode() {
        return clientId.hashCode();
    }

    /**
     * Returns a string representation of this client.
     *
     * @return A string containing username and clientId
     */
    @Override
    public String toString() {
        return username + " (" + clientId + ")";
    }
}
