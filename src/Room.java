
import java.util.Set;
import java.util.HashMap;

public class Room {

	public Inventory inv;
	private final String description;
	private final HashMap<String, Room> exits; // Et form for array der indeholder en key og en value. For at få value skal key'en gives og der er associationer mellem disse
	boolean numberRoom, escapeRoom, lock = false;
	int number;

	public Room(String description, boolean numberRoom) { //Constructor der tager en string der beskriver rummet
		this.description = description; //this.desription er variablen i Classen Room.
		exits = new HashMap<>(); //exits opretter en ny hashmap der indeholder key som string og room som value.
		inv = new Inventory(); // Creates a new inventory for each room
		this.escapeRoom = false;
		this.numberRoom = numberRoom;
		if (numberRoom == true) {
			number = 1;
		}
	}

	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	public String getShortDescription() {
		return "You are " +description;
	}
//Bør fjernes
	public String getLongDescription() {
		return "You are " + description + "\n" + getExitString(); //Giver en længere beskrivelse af rummet og giver hvilke exits der findes
	}

	public String getExitString() {
		String returnString = "Exits:";
		Set<String> keys = exits.keySet();
		for (String exit : keys) {
			returnString += " " + exit;
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

	public void setEscapeRoom() {
		this.escapeRoom = true;

	}

	public boolean getEscapeRoom() {
		return this.escapeRoom;

	}
	public void LockRoom(){
		lock = true;
	}
	public boolean isLocked(){
		
		return lock;
	}
	public void unlock(){
		lock = false;
	}

	boolean isNumberRoom() {
		return numberRoom;
	}

}
