
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Room class is used to create rooms and methods that can describe the
 * rooms. The class consists of X instance variable and X instance methods
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Room {

	private final String description;
	private final HashMap<String, Room> exits; // Et form for array der indeholder en key og en value. For at få value skal key'en gives og der er associationer mellem disse
	private final Inventory inventory = new Inventory();
	private boolean numberRoom, escapeRoom, lock, needsBoss = false;
	public Boss boss = null;
	int number;

	/**
	 * The constructor of the class Room. The constructor takes 3 parameters: A
	 * description of the room, a boolean that says whether or not the room
	 * contains a number and a boolean that says whether or not the room need to
	 * create a boss
	 *
	 * @param description string
	 * @param numberRoom boolean
	 * @param needsBoss boolean
	 */
	public Room(String description, boolean numberRoom, boolean needsBoss) { //Constructor der tager en string der beskriver rummet
		this.description = description; //this.desription er variablen i Classen Room.
		exits = new HashMap<>(); //exits opretter en ny hashmap der indeholder key som string og room som value.
		this.escapeRoom = false;
		this.numberRoom = numberRoom;
		this.needsBoss = needsBoss;
		if (numberRoom == true) {
			number = (int) (Math.random() * 9);
		}
	}

	/**
	 *
	 * @return the rooms inventory.
	 */
	public Inventory getInventory() {
		return this.inventory;
	}

	/**
	 * The setExit method is used to declare which exits a room has
	 *
	 * @param direction is a string parameter used to declare where the exit is
	 * @param neighbor is a room parameter used to declare what room the direction
	 * refers to
	 */
	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	/**
	 * This method returns a string of the description of the room and the pre fix
	 * "you are"
	 *
	 * @return a string with the description
	 */
	public String getShortDescription() {
		return "You are " + description;
	}

	/**
	 * This method returns a string of the description of the room and the pre fix
	 * "you are" the string also contains all the exits out of the room
	 *
	 * @return a string with a description and exits
	 */
	public String getLongDescription() {
		return "You are " + description + "\n" + getExitString(); //Giver en længere beskrivelse af rummet og giver hvilke exits der findes
	}

	/**
	 * This method returns a string of all the exits out of the room
	 *
	 * @return a string of exits
	 */
	public String getExitString() {
		String returnString = "Exits:";
		Set<String> keys = exits.keySet();
		for (String exit : keys) {
			returnString = returnString + " " + exit;
		}
		return returnString;
	}

	/**
	 * This method returns the room in a given direction that is the parameter
	 *
	 * @param direction, a string
	 * @return a Room in the given direction
	 */
	public Room getExit(String direction) {
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
		if (numberRoom == true) {
			return number;
		} else {
			return -1;
		}
	}

	/**
	 * The setEscapeRoom method is a setter method that sets the value of the
	 * boolean escapeRoom to true
	 */
	public void setEscapeRoom() {
		this.escapeRoom = true;

	}

	/**
	 * The getEscapeRomm is a getter method that returns the current value of the
	 * boolean escapeRoom
	 *
	 * @return will return the current boolean value of escapeRoom
	 */
	public boolean getEscapeRoom() {
		return this.escapeRoom;

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
		lock = true;
	}

	/**
	 * The isLocked method will return the current boolean value of lock
	 *
	 * @return will return the current boolean value of lock
	 */
	public boolean isLocked() {
		return lock;
	}

	/**
	 * The unlock method is a setter method that will set the boolean value of
	 * lock to false
	 */
	public void unlock() {
		lock = false;
	}

	/**
	 * The isNumberRoom method will return the current boolean value of numberRoom
	 *
	 * @return will return the current boolean value
	 */
	public boolean isNumberRoom() {
		return numberRoom;
	}

	public boolean needsBoss() {
		return needsBoss;
	}

	public void setNeedsBoss(boolean needsBoss) {
		this.needsBoss = needsBoss;
	}
}
