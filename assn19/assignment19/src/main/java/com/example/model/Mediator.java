package com.example.model;

import java.util.List;

/**
 * The Mediator interface defines a communication mechanism between chat clients.
 * It follows the Mediator design pattern, which reduces coupling between communicating objects.
 */
public interface Mediator {
    /**
     * Registers a new chat client with the mediator.
     * @param cc The chat client to register
     */
    public void registerClient(ChatClient cc);
    
    /**
     * Sends a message to the appropriate recipient(s).
     * @param msg The message to be sent
     */
    public void sendMessage(Message msg);
    
    /**
     * Broadcasts a message to all registered clients.
     */
    public void broadcast();
    
    /**
     * Removes a client from the mediator.
     * @param client The chat client to unregister
     */
    public void unregisterClient(ChatClient client);
    
    /**
     * Gets a list of all currently available chat clients.
     * @return List of available chat clients
     */
    public List<ChatClient> getAvailableClients();
}
