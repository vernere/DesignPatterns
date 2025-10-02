package com.example.commands;

import com.example.receivers.PixelGrid;

/**
 * Command to move the cursor down by one position in the PixelGrid.
 */
public class MoveCursorDownCommand implements Command {
    private PixelGrid pg;

    /**
     * Constructs a MoveCursorDownCommand with the specified PixelGrid.
     * 
     * @param pg the PixelGrid to operate on
     */
    public MoveCursorDownCommand(PixelGrid pg) {
        this.pg = pg;
    }

    /**
     * Executes the command to move the cursor down by incrementing the X coordinate.
     */
    @Override
    public void execute() {
        // Get current cursor X position
        int vl = pg.getCursorX();
        // Move cursor down by incrementing X
        pg.setCursorX(vl + 1);
    }

}
