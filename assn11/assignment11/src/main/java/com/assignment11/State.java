package com.assignment11;

import javafx.scene.paint.Color;

/**
 * State class that holds the current state of the application.
 * This class implements the Memento pattern by allowing states to be saved and restored.
 */
public class State {
    // Colors for the three rectangles
    public Color rec1color;
    public Color rec2color;
    public Color rec3color;

    // Status of the checkbox
    public boolean checkboxStatus;

    /**
     * Gets the color of rectangle 1
     * @return Color of rectangle 1
     */
    public Color getRec1color() {
        return rec1color;
    }

    /**
     * Sets the color of rectangle 1
     * @param rec1color The new color for rectangle 1
     */
    public void setRec1color(Color rec1color) {
        this.rec1color = rec1color;
    }

    /**
     * Gets the color of rectangle 2
     * @return Color of rectangle 2
     */
    public Color getRec2color() {
        return rec2color;
    }

    /**
     * Sets the color of rectangle 2
     * @param rec2color The new color for rectangle 2
     */
    public void setRec2color(Color rec2color) {
        this.rec2color = rec2color;
    }

    /**
     * Gets the color of rectangle 3
     * @return Color of rectangle 3
     */
    public Color getRec3color() {
        return rec3color;
    }

    /**
     * Sets the color of rectangle 3
     * @param rec3color The new color for rectangle 3
     */
    public void setRec3color(Color rec3color) {
        this.rec3color = rec3color;
    }

    /**
     * Gets the status of the checkbox
     * @return true if checkbox is selected, false otherwise
     */
    public boolean isCheckboxStatus() {
        return checkboxStatus;
    }

    /**
     * Sets the status of the checkbox
     * @param checkboxStatus The new status for the checkbox
     */
    public void setCheckboxStatus(boolean checkboxStatus) {
        this.checkboxStatus = checkboxStatus;
    }

    /**
     * Creates a memento object to save the current state
     * @param desc Description of the state being saved
     * @return A new Memento object containing the current state
     */
    public Memento createMemento(String desc){
        return new Memento(desc, rec1color, rec2color, rec3color, checkboxStatus);
    }

    /**
     * Restores the state from a saved memento
     * @param memento The memento object containing the state to restore
     */
    public void restoreMementoState(Memento memento){
        rec1color = memento.rec1color;
        rec2color = memento.rec2color;
        rec3color = memento.rec3color;
        checkboxStatus = memento.checkboxStatus;
    }
}
