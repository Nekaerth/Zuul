package MainPackage;

/**
 * This class represent a boss. It extends the Person class to adobt the
 * hitpoints, available attacks and an inventory. Notice it does not include the
 * position of the boss. The boss class has a name variable. It also has method
 * for returning a random move.
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Boss extends Person {

	private final String name; //The name of the boss

	/**
	 * This contructor creates a Boss-object. It represent the boss, which
	 * includes hitpoints, available attacks, available items and a name.
	 *
	 * @param room Sets which room the boss currently is in.
	 * @param hitpoint Sets the boss's hitpoint.
	 * @param name Sets the name of the boss.
	 */
	public Boss(Room room, int hitpoint, String name) {
		super(room, hitpoint);
		this.name = name;
	}

	/**
	 *
	 * @return The name of the boss.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The setCurrentMoveAtRandom method is used to randomize the attack which the
	 * boss will make against the player in an encounter
	 */
	public void setCurrentMoveAtRandom() {
		//Creates a random number between 0 and x, where x is the number of available moves
		int randomNumber = (int) (getMoves().size() * Math.random());
		int count = 0;
		//Goes through all moves
		for (Move move : getMoves()) {
			//If randomNumber is equal to the current move index
			if (randomNumber == count) {
				this.setCurrentMove(move);
			}
			count++;
		}
	}

	/**
	 * The playerHitBoss method is used during an encounter between a player and a
	 * boss, it is used to chekc wheter the player chooses the right counter
	 * attack against the bosses randomly chosen move
	 *
	 * @param player is the player that is in an encounter with the boss
	 * @return will return a boolean based on wheter the chosen move was right or
	 * wrong
	 */
	public boolean playerHitsBoss(Player player) {
		//Subtracts 5 seconds for each move
		player.subtractTime(5);
		//If the chosen move was a counter move to the boss move, the boss loses hitpoint equal to the player move damage. Else the player loses hitpoints equal to the boss move damage.
		if (player.getCurrentMove().getAttack() == this.getCurrentMove().getCounterAttack()) {
			this.subtractHitpoint(player.getCurrentMove().getDamage()); //Subtracts hitpoint from the boss
			return true;
		}
		player.subtractHitpoint(this.getCurrentMove().getDamage()); //Subtracts hitpoint from the player
		return false;
	}
}
