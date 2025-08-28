/**
 * Represents the intermediate level state of a character in the game.
 * This state allows training and meditation but not fighting.
 */
public class IntermediateState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train for an hour.");
        // Increase experience by 10 points when training
        character.experience += 10;
        // Check if character has reached enough experience to advance to expert level
        if (character.experience == 40) {
            character.level = 3;
            character.setState(new ExpertState());
        } else {
            return;
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditate for an hour.");
        // Increase health by 10 points when meditating
        character.health += 10;
    }

    @Override
    public void fight(GameCharacter character) {
        // Character in intermediate state cannot fight yet
        System.out.println("Too low level to fight");
    }

    @Override
    public void displayAvailableActions() {
        // Only training and meditation are available in this state
        System.out.println("Actions : 1. Train, 2. Meditate");
    }
}
