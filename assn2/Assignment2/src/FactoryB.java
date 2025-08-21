/**
 * Factory class for creating UI components with style B.
 * Extends the abstract UiFactory class.
 */
public class FactoryB extends UiFactory {

    /**
     * Creates a Button with style B.
     * 
     * @param text The text to display on the button
     * @return A Button instance of type B with the specified text
     */
    @Override
    public Button createButton(String text) {
        ButtonB button = new ButtonB();
        button.setTextField(text);
        return button;
    }

    /**
     * Creates a TextField with style B.
     * 
     * @param text The initial text for the text field
     * @return A TextField instance of type B with the specified text
     */
    @Override
    public TextField creaTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.setTextField(text);
        return textField;
    }

    /**
     * Creates a CheckBox with style B.
     * 
     * @param text The text to display next to the checkbox
     * @return A CheckBox instance of type B with the specified text
     */
    @Override
    public CheckBox createCheckbox(String text) {
        CheckboxB checkbox = new CheckboxB();
        checkbox.setTextField(text);
        return checkbox;
    }
}
