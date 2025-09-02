/**
 * The main application class for the game.
 * <p>
 * This class contains the entry point to the application and initializes a Rock Paper Scissors game.
 * The game is played for a single round when the application is run.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class App {
    public static void main(String[] args) throws Exception {
        Game game = new RockPaper();
        game.play(1);
    }

}
