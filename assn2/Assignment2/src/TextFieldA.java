/**
 * TextFieldA class extends the TextField class to provide a specific display implementation.
 * This class renders a text field with a border made of '+' and '-' characters.
 */
public class TextFieldA extends TextField {
    /**
     * Displays the text field with a decorative border.
     * If the text is null or empty, a default value "TextField A" is used.
     */
    @Override
    public void display() {
        // Get the text content or use a default value
        String text = getTextField();
        if (text == null || text.isEmpty()) {
            text = "TextField A";
        }
        
        // Calculate the length for proper border sizing
        int length = text.length();
        
        // Draw top border with '+' at corners and '-' characters in between
        System.out.println("+" + "-".repeat(length + 2) + "+");
        
        // Draw middle part with text surrounded by '|' characters and spaces
        System.out.println("| " + text + " |");
        
        // Draw bottom border matching the top border
        System.out.println("+" + "-".repeat(length + 2) + "+");
    }
}
