package com.example.commands;

import com.example.receivers.PixelGrid;

/**
 * Command to move the cursor left on the pixel grid.
 */
public class MoveCursorLeftCommand implements Command {
    private PixelGrid pg;

    /**
     * Constructs a MoveCursorLeftCommand with the specified PixelGrid.
     * 
     * @param pg the PixelGrid on which to move the cursor
     */
    public MoveCursorLeftCommand(PixelGrid pg) {
        this.pg = pg;
    }

    /**
     * Executes the command to move the cursor left by decrementing the Y coordinate.
     */
    @Override
    public void execute() {
        // Get current Y position
        int vl = pg.getCursorY();
        // Move cursor left by decrementing Y
        pg.setCursorY(vl - 1);
    }

}
