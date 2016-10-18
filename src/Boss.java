
import java.util.ArrayList;

/**
 * This class represent a boss. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the boss. The boss class has a name variable. It also has method 
 * for returning a random attack.
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016) 
 */
public class Boss extends Person {

	private final String name;

	/**
	 * This contructor creates a Boss-object. It represent the boss, which
	 * includes hitpoints, available attacks, available items and a name.
	 *
	 * @param hitpoint is how much hitpoints the boss has
	 * @param attacks is a list of all attacks, that are available to the boss
	 * @param inventory is where the boss holds his items
	 * @param name is the name of the boss
	 */
	public Boss(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, String name) {
		super(hitpoint, attacks, inventory);
		this.name = name;
	}

	/**
	 *
	 * @return The name of the boss
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets up the first boss, by adding all attacks and adding all items to his
	 * inventory
	 */
	public void setUpPrisonGuard() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.LASH, Moves.JUMP, 10));
		attacks.add(new Attack(Moves.CHARGE, Moves.SIDESTEP, 10));
		attacks.add(new Attack(Moves.PUNCH, Moves.STAB, 10));
		getInventory().putItem("Key", new Key(true, "Key", true, 1, 1));
	}

	/**
	 * Sets up the second boss, by adding all attacks
	 */
	public void setUpPrisonGuard2() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.LASH, Moves.JUMP, 15));
		attacks.add(new Attack(Moves.CHARGE, Moves.SIDESTEP, 15));
		attacks.add(new Attack(Moves.PUNCH, Moves.STAB, 15));
		attacks.add(new Attack(Moves.SHOOT, Moves.DUCK, 15));
		attacks.add(new Attack(Moves.LAUGH, Moves.SHOOT, 5));
	}

	/**
	 * Returns an attack at random. It is be used at boss fight
	 *
	 * @return An attack at random
	 */
	public Attack getRandomAttack() {
		int randomNumber = (int) (getAttacks().size() * Math.random()); //Creates a random number between 0 and x, where x is the number of available attacks
		int count = 0;
		//Goes through all attacks
		for (Attack attack : getAttacks()) {
			//If randomNumber is equal to the current attack index
			if (randomNumber == count) {
				return attack; //Return current attack
			}
			count++;
		}
		return null;
	}
}
