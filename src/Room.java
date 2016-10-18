
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
	private boolean numberRoom, escapeRoom, lock, needsBoss = false;
	public Boss boss = null;
	int number;

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

	public boolean bossFight(Game game) {
		//This loop runs until the player or the boss has no hipoints left. In each iteration the boss attacks once and the player defence once.
		while (game.getPlayer().getHitpoint() > 0 && boss.getHitpoint() > 0) {
			Attack currentBossAttack = boss.getRandomAttack(); //This chooses what attack the boss uses at random.
			Attack currentPlayerAttack = null; //Creates variable for containing what attack the player uses.
			System.out.println("The prison guard uses " + currentBossAttack.getName() + "!");

			//Within this loop the player chooses a counter attack. This loop makes sure that the input is valid.
			while (true) {
				System.out.println("Choose a move: " + game.getPlayer().getAttackString()); //Prints all the available attacks the player can do.
				System.out.print("> ");
				Scanner scanner = new Scanner(System.in); //Creates new Scanner object.
				String input = scanner.nextLine(); //Takes user input.
				currentPlayerAttack = game.getPlayer().getAttack(input); //Checks if the user input is a valid attack and saves the corresponding attack in currentPlayerAttack.

				//Breaks out of the loop if was a valid attack.
				if (currentPlayerAttack != null) {
					break;
				}
				System.out.println("Move does not exits. Make sure to write a correct move.");
			}
			game.subtractTime(5); //Subtracts 5 seconds for each move.
			//If the chosen attack was a counter attack to the boss attack, the boss loses hitpoint equal to the player attack damage. Else the player loses hitpoints equal to the boss attack damage.
			if (currentBossAttack.getCounterMove() == currentPlayerAttack.getMove()) { //Checks if the player attack is a counter attack to the boss attack.
				boss.subtractHitpoint(currentPlayerAttack.getDamage()); //Subtracts hitpoints from the boss.
				System.out.println("The prison guard loses " + currentPlayerAttack.getDamage() + " hitpoints. He has " + boss.getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the boss have left
			} else {
				game.getPlayer().subtractHitpoint(currentBossAttack.getDamage()); //Subtracts hitpoints from the player.
				System.out.println("You lose " + currentBossAttack.getDamage() + " hitpoints. You have " + game.getPlayer().getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the player has left.
			}
		}

		if (game.getPlayer().getHitpoint() <= 0) {
			System.out.println("You've been defeated by the prison guard!");
			return true;
		} else {
			System.out.println("You defeated the prison guard!");

			if (boss.getInventory().containItem("Key")) {
				Item item = boss.getInventory().getItem("Key"); //gets Key from boss inventory.
				this.inv.putItem("Key", item); //Drops the key in the room.
			}

			boss = null;
			return false;
		}
	}
        public boolean needsBoss() {
            return needsBoss;
        }
        
        public void setNeedsBoss(boolean needsBoss) {
            this.needsBoss = needsBoss;
        }
}
