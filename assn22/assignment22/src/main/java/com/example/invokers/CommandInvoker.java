package com.example.invokers;

import com.example.commands.Command;
import java.util.Stack;

/**
 * CommandInvoker manages the execution of commands and maintains
 * command history for undo/redo functionality.
 */
public class CommandInvoker {
    // Stack to store executed commands for undo operations
    private Stack<Command> commandHistory = new Stack<>();
    // Stack to store undone commands for redo operations
    private Stack<Command> undoneCommands = new Stack<>();

    /**
     * Executes a command, adds it to history, and clears redo stack.
     * 
     * @param command the command to execute
     */
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        // Clear redo stack as new command invalidates undone commands
        undoneCommands.clear();
    }
}
