/**
 * TextFieldB is a concrete implementation of the TextField class
 * that displays text with a decorative border.
 */
public class TextFieldB extends TextField {
    /**
     * Displays the text field with a custom border format.
     * If the text field is empty, displays a default value.
     */
    @Override
    public void display() {
        // Get the text from parent class
        String text = getTextField();

        // Use default text if none is provided
        if (text == null || text.isEmpty()) {
            text = "Text Field B";
        }

        // Calculate the length for border formatting
        int length = text.length();

        // Draw top border with asterisks and equal signs
        System.out.println("*" + "=".repeat(length + 2) + "*");

        // Draw middle part with text surrounded by borders
        System.out.println("| " + text + " |");

        // Draw bottom border matching the top
        System.out.println("*" + "=".repeat(length + 2) + "*");
    }
}
