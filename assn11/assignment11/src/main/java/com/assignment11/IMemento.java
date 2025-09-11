package com.assignment11;

import java.util.Date;

/**
 * The IMemento interface represents a memento in the Memento design pattern.
 * A memento holds state information of an object at a particular point in time,
 * allowing the object to be restored to that state later.
 * 
 * This interface provides methods to access timestamp information and 
 * a description of the state that has been captured.
 * 
 * @author Student
 * @version 1.0
 * @since 1.0
 */
public interface IMemento {
    public Date timeStamp = new Date();
    public String stateDesc = "";

    public Date getTime();
    public String getDesc();
}
