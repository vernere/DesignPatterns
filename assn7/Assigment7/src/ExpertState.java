/**
 * ExpertState implements the State interface for a character in the Expert state.
 * Characters in this state are advanced and can progress to Master state.
 */
public class ExpertState implements State {

    /**
     * Handles training action for a character in Expert state.
     * Increases experience and transitions to MasterState if experience reaches 90.
     * 
     * @param character The game character performing the action
     */
    @Override
    public void train(GameCharacter character) {
        System.out.println("You train for an hour.");
        character.experience += 10;
        if (character.experience == 90) {
            character.level = 4;
            character.setState(new MasterState());
        } else {
            return;
        }
    }

    /**
     * Handles meditation action for a character in Expert state.
     * Increases the character's health.
     * 
     * @param character The game character performing the action
     */
    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditate for an hour.");
        character.health += 10;
    }

    /**
     * Handles fighting action for a character in Expert state.
     * Decreases health, increases experience significantly, and 
     * transitions to MasterState if experience reaches 90.
     * 
     * @param character The game character performing the action
     */
    @Override
    public void fight(GameCharacter character) {
        System.out.println("You fight for an hour.");
        character.health -= 10;
        character.experience += 25;
        if (character.experience == 90) {
            character.setState(new MasterState());
        } else {
            return;
        }
    }

    /**
     * Displays the available actions for a character in Expert state.
     */
    @Override
    public void displayAvailableActions() {
        System.out.println("Actions : 1. Train, 2. Meditate, 3. Fight");
    }
}
