/**
 * Represents a character in a game, managing state, stats, and character information.
 * Implements the State pattern to handle different character states.
 */
public class GameCharacter {

    // Character attributes
    public String name;          // The name of the character
    public int level = 1;        // Current level of the character, starting at 1
    public int experience = 0;   // Experience points accumulated by the character
    public int health = 0;       // Current health points of the character
    private State state;         // Current state of the character (using State pattern)

    /**
     * Creates a new game character with the given name.
     * Initial state is set to NoviceState.
     * 
     * @param name The name of the character
     */
    public GameCharacter(String name) {
        this.name = name;
        this.state = new NoviceState();
    }

    /**
     * Changes the current state of the character.
     * 
     * @param state The new state to set
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets the current state of the character.
     * 
     * @return The current state
     */
    public State getState() {
        return this.state;
    }

    /**
     * Displays the character's information to the console,
     * including name, level, experience, and health.
     */
    public void displayInfo() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("Level: %d\n", level);
        System.out.printf("Experience: %d\n", experience);
        System.out.printf("Health: %d\n", health);
    }
}
