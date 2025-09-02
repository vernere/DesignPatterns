import java.util.Scanner;

/**
 * Implementation of Rock Paper Scissors game using the Template Method Pattern.
 * Extends the abstract Game class to implement specific game logic.
 */
public class RockPaper extends Game {
    public int numberOfPlayers;  // Number of players in the game
    public int score;            // Player's score
    public int choice;           // Player's choice (1=Rock, 2=Paper, 3=Scissors)
    public int aiScore;          // AI's score
    public Scanner scanner;      // Scanner for reading user input

    /**
     * Initializes the game with player count and resets scores.
     * @param numberOfPlayers The number of players for this game
     */
    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.score = 0;
        this.aiScore = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Determines if the game has reached its end condition.
     * Game ends when either player or AI reaches 3 points.
     * @return true if game is over, false otherwise
     */
    @Override
    public boolean endOfGame() {
        if (score == 3 || aiScore == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Handles a single turn of gameplay including player choice,
     * AI choice, determining the winner, and updating scores.
     * @param player The current player's index
     */
    @Override
    public void playSingleTurn(int player) {
        choice = 0;
        System.out.println("Choose (1.Rock, 2.Paper, 3.Sciccors) : ");
        choice = scanner.nextInt();
        
        // Generate random choice for AI (1-3)
        int choice2 = (int) (Math.random() * 3) + 1;
        System.out.println("AI chose: " + (choice2 == 1 ? "Rock" : choice2 == 2 ? "Paper" : "Scissors"));

        // Determine winner of this round
        // Rock beats Scissors, Paper beats Rock, Scissors beats Paper
        if (choice == choice2) {
            System.out.println("It's a tie!");
        } else if ((choice == 1 && choice2 == 3) ||
                (choice == 2 && choice2 == 1) ||
                (choice == 3 && choice2 == 2)) {
            System.out.println("You win this round!");
            score++;
        } else {
            System.out.println("AI wins this round!");
            aiScore++;
        }

        // Display current score
        System.out.println("Score - You: " + score + ", AI: " + aiScore + "\n");
    }

    /**
     * Displays the final winner of the game and cleans up resources.
     * Called after the game has ended.
     */
    @Override
    public void displayWinner() {
        if (score > aiScore) {
            System.out.println("Congratulations you have won!");
            System.out.print("Player score : " + score + " Ai score : " + aiScore);
        } else {
            System.out.println("Oh no you have lost.");
            System.out.print("Player score : " + score + " Ai score : " + aiScore);
        }
        scanner.close();  // Close the scanner to prevent resource leaks
    }
}
