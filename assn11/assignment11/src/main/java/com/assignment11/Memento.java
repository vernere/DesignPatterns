package com.assignment11;

import java.util.Date;

import javafx.scene.paint.Color;

/**
 * Memento class that stores the state of an object.
 * Part of the Memento design pattern implementation.
 * Used to capture and externalize an object's internal state.
 */
public class Memento implements IMemento {
    /** Timestamp when this memento was created */
    public Date timeStamp;
    /** Description of the state */
    public String stateDesc;

    /** Color of the first rectangle */
    public Color rec1color;
    /** Color of the second rectangle */
    public Color rec2color;
    /** Color of the third rectangle */
    public Color rec3color;

    /** Status of the checkbox */
    public boolean checkboxStatus;

    /**
     * Constructor to create a memento with the specified state.
     * 
     * @param stateDesc Description of the state
     * @param rec1color Color of the first rectangle
     * @param rec2color Color of the second rectangle
     * @param rec3color Color of the third rectangle
     * @param checkboxStatus Status of the checkbox
     */
    public Memento(String stateDesc, Color rec1color, Color rec2color, Color rec3color, boolean checkboxStatus) {
        this.timeStamp = new Date();
        this.stateDesc = stateDesc;
        this.rec1color = rec1color;
        this.rec2color = rec2color;
        this.rec3color = rec3color;
        this.checkboxStatus = checkboxStatus;
    }

    /**
     * Returns the timestamp of when this memento was created.
     * 
     * @return The timestamp
     */
    @Override
    public Date getTime() {
        return timeStamp;
    }

    /**
     * Returns the description of the state.
     * 
     * @return The state description
     */
    @Override
    public String getDesc() {
        return stateDesc;
    }
}
