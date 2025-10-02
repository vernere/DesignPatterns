package com.example.receivers;

/**
 * Listener interface for receiving drawing canvas events.
 * Implementations of this interface can be registered to receive
 * notifications about pixel changes and cursor movements.
 */
public interface Listener {
    /**
     * Called when a pixel is changed on the canvas.
     * 
     * @param x the x-coordinate of the changed pixel
     * @param y the y-coordinate of the changed pixel
     */
    void onPixelChanged(int x, int y);
    
    /**
     * Called when the cursor is moved on the canvas.
     * 
     * @param x the x-coordinate of the cursor
     * @param y the y-coordinate of the cursor
     */
    void onCursorMoved(int x, int y);
}
