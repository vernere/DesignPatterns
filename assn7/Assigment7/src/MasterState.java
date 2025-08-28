/**
 * Represents the master state of a game character in the State pattern implementation.
 * This is the highest level state that a character can achieve.
 * 
 * In this state, all actions (train, meditate, fight) result in congratulatory messages
 * as the character has already reached the maximum level of mastery.
 * 
 * This class implements the State interface, providing specific behavior
 * for a character who has reached master level.
 */
public class MasterState implements State {

     @Override
    public void train(GameCharacter character) {
        System.out.println("Youve reached master level congratulations!");

    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Youve reached master level congratulations!");

    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Youve reached master level congratulations!");
    }

    @Override
    public void displayAvailableActions() {
        throw new UnsupportedOperationException("1. Train , 2.Meditate, 3. Fight");
    }

}
