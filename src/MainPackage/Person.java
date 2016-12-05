package MainPackage;

import Items.Inventory;
import java.util.ArrayList;

/**
 * This class represent a person. It is used as an abstract class. The person
 * class attributes includes room, hitpoint, moves and inventory. Among its
 * methods are getMoveString() and getMove().
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Person {

	private Room room; //Where the person currently is.
	private int hitpoint; //How much hitpoints the person has.
	private Inventory inventory = new Inventory(); //An Inventory that holds the persons items
	private ArrayList<Move> moves = new ArrayList<>(); //ArrayList of all moves, that are available to the person.
	private Move currentMove;

	/**
	 * This contructor can creates a Person-object.It represent a person, which
	 * includes hitpoints, available attacks and available items.
	 *
	 * @param room Sets which room the person currently is in.
	 * @param hitpoint Sets the persons hitpoint.
	 */
	public Person(Room room, int hitpoint) {
		this.room = room;
		this.hitpoint = hitpoint;
	}

	/**
	 *
	 * @return the room which the person currently is in.
	 */
	public Room getRoom() {
		return this.room;
	}

	/**
	 *
	 * @param room which room to change current room to.
	 */
	public void setRoom(Room room) {
		this.room = room;
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
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
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

	public Move getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(Move move) {
		this.currentMove = move;
	}
}
