package MainPackage;

import Items.WeaponType;

/**
 * This class represent an Move, which can be used both for the player and the
 * boss. It contains two Attack attributes; one to represent what kind of move
 * it is and one to tell what attack can counter the move. Lastly it contains an
 * int attribute that tells how much damage the attack does.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Move {

	private Attack attack = null; //An enum which represent what kind of move it is
	private Attack counterAttack = null; //An enum which tells what attack can counter this move
	private int damage; //How much damage the move deals
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
	 * @param weaponType
	 */
	public Move(int damage, Attack attack, Attack counterAttack) {
		this.damage = damage;
		this.attack = attack;
		this.counterAttack = counterAttack;
	}

	/**
	 *
	 * @return The name of the move, which is also the name of the attack.
	 */
	public String getName() {
		return this.attack.toString();
	}

	/**
	 *
	 * @return The damage of the move.
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
	 *
	 * @param damage Sets the move damage.
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 *
	 * @return the attack, which is an enum.
	 */
	public Attack getAttack() {
		return this.attack;
	}

	/**
	 *
	 * @return the counterAttack, which is an enum.
	 */
	public Attack getCounterAttack() {
		return this.counterAttack;
	}
}
