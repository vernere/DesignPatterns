package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatMediator implements the Mediator interface to control communication between ChatClient objects.
 * This class serves as the central hub that manages all client registrations and message passing.
 */
public class ChatMediator implements Mediator {
    // List to store all registered chat clients
    private List<ChatClient> clients;

    /**
     * Constructor initializes an empty list of clients.
     */
    public ChatMediator() {
        this.clients = new ArrayList<>();
    }

    /**
     * Registers a new client with the mediator.
     * If the client already exists, registration is denied.
     * @param client The ChatClient to register
     */
    @Override
    public void registerClient(ChatClient client) {
        if (clients.contains(client)) {
            System.out.println("Client already exists: " + client.getUsername());
        } else {
            clients.add(client);
            System.out.println("Client registered: " + client.getUsername());
            // Notify all clients of the updated client list
            notifyClientsOfUpdate();
        }
    }

    /**
     * Helper method to notify all clients when the client list changes.
     * Creates a defensive copy of the clients list to avoid modification during iteration.
     */
    private void notifyClientsOfUpdate() {
        for (ChatClient client : clients) {
            client.notifyClientListUpdated(new ArrayList<>(clients));
        }
    }

    /**
     * Delivers a message from a sender to a receiver.
     * Performs validation checks before delivering the message.
     * @param message The Message object containing sender, receiver, and content information
     */
    @Override
    public void sendMessage(Message message) {
        // Validate sender
        if (!clients.contains(message.sender)) {
            System.out.println("Message sender not registered: " + message.sender.getUsername());
            return;
        }
        
        // Validate receiver
        if (!clients.contains(message.receiver)) {
            System.out.println("Message receiver not registered: " + message.receiver.getUsername());
            return;
        }
        
        // Check for self-messaging
        if (message.sender.equals(message.receiver)) {
            System.out.println("Cannot send message to yourself");
            return;
        }
        
        // Check if receiver is active
        if (!message.receiver.isActive()) {
            System.out.println("Receiver is not active: " + message.receiver.getUsername());
            return;
        }
        
        // Deliver the message
        try {
            message.receiver.receiveMessage(message);
            System.out.println("Message delivered from " + message.sender.getUsername() + 
                             " to " + message.receiver.getUsername());
        } catch (Exception e) {
            System.err.println("Failed to deliver message: " + e.getMessage());
        }
    }

    /**
     * Broadcasts an update to all registered clients.
     */
    @Override
    public void broadcast() {
        notifyClientsOfUpdate();
    }

    /**
     * Removes a client from the mediator's client list.
     * @param client The ChatClient to unregister
     */
    @Override
    public void unregisterClient(ChatClient client) {
        if (!clients.contains(client)) {
            System.out.println("Client does not exist: " + client.getUsername());
        } else {
            clients.remove(client);
            System.out.println("Client unregistered: " + client.getUsername());
            // Notify remaining clients of the updated client list
            notifyClientsOfUpdate();
        }
    }

    /**
     * Returns a defensive copy of the current client list.
     * @return A new ArrayList containing all registered clients
     */
    @Override
    public List<ChatClient> getAvailableClients() {
        return new ArrayList<>(clients);
    }
}
