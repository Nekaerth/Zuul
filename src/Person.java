
import java.util.ArrayList;

/**
 * This class represent a person. It is used as an abstract class. The person
 * class attributes includes hitpoint, attacks and inventory. Among its methods
 * are getAttackString() and getAttack().
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Person {

	private int hitpoint;
	private ArrayList<Attack> attacks;
	private Inventory inventory;

	/**
	 * This contructor can creates a Person-object.It represent a person, which
	 * includes hitpoints, available attacks and available items.
	 *
	 * @param hitpoint is how much hitpoints the person has.
	 * @param attacks is a list of all attacks, that are available to the person.
	 * @param inventory is where the person holds his items.
	 */
	public Person(int hitpoint, ArrayList<Attack> attacks, Inventory inventory) {
		this.hitpoint = hitpoint;
		this.attacks = attacks;
		this.inventory = inventory;
	}

	/**
	 *
	 * @return the hitpoint for a person
	 */
	public int getHitpoint() {
		return hitpoint;
	}

	/**
	 *
	 * @param damage how much to subtract from the persons hitpoits
	 */
	public void subtractHitpoint(int damage) {
		this.hitpoint -= damage;
		//If hitpoints goes below zero, then it sets hitpoint to zero
		if (this.hitpoint < 0) {
			this.hitpoint = 0;
		}
	}

	/**
	 *
	 * @return a ArrayList of all avialble attacks
	 */
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	/**
	 *
	 * @return the inventory of the person
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 *
	 * @return a String which contains a list with all available attacks
	 */
	public String getAttackString() {
		String list = "";
		//Goes through all attacks and adds their name to the String
		for (Attack attack : attacks) {
			list += attack.getName() + ", ";
		}
		return list.substring(0, list.length() - 2);
	}

	/**
	 *
	 * @param attackName name of the requested attack
	 * @return the requested attack
	 */
	public Attack getAttack(String attackName) {
		//Goes through all attacks and returns the requested attack
		for (Attack attack : attacks) {
			if (attackName.equalsIgnoreCase(attack.getName())) {
				return attack;
			}
		}
		return null;
	}
}
