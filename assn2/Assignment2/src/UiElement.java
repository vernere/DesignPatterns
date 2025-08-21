/**
 * Abstract base class for UI elements.
 * Provides common functionality for UI components that can display text.
 */
public abstract class UiElement {
    /** The text content of this UI element */
    private String text;

    /**
     * Gets the text field value of this UI element.
     * 
     * @return The current text content
     */
    public String getTextField() {
        return text;
    }

    /**
     * Sets the text field value of this UI element.
     * 
     * @param textField The new text content to display
     */
    public void setTextField(String textField) {
        this.text = textField;
    }
}
