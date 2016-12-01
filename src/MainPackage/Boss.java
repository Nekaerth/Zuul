package MainPackage;

import java.util.Scanner;

/**
 * This class represent a boss. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the boss. The boss class has a name variable. It also has method
 * for returning a random move.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Boss extends Person {

	private final String name; //The name of the boss

	/**
	 * This contructor creates a Boss-object. It represent the boss, which
	 * includes hitpoints, available attacks, available items and a name.
	 *
	 * @param room Sets which room the boss currently is in.
	 * @param hitpoint Sets the boss's hitpoint.
	 * @param name Sets the name of the boss.
	 */
	public Boss(Room room, int hitpoint, String name) {
		super(room, hitpoint);
		this.name = name;
	}

	/**
	 *
	 * @return The name of the boss.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns an move at random. It is be used at boss fight.
	 *
	 * @return An move at random.
	 */
	public Move getRandomMove() {
		int randomNumber = (int) (getMoves().size() * Math.random()); //Creates a random number between 0 and x, where x is the number of available moves
		int count = 0;
		//Goes through all moves
		for (Move move : getMoves()) {
			//If randomNumber is equal to the current move index
			if (randomNumber == count) {
				return move; //Return current move
			}
			count++;
		}
		return null;
	}

	/**
	 * This method iniates a bossfight, and is only done if the boss or the player
	 * is defeated
	 *
	 * @param player the player that fights the boss.
	 * @return returns a boolean of whether or not the player has won.
	 */
	public boolean bossFight(Player player) {
		//This loop runs until the player or the boss has no hipoints left. In each iteration the boss attacks once and the player defence once.
		while (player.getHitpoint() > 0 && getHitpoint() > 0) {

			Move currentBossMove = getRandomMove(); //This chooses what move the boss uses at random.
			Move currentPlayerMove = null; //Creates variable for containing what move the player uses.
			System.out.println("The prison guard uses " + currentBossMove.getName() + "!");

			//Within this loop the player chooses a counter move. This loop makes sure that the input is valid.
			while (true) {
				System.out.println("Choose a move: " + player.getMoveString()); //Prints all the available moves the player can do.
				System.out.print("> ");
				Scanner scanner = new Scanner(System.in); //Creates new Scanner object.
				String input = scanner.nextLine(); //Takes user input.
				currentPlayerMove = player.getMove(input); //Checks if the user input is a valid move and saves the corresponding move in currentPlayerMove.

				//Breaks out of the loop if was a valid move.
				if (currentPlayerMove != null) {
					break;
				}
				System.out.println("Move does not exits. Make sure to write a correct move.");
			}
			player.subtractTime(5); //Subtracts 5 seconds for each move.
			//If the chosen move was a counter move to the boss move, the boss loses hitpoint equal to the player move damage. Else the player loses hitpoints equal to the boss move damage.
			if (currentBossMove.getCounterAttack() == currentPlayerMove.getAttack()) { //Checks if the player attack is a counter attack to the boss attack.
				subtractHitpoint(currentPlayerMove.getDamage()); //Subtracts hitpoints from the boss.
				System.out.println("The prison guard loses " + currentPlayerMove.getDamage() + " hitpoints. He has " + getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the boss have left
			} else {
				player.subtractHitpoint(currentBossMove.getDamage()); //Subtracts hitpoints from the player.
				System.out.println("You lose " + currentBossMove.getDamage() + " hitpoints. You have " + player.getHitpoint() + " hitpoints left."); //Prints out how much damage dealt and how much hitpoints the player has left.
			}
		}
		//If the player loses all hitpoints.
		if (player.getHitpoint() <= 0) {
			System.out.println("You've been defeated by the prison guard!");
			return true; // returns true because you died.
		} //If the boss loses all hitpoints.
		else {
			System.out.println("You defeated the prison guard!");

			getRoom().getInventory().putInventory(this.getInventory()); //Drops all boss items into the rooms inventory.
			setRoom(null); //Removes the boss (removes it from the room).
			player.addBossKill(1);
			return false; //Returns false because you didn't die.
		}
	}

	/**
	 * @return the bossType
	 */
}
