package com.example.commands;

import com.example.receivers.PixelGrid;

/**
 * Command to move the cursor up in the pixel grid.
 * Decrements the Y-coordinate of the cursor position.
 */
public class MoveCursorUpCommand implements Command {
    private PixelGrid pg;

    /**
     * Constructs a MoveCursorUpCommand with the specified PixelGrid.
     * 
     * @param pg the PixelGrid on which to operate
     */
    public MoveCursorUpCommand(PixelGrid pg) {
        this.pg = pg;
    }

    /**
     * Executes the command to move the cursor up by one position.
     * Decrements the cursor's Y-coordinate.
     */
    @Override
    public void execute() {
        int vl = pg.getCursorX();
        pg.setCursorX(vl - 1);
    }

}
