import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.println("Game Map Demonstration");
        System.out.println("Wilderness or City map?(1/2)");

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        // Validate user input
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please enter 1 for Wilderness or 2 for City:");
            choice = scanner.nextInt();
        }

        // Pass the choice to createMap
        game.createMap(choice);

        // Close scanner to prevent resource leak
        scanner.close();

    }

}