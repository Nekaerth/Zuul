
/**
 * This class represent an attack, which can be used both for the player and the
 * boss. It contains two Moves attributes; one to represent what kind of attack
 * it is and one to tell what move can counter the attack. Lastly it contains an
 * int attribute that tells how much damage the attack does.
 *
 * @author Lasse
 */
public class Attack {

	private Moves move = null;
	private Moves counterMove = null;
	private int damage;

	/**
	 * This constructor returns an Attack-object which is meant for the player,
	 * because it does not contain a counterMove.
	 *
	 * @param move is a enum which represent what kind of attack it is.
	 * @param damage is how much this attack deals in damage.
	 */
	public Attack(Moves move, int damage) {
		this.move = move;
		this.damage = damage;
	}

	/**
	 * This constructor returns an Attack-object which is meant for the boss,
	 * because it does contain a counterMove.
	 *
	 * @param move is a enum which represent what kind of attack it is.
	 * @param counterMove is a enum which tells what move can counter this attack.
	 * @param damage is how much this attack deals in damage.
	 */
	public Attack(Moves move, Moves counterMove, int damage) {
		this.move = move;
		this.counterMove = counterMove;
		this.damage = damage;
	}

	/**
	 *
	 * @return The name of the attack, which is also the name of the move.
	 */
	public String getName() {
		return this.move.toString();
	}

	/**
	 *
	 * @return The damage of the attack.
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
	 *
	 * @param damage Sets the attack damage.
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 *
	 * @return the move, which is an enum.
	 */
	public Moves getMove() {
		return this.move;
	}

	/**
	 *
	 * @return the counterMove, which is an enum.
	 */
	public Moves getCounterMove() {
		return this.counterMove;
	}
}
