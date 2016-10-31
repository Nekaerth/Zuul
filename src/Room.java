
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

	public Inventory inv;
	private final String description;
	private final HashMap<String, Room> exits; // Et form for array der indeholder en key og en value. For at få value skal key'en gives og der er associationer mellem disse
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
		inv = new Inventory(); // Creates a new inventory for each room
		this.escapeRoom = false;
		this.numberRoom = numberRoom;
		this.needsBoss = needsBoss;
		if (numberRoom == true) {
			number = (int) (Math.random() * 9);
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

	/**
	 * This method iniates a bossfight, and is only done if the boss or the player
	 * is defeated
	 *
	 * @param game. An object of the Game class
	 * @return returns a boolean of whether or not the player has won.
	 */
	public boolean bossFight(Game game) {
		//This loop runs until the player or the boss has no hipoints left. In each iteration the boss attacks once and the player defence once.
		while (game.getPlayer().getHitpoint() > 0 && boss.getHitpoint() > 0) {
			Move currentBossMove = boss.getRandomMove(); //This chooses what move the boss uses at random.
			Move currentPlayerMove = null; //Creates variable for containing what move the player uses.
			System.out.println("The prison guard uses " + currentBossMove.getName() + "!");

			//Within this loop the player chooses a counter move. This loop makes sure that the input is valid.
			while (true) {
				System.out.println("Choose a move: " + game.getPlayer().getMoveString()); //Prints all the available moves the player can do.
				System.out.print("> ");
				Scanner scanner = new Scanner(System.in); //Creates new Scanner object.
				String input = scanner.nextLine(); //Takes user input.
				currentPlayerMove = game.getPlayer().getMove(input); //Checks if the user input is a valid move and saves the corresponding move in currentPlayerMove.

				//Breaks out of the loop if was a valid move.
				if (currentPlayerMove != null) {
					break;
				}
				System.out.println("Move does not exits. Make sure to write a correct move.");
			}
			game.getPlayer().subtractTime(5); //Subtracts 5 seconds for each move.
			//If the chosen move was a counter move to the boss move, the boss loses hitpoint equal to the player move damage. Else the player loses hitpoints equal to the boss move damage.
			if (currentBossMove.getCounterAttack() == currentPlayerMove.getAttack()) { //Checks if the player attack is a counter attack to the boss attack.
				boss.subtractHitpoint(currentPlayerMove.getDamage()); //Subtracts hitpoints from the boss.
				System.out.println("The prison guard loses " + currentPlayerMove.getDamage() + " hitpoints. He has " + boss.getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the boss have left
			} else {
				game.getPlayer().subtractHitpoint(currentBossMove.getDamage()); //Subtracts hitpoints from the player.
				System.out.println("You lose " + currentBossMove.getDamage() + " hitpoints. You have " + game.getPlayer().getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the player has left.
			}
		}
		//If the player loses all hitpoints.
		if (game.getPlayer().getHitpoint() <= 0) {
			System.out.println("You've been defeated by the prison guard!");
			return true; // returns true because you died.
		} //If the boss loses all hitpoints.
		else {
			System.out.println("You defeated the prison guard!");

			//If the boss contains a key.
			if (boss.getInventory().containItem("Key")) {
				Item item = boss.getInventory().getItem("Key"); //Gets Key from boss inventory.
				this.inv.putItem("Key", item); //Drops the key in the room.
			}

			boss = null; //Removes the boss.
			return false; //Returns false because you didn't die.
		}
	}

	public boolean needsBoss() {
		return needsBoss;
	}

	public void setNeedsBoss(boolean needsBoss) {
		this.needsBoss = needsBoss;
	}
}
