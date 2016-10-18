
import java.util.ArrayList;

/**
 *
 * @author Lasse
 */
public class Player extends Person {

	private int capacity;
	private int weightCapacity;

	/**
	 * This contructor creates a Player-object. It represent the player, which
	 * includes hitpoints, available attacks, available items, maximum number of
	 * items and maximum weight capacity. Notice it does not include the position
	 * of the player.
	 *
	 * @param hitpoint is how much hitpoints the player has.
	 * @param attacks is a list of all attacks, that are available to the player.
	 * @param inventory is where the player holds his picked up items.
	 * @param capacity is the maximum amount of items the player must hold.
	 * @param weightCapacity is the maximum weight that the players items must
	 * weight in total.
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
	public void setPlayerAttacks() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.STAB, 10));
		attacks.add(new Attack(Moves.DUCK, 0));
		attacks.add(new Attack(Moves.JUMP, 0));
		attacks.add(new Attack(Moves.SIDESTEP, 0));
	}

	public void changePlayerAttack(String itemName) {

		if (itemName.equalsIgnoreCase("knife")) {
			Attack attack = getAttack("Stab");
			attack.setDamage(15);

		} else if (itemName.equalsIgnoreCase("pistol")) {
                        ArrayList<Attack> attacks = getAttacks();
                        attacks.add(new Attack(Moves.SHOOT, 25));        

		}
	}
}
