/**
 * Represents the Novice state of a GameCharacter in a State pattern implementation.
 * Characters in this state can only train and have limited abilities.
 */
public class NoviceState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train for an hour.");
        character.experience += 10; // Increase experience by 10 points
        if (character.experience == 20) {
            character.level = 2; // Level up when experience reaches 20
            character.setState(new IntermediateState()); // Transition to Intermediate state
        } else {
            return;
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Too low level to meditate"); // Novice cannot meditate
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Too low level to fight"); // Novice cannot fight
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Actions : 1. Train"); // Only training is available
    }
}
