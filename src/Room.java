
/**
 * The Room class is used to create rooms and methods
 * that can describe the rooms.
 * The class consists of X instance variable and X instance methods
 */
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

public class Room {

	public Inventory inv;
	private final String description;
	private final HashMap<String, Room> exits; // Et form for array der indeholder en key og en value. For at få value skal key'en gives og der er associationer mellem disse
	private boolean numberRoom, escapeRoom, lock, hideRoom = false;
	public Boss boss = null;
	int number;
        
	public Room(String description, boolean numberRoom) { //Constructor der tager en string der beskriver rummet
		this.description = description; //this.desription er variablen i Classen Room.
		exits = new HashMap<>(); //exits opretter en ny hashmap der indeholder key som string og room som value.
		inv = new Inventory(); // Creates a new inventory for each room
		this.escapeRoom = false;
		this.numberRoom = numberRoom;                
		if (numberRoom == true) {
			number = (int)(Math.random()*9);
		}
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

	public String getShortDescription() {
		return "You are " + description;
	}
	public String getLongDescription() {
		return "You are " + description + "\n" + getExitString(); //Giver en længere beskrivelse af rummet og giver hvilke exits der findes
	}

	public String getExitString() {
		String returnString = "Exits:";
		Set<String> keys = exits.keySet();
		for (String exit : keys) {     
                        returnString = returnString + " " + exit;                       
		}
		return returnString;
	}

	public Room getExit(String direction) {
		return exits.get(direction);
	}

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
}
