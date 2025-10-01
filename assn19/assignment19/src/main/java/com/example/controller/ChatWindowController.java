package com.example.controller;

import com.example.model.ChatClient;
import com.example.model.Message;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for the chat window FXML.
 * Handles UI events and integrates with ChatClientController.
 * This class manages the chat interface, including displaying messages,
 * managing recipient lists, and coordinating with the business logic layer.
 */
public class ChatWindowController implements Initializable {
    
    // UI components defined in FXML
    @FXML
    private Label usernameLabel;           // Displays the current user's name
    
    @FXML
    private TextArea messageDisplayArea;   // Area where chat messages appear
    
    @FXML
    private TextField messageInputField;   // Field where user types messages
    
    @FXML
    private ChoiceBox<ChatClientItem> recipientChoiceBox; // Dropdown to select message recipient
    
    @FXML
    private Button sendButton;             // Button to send messages
    
    @FXML
    private Label statusLabel;             // Displays connection status and notifications
    
    // Reference to the chat client controller (business logic)
    private ChatClientController chatClient;
    
    // Observable list for recipient choice box - automatically updates UI when modified
    private ObservableList<ChatClientItem> availableClients;
    
    // Date formatter for message timestamps - formats time as hours:minutes:seconds
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     * 
     * @param location The location used to resolve relative paths for resources
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the recipient choice box with an empty observable list
        availableClients = FXCollections.observableArrayList();
        recipientChoiceBox.setItems(availableClients);
        
        // Set up message input field to handle Enter key for quick sending
        messageInputField.setOnAction(event -> sendMessage());
        
        // Initially disable send functionality until client is connected
        sendButton.setDisable(true);
        messageInputField.setDisable(true);
        recipientChoiceBox.setDisable(true);
        
        // Initialize status with waiting message
        updateStatus("Waiting for connection...", false);
    }
    
    /**
     * Sets the chat client controller and enables the UI.
     * This creates the connection between UI and business logic.
     * Called after the ChatClientController has been initialized.
     * 
     * @param chatClient The business logic controller for chat operations
     */
    public void setChatClient(ChatClientController chatClient) {
        this.chatClient = chatClient;
        
        // Set this controller as the UI controller for the chat client
        chatClient.setUIController(this);
        
        // Update the username label with the current user's name
        usernameLabel.setText("Chat - " + chatClient.getUsername());
        
        // Enable UI components now that connection is established
        sendButton.setDisable(false);
        messageInputField.setDisable(false);
        recipientChoiceBox.setDisable(false);
        
        // Update status to show connection is active
        updateStatus("Connected", true);
        
        // Request initial client list update to populate recipients
        refreshClientList();
    }
    
    /**
     * Handles the send button click and Enter key press.
     * Validates inputs and delegates to business logic for sending.
     */
    @FXML
    private void sendMessage() {
        String messageContent = messageInputField.getText().trim();
        ChatClientItem selectedRecipient = recipientChoiceBox.getValue();
        
        // Validate input before attempting to send
        if (messageContent.isEmpty()) {
            showAlert("Error", "Please enter a message.");
            return;
        }
        
        if (selectedRecipient == null) {
            showAlert("Error", "Please select a recipient.");
            return;
        }
        
        if (chatClient == null) {
            showAlert("Error", "Chat client not connected.");
            return;
        }
        
        try {
            // Send message through the chat client (business logic)
            chatClient.sendMessage(messageContent, selectedRecipient.getChatClient());
            
            // Display the sent message in our own chat area for chat history
            displaySentMessage(messageContent, selectedRecipient.getDisplayName());
            
            // Clear the input field after successful send
            messageInputField.clear();
            
            // Update status to confirm message was sent
            updateStatus("Message sent", true);
            
        } catch (Exception e) {
            // Handle any errors that occur during sending
            showAlert("Error", "Failed to send message: " + e.getMessage());
            updateStatus("Send failed", false);
        }
    }
    
    /**
     * Displays a received message in the chat area.
     * This method is called by the ChatClientController when a message is received.
     * Uses Platform.runLater to ensure UI updates happen on JavaFX thread.
     * 
     * @param message The message object containing sender, content and timestamp
     */
    public void displayMessage(Message message) {
        Platform.runLater(() -> {
            String formattedMessage = String.format("[%s] %s: %s%n",
                timeFormatter.format(message.timestamp),
                message.sender.getUsername(),
                message.content);
            
            messageDisplayArea.appendText(formattedMessage);
            
            // Auto-scroll to bottom to show newest messages
            messageDisplayArea.setScrollTop(Double.MAX_VALUE);
            
            // Update status to notify about received message
            updateStatus("Message received", true);
        });
    }
    
    /**
     * Displays a sent message in the chat area.
     * Formats outgoing messages differently to distinguish them from incoming ones.
     * 
     * @param content The content of the message
     * @param recipientName The name of the message recipient
     */
    private void displaySentMessage(String content, String recipientName) {
        String formattedMessage = String.format("[%s] You to %s: %s%n",
            timeFormatter.format(new java.util.Date()),
            recipientName,
            content);
        
        messageDisplayArea.appendText(formattedMessage);
        
        // Auto-scroll to bottom to show newest messages
        messageDisplayArea.setScrollTop(Double.MAX_VALUE);
    }
    
    /**
     * Updates the list of available recipients.
     * This method is called when the client list changes.
     * Preserves current selection when possible.
     * 
     * @param clients List of chat clients currently available
     */
    public void updateRecipientList(List<ChatClient> clients) {
        Platform.runLater(() -> {
            // Remember the currently selected client to maintain selection if possible
            ChatClientItem currentSelection = recipientChoiceBox.getValue();
            
            // Clear and rebuild the list
            availableClients.clear();
            
            for (ChatClient client : clients) {
                // Don't include ourselves in the recipient list
                if (chatClient != null && !client.equals(chatClient)) {
                    availableClients.add(new ChatClientItem(client));
                }
            }
            
            // Try to restore the previous selection if it still exists
            if (currentSelection != null) {
                for (ChatClientItem item : availableClients) {
                    if (item.getChatClient().equals(currentSelection.getChatClient())) {
                        recipientChoiceBox.setValue(item);
                        break;
                    }
                }
            }
            
            // If no selection or previous selection no longer available, select first item
            if (recipientChoiceBox.getValue() == null && !availableClients.isEmpty()) {
                recipientChoiceBox.setValue(availableClients.get(0));
            }
        });
    }
    
    /**
     * Requests a refresh of the client list from the mediator.
     * Used to ensure UI has the most up-to-date list of chat participants.
     */
    private void refreshClientList() {
        if (chatClient != null) {
            chatClient.requestClientListUpdate();
        }
    }
    
    /**
     * Updates the status label with message and color.
     * 
     * @param message The status message to display
     * @param success If true, uses green color; if false, uses red
     */
    private void updateStatus(String message, boolean success) {
        Platform.runLater(() -> {
            statusLabel.setText(message);
            statusLabel.setStyle(success ? "-fx-text-fill: green;" : "-fx-text-fill: red;");
        });
    }
    
    /**
     * Shows an alert dialog for error messages.
     * 
     * @param title The title of the alert dialog
     * @param message The message to display in the alert
     */
    private void showAlert(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
    
    /**
     * Wrapper class for ChatClient to provide proper display in ChoiceBox.
     * Encapsulates a ChatClient object and provides display formatting and equality.
     */
    private static class ChatClientItem {
        private final ChatClient chatClient;
        
        /**
         * Creates a new ChatClientItem wrapper
         * 
         * @param chatClient The chat client to wrap
         */
        public ChatClientItem(ChatClient chatClient) {
            this.chatClient = chatClient;
        }
        
        /**
         * @return The wrapped chat client
         */
        public ChatClient getChatClient() {
            return chatClient;
        }
        
        /**
         * @return The display name for the chat client
         */
        public String getDisplayName() {
            return chatClient.getUsername();
        }
        
        /**
         * Returns the string representation for display in UI components
         * 
         * @return The username as the display string
         */
        @Override
        public String toString() {
            return getDisplayName();
        }
        
        /**
         * Checks equality based on the wrapped chat client
         * 
         * @param obj The object to compare with
         * @return True if both objects wrap the same chat client
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ChatClientItem that = (ChatClientItem) obj;
            return chatClient.equals(that.chatClient);
        }
        
        /**
         * Provides hash code based on wrapped chat client
         * 
         * @return The hash code from the wrapped chat client
         */
        @Override
        public int hashCode() {
            return chatClient.hashCode();
        }
    }
}