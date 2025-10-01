package com.example.model;

import java.util.Date;

/**
 * Represents a message sent between chat clients in a chat application.
 * Contains information about the sender, receiver, content, and when the message was created.
 */
public class Message {
    /** The client who sent the message */
    public ChatClient sender;
    /** The client who will receive the message */
    public ChatClient receiver;
    /** The text content of the message */
    public String content;
    /** The time when the message was created */
    public Date timestamp;

    /**
     * Creates a new message with the specified sender, receiver, and content.
     * The timestamp is automatically set to the current time.
     * 
     * @param sender The client sending the message
     * @param receiver The client receiving the message
     * @param content The text content of the message
     */
    public Message(ChatClient sender, ChatClient receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = new Date();
    }
}
