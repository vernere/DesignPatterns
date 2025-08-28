import java.util.Scanner;

/**
 * Main application class that runs a character state simulation game
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create a new game character named "Joe"
        GameCharacter character = new GameCharacter("Joe");
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            // Display character information
            character.displayInfo();
            // Show available actions based on current state
            character.getState().displayAvailableActions();

            System.out.println("Choose action :");

            // Get user's choice
            int choice = scanner.nextInt();

            // Process user's choice
            if (choice == 1) {
                character.getState().train(character);
            }
            if (choice == 2) {
                character.getState().meditate(character);
            }
            if (choice == 3) {
                character.getState().fight(character);
            } else {
                System.out.println("Not availabe action");
            }

            // Check if character has reached master state (90 experience)
            if (character.experience == 90) {
                System.out.println("Congratulations, you've reached the master state!");
                break; // Exit the game loop
            }
        }
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
