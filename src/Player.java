
import java.util.ArrayList;

/**
 * This class represent the player. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the player. The player also have a maximum item capacity and a
 * maximum item weight capacity. It has a method for changing and adding
 * attacks, when picking up weapon items.
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Player extends Person {

	private int time;
	private final int capacity; //Is the maximum amount of items the player must hold.
	private final int weightCapacity; //Is the maximum weight that the players items must

	/**
	 * This contructor creates a Player-object. It represent the player, which
	 * includes hitpoints, available attacks, available items, maximum number of
	 * items and maximum weight capacity.
	 *
	 * @param room Sets which room the player currently is in.
	 * @param hitpoint Sets the players hitpoint.
	 * @param time Sets how much time the player has.
	 * @param capacity Sets the players maximum item capacity.
	 * @param weightCapacity Sets the players maximum item weight capacity.
	 */
	public Player(Room room, int hitpoint, int time, int capacity, int weightCapacity) {
		super(room, hitpoint);
		this.time = time;
		this.capacity = capacity;
		this.weightCapacity = weightCapacity;
	}

	/**
	 * The getTime() is a getter method to get the integer "time"
	 *
	 * @return will return the integer "time"
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * The subtractTime() method is used as a count down timer to keep track of
	 * how much time the player has left. Time is used as a ressource that you
	 * spend while moving through rooms and looking for items.
	 *
	 * @param time is an integer that we subtract from to reduce the time the
	 * player has left to win the game.
	 */
	public void subtractTime(int time) {
		int fiveMinuteMark = (this.time - 1) / 300;
		this.time -= time;
		int newFiveMinuteMark = (this.time - 1) / 300;
		if (fiveMinuteMark > newFiveMinuteMark) {
			System.out.println("You have " + displayTime() + " left.");
		}
	}

	/**
	 *
	 * @return will return the time that the player has left in minutes and
	 * seconds as a String
	 */
	public String displayTime() {
		int minutes = this.time / 60;
		int seconds = this.time % 60;
		return minutes + " min and " + seconds + " sec";
	}

	/**
	 *
	 * @return the maximum amount item the player can hold.
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 *
	 * @return the maximum weight that the players items must weight in total.
	 */
	public int getWeightCapacity() {
		return this.weightCapacity;
	}

	/**
	 * Takes an item name as argument. If the item is a melee weapon, the damage
	 * of the Stab move is changed. If the item is a range weapon, then a Shoot
	 * move is added to player moves.
	 *
	 * @param item Takes a weapon item to update attacks.
	 */
	public void changePlayerMove(Item item) {
		Weapon weapon = (Weapon) item;
		//If the item is a melee weapon
		if (weapon.weaponType().equalsIgnoreCase("melee")) {
			Move move = getMove("Stab");
			move.setDamage(weapon.getDamage()); //Changes damage of the Stab move
		} //If the item is a range weapon
		else if (weapon.weaponType().equalsIgnoreCase("ranged")) {
			ArrayList<Move> moves = getMoves();
			moves.add(new Move(Attack.SHOOT, weapon.getDamage())); //Adds a Shoot move
		}
	}

	/**
	 *
	 * @param item Takes a weapon item which effect on moves should be reversed
	 */
	public void droppedWeapon(Item item) {
		Weapon weapon = (Weapon) item;
		//If the item is a range weapon
		if (weapon.weaponType().equalsIgnoreCase("range")) {
			ArrayList<Move> moves = getMoves();
			Move move = getMove("Shoot"); //Removes the Shoot move
			moves.remove(move);
		} //If the item is a melee weapon
		else if (weapon.weaponType().equalsIgnoreCase("melee")) {
			Move move = getMove("Stab");
			move.setDamage(10); //Sets Stab damage back to 10
		}
	}
}
