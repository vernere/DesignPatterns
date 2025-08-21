import java.util.Scanner;

/**
 * Main application class demonstrating the Abstract Factory design pattern
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Initial greeting
        System.out.println("Hello, World!");
        System.out.println("Syle 1 or 2 (1/2) ?");

        // Get user input for UI style choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Text to display in UI components
        String text = "Hello World!";

        // Style 1 implementation
        if (choice == 1) {
            // Create factory for style 1
            UiFactory factoryA = new FactoryA();
            // Create UI components using factory A
            TextField textfield = factoryA.creaTextField(text);
            Button button = factoryA.createButton(text);
            CheckBox checkbox = factoryA.createCheckbox(text);

            // Display initial state of components
            textfield.display();
            button.display();
            checkbox.display();

            // Modify the text in each component
            textfield.setTextField("Hello");
            button.setTextField("World");
            checkbox.setTextField("!");

            // Display updated state of components
            textfield.display();
            button.display();
            checkbox.display();

        } else {
            // Create factory for style 2
            UiFactory factoryB = new FactoryB();
            // Create UI components using factory B
            TextField textfield = factoryB.creaTextField(text);
            Button button = factoryB.createButton(text);
            CheckBox checkbox = factoryB.createCheckbox(text);

            // Display initial state of components
            textfield.display();
            button.display();
            checkbox.display();

            // Modify the text in each component
            textfield.setTextField("Hello");
            button.setTextField("World");
            checkbox.setTextField("!");

            // Display updated state of components
            textfield.display();
            button.display();
            checkbox.display();
        }

        // Close scanner to prevent resource leak
        scanner.close();
    }
}
