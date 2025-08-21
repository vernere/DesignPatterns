/**
 * UiFactory is an abstract factory that defines methods for creating UI
 * components.
 * This class follows the Abstract Factory design pattern to create families of
 * related UI elements.
 */
public abstract class UiFactory {
    /**
     * Creates a button with the specified text.
     * 
     * @param text The text to display on the button
     * @return A Button instance
     */
    public abstract Button createButton(String text);

    /**
     * Creates a text field with the specified text.
     * 
     * @param text The initial text for the text field
     * @return A TextField instance
     */
    public abstract TextField creaTextField(String text);

    /**
     * Creates a checkbox with the specified text.
     * 
     * @param text The text to display alongside the checkbox
     * @return A CheckBox instance
     */
    public abstract CheckBox createCheckbox(String text);

}
