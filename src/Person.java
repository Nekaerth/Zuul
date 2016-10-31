
import java.util.ArrayList;

/**
 * This class represent a person. It is used as an abstract class. The person
 * class attributes includes hitpoint, moves and inventory. Among its methods
 * are getMoveString() and getMove().
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Person {

	private int hitpoint; //How much hitpoints the person has.
	private ArrayList<Move> moves; //ArrayList of all moves, that are available to the person.
	private Inventory inventory; //An Inventory that holds the persons items

	/**
	 * This contructor can creates a Person-object.It represent a person, which
	 * includes hitpoints, available attacks and available items.
	 *
	 * @param hitpoint Sets the persons hitpoint.
	 * @param moves Sets the persons moves.
	 * @param inventory Sets the persons inventory.
	 */
	public Person(int hitpoint, ArrayList<Move> moves, Inventory inventory) {
		this.hitpoint = hitpoint;
		this.moves = moves;
		this.inventory = inventory;
	}

	/**
	 *
	 * @return the hitpoint for a person.
	 */
	public int getHitpoint() {
		return hitpoint;
	}

	/**
	 *
	 * @param damage how much to subtract from the persons hitpoits.
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
	 * @return a ArrayList of all avialble moves.
	 */
	public ArrayList<Move> getMoves() {
		return moves;
	}

	/**
	 *
	 * @return the inventory of the person.
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 *
	 * @return a String which contains a list with all available moves.
	 */
	public String getMoveString() {
		String list = "";
		//Goes through all attacks and adds their name to the String
		for (Move move : moves) {
			list += move.getName() + ", ";
		}
		return list.substring(0, list.length() - 2);
	}

	/**
	 *
	 * @param moveName name of the requested move.
	 * @return the requested attack.
	 */
	public Move getMove(String moveName) {
		//Goes through all moves and returns the requested move
		for (Move move : moves) {
			if (moveName.equalsIgnoreCase(move.getName())) {
				return move;
			}
		}
		return null;
	}
}
