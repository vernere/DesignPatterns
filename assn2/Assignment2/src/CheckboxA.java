/**
 * CheckboxA class extends the CheckBox base class.
 * This implementation displays a checkbox with a rectangular border around the text.
 */
public class CheckboxA extends CheckBox {
    
    /**
     * Displays the checkbox with a rectangular border.
     * If no text is provided, defaults to "Checkbox A".
     */
    @Override
    public void display() {
        // Get the text to display, or use default if none provided
        String text = getTextField();
        if (text == null || text.isEmpty()) {
            text = "Checkbox A";
        }
        
        // Calculate border length based on text length
        int length = text.length();
        
        // Draw top border with "+" corners and "-" for the horizontal line
        System.out.println("+" + "-".repeat(length + 2) + "+");
        
        // Draw middle part with text surrounded by "| " and " |"
        System.out.println("| " + text + " |");
        
        // Draw bottom border matching the top border
        System.out.println("+" + "-".repeat(length + 2) + "+");
    }
}
