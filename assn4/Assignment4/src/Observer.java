/**
 * The Observer interface defines a contract for objects that need to be
 * notified
 * of changes in the observed subject.
 * 
 * This interface is part of the Observer design pattern, where Observer objects
 * register with a Subject to receive updates when the Subject's state changes.
 * 
 * @param temp The temperature value that has changed and is being reported to
 *             the observer
 */
public interface Observer {
    public void update(Double temp);
}
