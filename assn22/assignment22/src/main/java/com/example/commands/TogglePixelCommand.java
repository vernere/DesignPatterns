package com.example.commands;

import com.example.receivers.PixelGrid;

/**
 * Command to toggle a pixel in the pixel grid.
 * Implements the Command pattern.
 */
public class TogglePixelCommand implements Command {
    private PixelGrid pg;

    /**
     * Constructor for TogglePixelCommand.
     * @param pg the PixelGrid receiver
     */
    public TogglePixelCommand(PixelGrid pg) {
        this.pg = pg;
    }

    /**
     * Executes the command by toggling a pixel in the grid.
     */
    @Override
    public void execute() {
        pg.togglePixel();
    }

}
