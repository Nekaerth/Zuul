package MainPackage;

import Items.WeaponType;
import Items.Weapon;
import java.util.ArrayList;

/**
 * This class represent the player. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the player. The player also have a maximum item capacity and a
 * maximum item weight capacity. It has a method for changing and adding
 * attacks, when picking up weapon items.
 *
 * @author Termproject 13 (Autumn 2016)
 */
public class Player extends Person {

	private int time;
	private final int itemCapacity; //Is the maximum amount of items the player must hold.
	private final int maxWeight; //Is the maximum weight that the players items must
	private int amountOfBossKill;

	/**
	 * This contructor creates a Player-object. It represent the player, which
	 * includes hitpoints, available attacks, available items, maximum number of
	 * items and maximum weight capacity.
	 *
	 * @param room Sets which room the player currently is in.
	 * @param hitpoint Sets the players hitpoint.
	 * @param time Sets how much time the player has.
	 * @param itemCapacity Sets the players maximum item capacity.
	 * @param maxWeight Sets the players maximum item weight capacity.
	 */
	public Player(Room room, int hitpoint, int time, int itemCapacity, int maxWeight) {
		super(room, hitpoint);
		this.time = time;
		this.itemCapacity = itemCapacity;
		this.maxWeight = maxWeight;
		this.amountOfBossKill = 0;
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
	 * Adds a specified amount of time to the players time
	 * @param time 
	 */
	public void addTime(int time) {
		this.time += time;
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
		this.time -= time;
		//If time goes below 0, then it sets the time to 0 instead
		if (this.time < 0) {
			this.time = 0;
		}

	}

	/**
	 * Returns the maximum item capacity for the player 
	 *
	 * @return int
	 */
	public int getMaxItemCapacity() {
		return this.itemCapacity;
	}

	/**
	 * Returns the max weight of items that the player can hold
	 * @return the maximum weight that the players items must weight in total.
	 */
	public int getMaxWeight() {
		return this.maxWeight;
	}

	/**
	 * Changes the players move
	 * Takes an item as argument. If the item is a melee weapon, the damage
	 * of the Stab move is changed. If the item is a range weapon, then a Shoot
	 * move is added to player moves.
	 *
	 * @param weapon Takes a weapon item to update attacks.
	 */
	public void changePlayerMove(Weapon weapon) {
		//If the item is a melee weapon
		if (weapon.weaponType() == WeaponType.MELEE) {
			Move move = getMove("Stab");
			move.setDamage(weapon.getDamage()); //Changes damage of the Stab move
		} //If the item is a range weapon
		else if (weapon.weaponType() == WeaponType.RANGED) {
			ArrayList<Move> moves = getMoves();
			moves.add(new Move(weapon.getDamage(), Attack.SHOOT, WeaponType.MELEE)); //Adds a Shoot move
		}
	}

	/**
	 *	Changes a players move, and is used to revert the effects of picking up an item
	 * @param weapon Takes a weapon item which effect on moves should be reversed
	 */
	public void droppedWeapon(Weapon weapon) {
		//If the item is a range weapon
		if (weapon.weaponType() == WeaponType.RANGED) {
			ArrayList<Move> moves = getMoves();
			Move move = getMove("Shoot"); //Removes the Shoot move
			moves.remove(move);
		} //If the item is a melee weapon
		else if (weapon.weaponType() == WeaponType.MELEE) {
			Move move = getMove("Stab");
			move.setDamage(10); //Sets Stab damage back to 10
		}
	}

	/**
	 * Returns the amount of bosses killed by the player
	 * @return The amount of boss kills
	 */
	public int getAmountOfBossKill() {
		return amountOfBossKill;
	}

	/**
	 * Adds a bosskill to the player
	 */
	public void addOneBossKill() {
		this.amountOfBossKill++;
	}
}
