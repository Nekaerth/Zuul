
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lasse
 */
public class Player extends Person {

	private int time;
	private int capacity;
	private int weightCapacity;

	/**
	 * This contructor creates a Player-object. It represent the player, which
	 * includes hitpoints, available attacks, available items, time left, maximum
	 * number of items and maximum weight capacity. Notice it does not include the
	 * position of the player.
	 *
	 * @param hitpoint is how much hitpoints the player has.
	 * @param attacks is a list of all attacks, that are available to the player.
	 * @param inventory is where the player holds his picked up items.
	 * @param time is how much time the player has left before losing.
	 * @param capacity is the maximum amount of items the player must hold.
	 * @param weightCapacity is the maximum weight that the players items must
	 * weight in total.
	 */
	public Player(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, int time, int capacity, int weightCapacity) {
		super(hitpoint, attacks, inventory);
		this.time = time;
		this.capacity = capacity;
		this.weightCapacity = weightCapacity;
	}

	public int getTime() {
		return this.time;
	}

	public void addTime(int time) {
		this.time += time;
	}

	public void subtractTime(int time) {
		this.time -= time;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getWeightCapacity() {
		return this.weightCapacity;
	}

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
			attack.setDamage(20);

		} else if (itemName.equalsIgnoreCase("pistol")) {
			System.out.println("Not implemented");

		}
	}
}
