package MainPackage;

import Items.Inventory;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * The Room class is used to create rooms and methods that can describe the
 * rooms. The class consists of X instance variable and X instance methods
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Room {

	private String name;
	private HashMap<Direction, Room> exits; // Et form for array der indeholder en key og en value. For at få value skal key'en gives og der er associationer mellem disse
	private Inventory inventory;
	private boolean escapeCode, escapableRoom, locked, hidden;
	private int number;
	private String id;

	/**
	 * The constructor of the class Room. The constructor takes 6 parameters: Anid
	 * of a room, a boolean that says whether or not the room contains a number, a
	 * boolean that says whether or not the room is locked, a boolean that says
	 * whether or not the room is a escape able room, a String that is the name of
	 * the room and a boolean that says whether or not the room is hidden
	 *
	 *
	 * @param id
	 * @param numberRoom boolean
	 * @param lock
	 * @param escapeRoom
	 * @param name
	 * @param hidden
	 */
	public Room(String id, boolean numberRoom, boolean lock, boolean escapeRoom, String name, boolean hidden) {
		exits = new HashMap<>();
		this.escapableRoom = escapeRoom;
		this.id = id;
		this.name = name;
		this.escapeCode = numberRoom;
		this.locked = lock;
		this.hidden = hidden;
		this.inventory = new Inventory();
		//Generates a random number for the room, if its a room containing a number
		if (numberRoom == true) {
			number = (int) (Math.random() * 9);
		}
	}

	/**
	 * The setExit method is used to declare which exits a room has
	 *
	 * @param direction is a Direction parameter used to declare where the exit is
	 * @param neighbor is a room parameter used to declare what room the direction
	 * refers to
	 */
	public void setExit(Direction direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	public Direction getDirection(Room room) {
		for (Direction direction : getListOfExitDirections()) {
			if (getExit(direction) == room) {
				return direction;
			}
		}
		return null;
	}

	/**
	 * This method returns a string of all the exits out of the room
	 *
	 * @return a string of exits
	 */
	public String getExitString() {
		String returnString = "Exits:";
		Set<Direction> keys = exits.keySet();
		for (Direction exit : keys) {
			if (!exits.get(exit).isHidden()) {
				returnString = returnString + " " + exit.toString();
			}
		}
		return returnString;
	}

	/**
	 * This method returns the room in a given direction that is the parameter
	 *
	 * @param direction, a Direction
	 * @return a Room in the given direction if there is no room it returns null
	 */
	public Room getExit(Direction direction) {
		return exits.get(direction);
	}

	/**
	 * This method returns the number that is in the room if it is a numberroom,
	 * else it returns -1.
	 *
	 * @return an int. If the room is not a number room it returns -1. if it is, a
	 * random number
	 */
	public int getNumber() {
		if (escapeCode) {
			return number;
		} else {
			return -1;
		}
	}

	/**
	 * The setEscapeAbleRoom method is a setter method that sets the value of the
	 * boolean escapeRoom to true
	 */
	public void setEscapeableRoom() {
		this.escapableRoom = true;

	}

	/**
	 * The getEscapeRoom is a getter method that returns the current value of the
	 * boolean escapeableRoom
	 *
	 * @return will return the current boolean value of escapeRoom
	 */
	public boolean isEscapeableRoom() {
		return this.escapableRoom;

		/**
		 * The lockRoom method is a setter method that will set the boolean value
		 * lock to true
		 */
	}

	/**
	 * This method locks a room
	 *
	 */
	public void LockRoom() {
		locked = true;
	}

	/**
	 * The isLocked method will return the current boolean value of lock
	 *
	 * @return will return the current boolean value of lock
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * The unlock method is a setter method that will set the boolean value of
	 * lock to false
	 */
	public void unlock() {
		locked = false;
	}

	/**
	 * The hasEscapeCode method will return the current boolean value of
	 * EscapeCode
	 *
	 * @return will return the current boolean value
	 */
	public boolean hasEscapeCode() {
		return escapeCode;
	}

	/**
	 * Returns the id of a room
	 *
	 * @return String id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the name of the room
	 *
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the room
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns whether or not the room is hidden
	 *
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the rooms hidden attribute, based on the parameter that is given
	 *
	 * @param hidden the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Returns the inventory of a Room
	 *
	 * @return inventory of a room
	 *
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * Returns an ArrayList containing Directions of all the exits in this room
	 *
	 * @return ArrayList containing Direction
	 */
	public ArrayList<Direction> getListOfExitDirections() {
		Set<Direction> directions = exits.keySet();
		ArrayList<Direction> directionsArray = new ArrayList<>();
		directionsArray.addAll(directions);

		return directionsArray;

	}

}
