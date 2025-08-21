/**
 * FactoryA is a concrete factory implementation of UiFactory
 * that creates UI components with style A.
 */
public class FactoryA extends UiFactory {
    /**
     * Creates a button with style A.
     * @param text The text to display on the button
     * @return A ButtonA instance with the specified text
     */
    @Override
    public Button createButton(String text) {
        ButtonA button = new ButtonA();
        button.setTextField(text);
        return button;
    }

    /**
     * Creates a text field with style A.
     * @param text The initial text for the text field
     * @return A TextFieldA instance with the specified text
     */
    @Override
    public TextField creaTextField(String text) {
        TextFieldA textField = new TextFieldA();
        textField.setTextField(text);
        return textField;
    }

    /**
     * Creates a checkbox with style A.
     * @param text The label text for the checkbox
     * @return A CheckboxA instance with the specified text
     */
    @Override
    public CheckBox createCheckbox(String text) {
        CheckboxA checkbox = new CheckboxA();
        checkbox.setTextField(text);
        return checkbox;
    }
}
