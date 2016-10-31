
import java.util.ArrayList;

/**
 * This class represent a boss. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the boss. The boss class has a name variable. It also has method
 * for returning a random move.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Boss extends Person {

	private final String name; //The name of the boss

	/**
	 * This contructor creates a Boss-object. It represent the boss, which
	 * includes hitpoints, available attacks, available items and a name.
	 *
	 * @param hitpoint Sets the boss's hitpoint.
	 * @param name Sets the name of the boss.
	 */
	public Boss(int hitpoint, String name) {
		super(hitpoint);
		this.name = name;
	}

	/**
	 *
	 * @return The name of the boss.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns an move at random. It is be used at boss fight.
	 *
	 * @return An move at random.
	 */
	public Move getRandomMove() {
		int randomNumber = (int) (getMoves().size() * Math.random()); //Creates a random number between 0 and x, where x is the number of available moves
		int count = 0;
		//Goes through all moves
		for (Move move : getMoves()) {
			//If randomNumber is equal to the current move index
			if (randomNumber == count) {
				return move; //Return current move
			}
			count++;
		}
		return null;
	}
}
