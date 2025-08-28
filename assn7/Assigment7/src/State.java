/**
 * The State interface is part of the State pattern implementation for a game character.
 * It defines the various actions a character can perform in different states of the game.
 * Each concrete state class will implement this interface to provide state-specific behavior
 * for actions such as training, meditating, and fighting.
 *
 * @see GameCharacter
 */
public interface State {

    public void train(GameCharacter character);

    public void meditate(GameCharacter character);

    public void fight(GameCharacter character);

    public void displayAvailableActions();

}
