/**
 * ButtonA class extends the Button class and provides a specific display implementation.
 * This button displays text surrounded by a rectangular border made of ASCII characters.
 */
public class ButtonA extends Button {
    /**
     * Displays the button with a rectangular border.
     * If no text is set, displays "Button A" as default text.
     */
    @Override
    public void display() {
        // Get text from parent class or use default
        String text = getTextField();
        if (text == null || text.isEmpty()) {
            text = "Button A";
        }

        // Calculate length for creating the border
        int length = text.length();

        // Draw top border with plus signs at corners and dashes in between
        System.out.println("+" + "-".repeat(length + 2) + "+");

        // Draw middle part with text surrounded by vertical bars and spaces
        System.out.println("| " + text + " |");

        // Draw bottom border matching the top border
        System.out.println("+" + "-".repeat(length + 2) + "+");
    }
}
