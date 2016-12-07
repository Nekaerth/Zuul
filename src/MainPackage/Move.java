package MainPackage;

import Items.WeaponType;

/**
 * This class represent an Move, which can be used both for the player and the
 * boss. It contains two Attack attributes; one to represent what kind of move
 * it is and one to tell what attack can counter the move. Lastly it contains an
 * int attribute that tells how much damage the attack does.
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Move {

	private Attack attack = null;
	private Attack counterAttack = null;
	private int damage;
	private WeaponType weaponType;

	/**
	 * This constructor returns an Move-object which is meant for the player,
	 * because it does not contain a counterAttack.
	 *
	 * @param damage The attack damage.
	 * @param attack The type of attack.
	 * @param weaponType
	 */
	public Move(int damage, Attack attack, WeaponType weaponType) {
		this.damage = damage;
		this.attack = attack;
		this.weaponType = weaponType;
	}

	/**
	 * This constructor returns an Attack-object which is meant for the boss,
	 * because it does contain a counterMove.
	 *
	 * @param damage The move damage.
	 * @param attack The type of attack.
	 * @param counterAttack The type of counter attack.
	 */
	public Move(int damage, Attack attack, Attack counterAttack) {
		this.damage = damage;
		this.attack = attack;
		this.counterAttack = counterAttack;
	}

	/**
	 * Returns the name of the move, which is also the name of the attack.
	 *
	 * @return String name of the Attack
	 */
	public String getName() {
		return this.attack.toString();
	}

	/**
	 * Returns the damage of the move as an int
	 *
	 * @return int The damage of the move.
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
	 * Sets the damage of the move
	 *
	 * @param damage Sets the move damage.
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Returns the attack
	 *
	 * @return the attack, which is an enum.
	 */
	public Attack getAttack() {
		return this.attack;
	}

	/**
	 * Returns the counter attack
	 *
	 * @return the counterAttack, which is an enum.
	 */
	public Attack getCounterAttack() {
		return this.counterAttack;
	}
}
