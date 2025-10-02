package com.example.commands;

import com.example.receivers.PixelGrid;

/**
 * Command to move the cursor right on the pixel grid.
 * Implements the Command pattern for cursor movement operations.
 */
public class MoveCursorRightCommand implements Command {
    // The pixel grid on which the cursor will be moved
    private PixelGrid pg;

    /**
     * Constructor for MoveCursorRightCommand.
     * @param pg The PixelGrid instance to operate on
     */
    public MoveCursorRightCommand(PixelGrid pg) {
        this.pg = pg;
    }

    /**
     * Executes the command to move the cursor one position to the right.
     * Gets the current Y position and increments it by 1.
     */
    @Override
    public void execute() {
        // Get current vertical position
        int vl = pg.getCursorY();
        // Move cursor one position to the right (increment Y)
        pg.setCursorY(vl + 1);
    }

}
