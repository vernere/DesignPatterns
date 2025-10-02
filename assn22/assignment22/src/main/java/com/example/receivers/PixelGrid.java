package com.example.receivers;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an 8x8 pixel grid with cursor functionality.
 * Provides methods to manipulate pixels and track cursor position.
 * Implements a listener pattern to notify observers of grid changes.
 */
public class PixelGrid {
    /** 8x8 grid representing pixel state (true = on, false = off) */
    private boolean[][] pixelArt = new boolean[8][8];
    
    /** Current X coordinate of the cursor (0-7) */
    private int cursorX = 0;
    
    /** Current Y coordinate of the cursor (0-7) */
    private int cursorY = 0;
    
    /** List of listeners observing grid changes */
    private List<Listener> listeners = new ArrayList<>();
    
    /**
     * Gets the current X position of the cursor.
     * @return Current cursor X position
     */
    public int getCursorX() {
        return cursorX;
    }
    
    /**
     * Gets the current Y position of the cursor.
     * @return Current cursor Y position
     */
    public int getCursorY() {
        return cursorY;
    }
    
    /**
     * Sets the cursor X position.
     * The value is clamped to the valid range [0, 7].
     * Notifies listeners if the cursor position changes.
     * @param x The new X position (will be clamped to valid range)
     */
    public void setCursorX(int x) {
        int oldX = this.cursorX;
        int oldY = this.cursorY;
        // Clamp X to valid range [0, pixelArt.length - 1]
        this.cursorX = Math.max(0, Math.min(pixelArt.length - 1, x));
        // Notify listeners if position changed
        if (oldX != this.cursorX || oldY != this.cursorY) {
            notifyListenersCursorMoved(this.cursorX, this.cursorY);
        }
    }
    
    /**
     * Sets the cursor Y position.
     * The value is clamped to the valid range [0, 7].
     * Notifies listeners if the cursor position changes.
     * @param y The new Y position (will be clamped to valid range)
     */
    public void setCursorY(int y) {
        int oldX = this.cursorX;
        int oldY = this.cursorY;
        // Clamp Y to valid range [0, pixelArt[0].length - 1]
        this.cursorY = Math.max(0, Math.min(pixelArt[0].length - 1, y));
        // Notify listeners if position changed
        if (oldX != this.cursorX || oldY != this.cursorY) {
            notifyListenersCursorMoved(this.cursorX, this.cursorY);
        }
    }
    
    /**
     * Moves the cursor to the specified position.
     * Both coordinates will be clamped to valid ranges.
     * @param x The X position
     * @param y The Y position
     */
    public void moveCursor(int x, int y) {
        setCursorX(x);
        setCursorY(y);
    }

    /**
     * Gets the current pixel grid state.
     * @return 8x8 boolean array representing the pixel art
     */
    public boolean[][] getPixels(){
        return pixelArt;
    }

    /**
     * Sets the entire pixel grid to a new state.
     * @param newPixelArt The new pixel art array to set
     */
    public void setPixels(boolean[][] newPixelArt){
        pixelArt = newPixelArt;
    }

    /**
     * Toggles the pixel at the current cursor position.
     * Changes from on to off or off to on.
     * Notifies listeners of the pixel change.
     */
    public void togglePixel(){
        // Toggle the pixel at current cursor position
        pixelArt[getCursorX()][getCursorY()] = !pixelArt[getCursorX()][getCursorY()];
        // Notify listeners of the change
        notifyListenersPixelChanged(getCursorX(), getCursorY());
    }

    /**
     * Prints the pixel grid to console in array format.
     * Outputs as a Java array initialization string with 1s and 0s.
     * @return The current pixel art array
     */
    public boolean[][] print(){
        String code = generateCode();
        System.out.println(code);
        return pixelArt;
    }
    
    /**
     * Generates the Java code representation of the current pixel art.
     * Returns a properly formatted string that can be copied and pasted.
     * @return Java code as a string
     */
    public String generateCode() {
        StringBuilder code = new StringBuilder();
        code.append("int[][] pixelArt = {\n");
        
        // Iterate through rows
        for (int i = 0; i < pixelArt.length; i++) {
            code.append("    {");
            // Iterate through columns
            for (int j = 0; j < pixelArt[i].length; j++) {
                // Append 1 for true (on), 0 for false (off)
                code.append(pixelArt[i][j] ? 1 : 0);
                if (j < pixelArt[i].length - 1) {
                    code.append(", ");
                }
            }
            code.append("}");
            if (i < pixelArt.length - 1) {
                code.append(",");
            }
            code.append("\n");
        }
        code.append("};");
        return code.toString();
    }
    
    /**
     * Adds a listener for pixel grid changes.
     * The listener will be notified of pixel changes and cursor movements.
     * @param listener The listener to add
     */
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    
    /**
     * Removes a listener for pixel grid changes.
     * @param listener The listener to remove
     */
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    
    /**
     * Notifies all listeners that a pixel has changed.
     * Called when a pixel is toggled on or off.
     * @param x The x coordinate of the changed pixel
     * @param y The y coordinate of the changed pixel
     */
    private void notifyListenersPixelChanged(int x, int y) {
        for (Listener listener : listeners) {
            listener.onPixelChanged(x, y);
        }
    }
    
    /**
     * Notifies all listeners that the cursor has moved.
     * Called when cursor position changes.
     * @param x The new x coordinate of the cursor
     * @param y The new y coordinate of the cursor
     */
    private void notifyListenersCursorMoved(int x, int y) {
        for (Listener listener : listeners) {
            listener.onCursorMoved(x, y);
        }
    }
}
