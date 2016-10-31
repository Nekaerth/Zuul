
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

	/**
	 * This constructor returns an Move-object which is meant for the player,
	 * because it does not contain a counterAttack.
	 *
	 * @param attack Sets the type of attack.
	 * @param damage Sets the attack damage.
	 */
	public Move(Attack attack, int damage) {
		this.attack = attack;
		this.damage = damage;
	}

	/**
	 * This constructor returns an Attack-object which is meant for the boss,
	 * because it does contain a counterMove.
	 *
	 * @param attack Sets the type of attack.
	 * @param counterAttack Sets the type of counter attack.
	 * @param damage Sets the move damage.
	 */
	public Move(Attack attack, Attack counterAttack, int damage) {
		this.attack = attack;
		this.counterAttack = counterAttack;
		this.damage = damage;
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
