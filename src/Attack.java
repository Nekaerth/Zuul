
/**
 * This class represent an attack, which can be used both for the player and the
 * boss. It contains two Moves attributes; one to represent what kind of attack
 * it is and one to tell what move can counter the attack. Lastly it contains an
 * int attribute that tells how much damage the attack does.
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Attack {

	private Moves move = null; //An enum which represent what kind of attack it is
	private Moves counterMove = null; //An enum which tells what move can counter this attack
	private int damage; //How much damage the attack deals

	/**
	 * This constructor returns an Attack-object which is meant for the player,
	 * because it does not contain a counterMove.
	 *
	 * @param move Sets the type of move.
	 * @param damage Sets the attack damage.
	 */
	public Attack(Moves move, int damage) {
		this.move = move;
		this.damage = damage;
	}

	/**
	 * This constructor returns an Attack-object which is meant for the boss,
	 * because it does contain a counterMove.
	 *
	 * @param move Sets the type of move.
	 * @param counterMove Sets the type of counter move.
	 * @param damage Sets the attack damage.
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
