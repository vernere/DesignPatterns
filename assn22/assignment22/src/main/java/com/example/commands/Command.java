package com.example.commands;

/**
 * Command interface that defines the contract for all command objects in the Command pattern.
 * <p>
 * This interface represents an encapsulation of a request as an object, allowing for
 * parameterization of clients with different requests, queuing of requests, and logging
 * of the requests. It also supports undoable operations.
 * </p>
 * <p>
 * Classes implementing this interface should encapsulate all the information needed
 * to perform an action or trigger an event at a later time, including the method name,
 * the object that owns the method, and values for the method parameters.
 * </p>
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Command_pattern">Command Pattern</a>
 */
public interface Command {
    public void execute();
}
