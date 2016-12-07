package MainPackage;

import Items.Inventory;
import java.util.ArrayList;

/**
 * This class represent a person. It is used as an abstract class. The person
 * class attributes includes room, hitpoint, moves and inventory. Among its
 * methods are getMoveString() and getMove().
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public abstract class Person {

	private Room room; //Where the person currently is.
	private int hitpoint; //How much hitpoints the person has.
	private Inventory inventory; //An Inventory that holds the persons items
	private ArrayList<Move> moves; //ArrayList of all moves, that are available to the person.
	private Move currentMove;

	/**
	 * This contructor can creates a Person-object.It represent a person, which
	 * includes hitpoints and available attacks
	 *
	 * @param room Sets which room the person currently is in.
	 * @param hitpoint Sets the persons hitpoint.
	 */
	public Person(Room room, int hitpoint) {
		this.room = room;
		this.hitpoint = hitpoint;
		this.inventory = new Inventory();
		this.moves = new ArrayList<>();
	}

	/**
	 * Returns the room which the person currently is in.
	 *
	 * @return Room
	 */
	public Room getRoom() {
		return this.room;
	}

	/**
	 * Changes the room that the person is in
	 *
	 * @param room which room to change current room to.
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Returns the hitpoints of the person as an int
	 *
	 * @return int
	 */
	public int getHitpoint() {
		return hitpoint;
	}

	/**
	 * subtracts a given amount in the parameter from the persons hitpoints
	 *
	 * @param int damage how much to subtract from the persons hitpoits.
	 */
	public void subtractHitpoint(int damage) {
		this.hitpoint -= damage;
		//If hitpoints goes below zero, then it sets hitpoint to zero
		if (this.hitpoint < 0) {
			this.hitpoint = 0;
		}
	}

	/**
	 * Returns the inventory of the person
	 *
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * Returns an ArrayList of all the available moves
	 *
	 * @return an ArrayList containing Move
	 */
	public ArrayList<Move> getMoves() {
		return moves;
	}

	/**
	 * Returns a move based on a String that is the name of the move
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

	/**
	 * Returns the current move of the person
	 *
	 * @return Move
	 */
	public Move getCurrentMove() {
		return currentMove;
	}

	/**
	 * Sets the current move of the person
	 *
	 * @param move
	 */
	public void setCurrentMove(Move move) {
		this.currentMove = move;
	}
}
