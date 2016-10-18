
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

	private int capacity; //Is the maximum amount of items the player must hold.
	private int weightCapacity; //Is the maximum weight that the players items must

	/**
	 * This contructor creates a Player-object. It represent the player, which
	 * includes hitpoints, available attacks, available items, maximum number of
	 * items and maximum weight capacity.
	 *
	 * @param hitpoint is how much hitpoints the player has.
	 * @param attacks is a list of all attacks, that are available to the player.
	 * @param inventory is where the player holds his picked up items.
	 * @param capacity is the maximum amount of items the player must hold.
	 * @param weightCapacity is the maximum weight that the players items must weight in total.
	 */
	public Player(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, int capacity, int weightCapacity) {
		super(hitpoint, attacks, inventory);
		this.capacity = capacity;
		this.weightCapacity = weightCapacity;
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
	 * Adds four attack to player attack list.
	 */
	public void setUpPlayer() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.STAB, 10));
		attacks.add(new Attack(Moves.DUCK, 0));
		attacks.add(new Attack(Moves.JUMP, 0));
		attacks.add(new Attack(Moves.SIDESTEP, 0));
	}

	/**
	 * Takes an item name as argument. If the item is a melee weapon, the damage
	 * of the Stab attack is changed. If the item is a range weapon, then a Shoot
	 * attack is added to player attacks
	 *
	 * @param item Takes an weapon item to update attacks
	 */
	public void changePlayerAttack(Item item) {
		Weapon weapon = (Weapon) item;
		//If the item is a melee weapon
		if (weapon.weaponType().equalsIgnoreCase("melee")) {
			Attack attack = getAttack("Stab");
			attack.setDamage(weapon.getDamage()); //Changes damage of the Stab attack
		} //If the item is a range weapon
		else if (weapon.weaponType().equalsIgnoreCase("range")) {
			ArrayList<Attack> attacks = getAttacks();
			attacks.add(new Attack(Moves.SHOOT, weapon.getDamage())); //Adds a Shoot attack
		}
	}

	public void droppedWeapon(Item item) {
		Weapon weapon = (Weapon) item;
		if (weapon.weaponType().equalsIgnoreCase("range")) {
			ArrayList<Attack> attacks = getAttacks();
			Attack attack = getAttack("Shoot");
			attacks.remove(attack);

		} else if (weapon.weaponType().equalsIgnoreCase("melee")) {
			Attack attack = getAttack("Stab");
			attack.setDamage(10);

		}

	}
}
