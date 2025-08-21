/**
 * CheckboxB class extends the CheckBox base class.
 * Implements a specialized display method for Checkbox B style.
 */
public class CheckboxB extends CheckBox {
    /**
     * Displays the checkbox with a bordered box style.
     * Uses equal signs for horizontal borders and asterisks for corners.
     */
    @Override
    public void display() {
        // Get the text to display, use default if none provided
        String text = getTextField();
        if (text == null || text.isEmpty()) {
            text = "Checkbox B";
        }
        
        // Calculate length for proper border sizing
        int length = text.length();
        
        // Draw top border with asterisks at corners and equal signs between
        System.out.println("*" + "=".repeat(length + 2) + "*");
        
        // Draw middle part with text surrounded by vertical borders
        System.out.println("| " + text + " |");
        
        // Draw bottom border matching the top border
        System.out.println("*" + "=".repeat(length + 2) + "*");
    }
}
