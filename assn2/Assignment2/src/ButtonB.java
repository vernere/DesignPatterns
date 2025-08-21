/**
 * ButtonB is a concrete implementation of the Button class.
 * It displays a button with double-line borders using asterisks and equal signs,
 * formatting the text inside with surrounding spaces.
 * If no text is provided, it defaults to "Button B".
 */
public class ButtonB extends Button {
    @Override
    public void display() {
        String text = getTextField();
        if (text == null || text.isEmpty()) {
            text = "Button B";
        }
        
        int length = text.length();
        
        // Draw top border
        System.out.println("*" + "=".repeat(length + 2) + "*");
        
        // Draw middle part with text
        System.out.println("| " + text + " |");
        
        // Draw bottom border
        System.out.println("*" + "=".repeat(length + 2) + "*");
    }
}
