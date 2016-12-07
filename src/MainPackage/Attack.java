package MainPackage;

/**
 *
 * @author Semesterproject Group 13 (Autumn 2016)
 */
public enum Attack {

	PUNCH("Punch"), STAB("Stab"), DUCK("Duck"), JUMP("Jump"), SIDESTEP("Side step"), LASH("Lash"), CHARGE("Charge"), SHOOT("Shoot"), LAUGH("Laugh");

	private String attackString;

	/**
	 * The contructor of the Enum Attack. It is automatically called when a Enum
	 * is used
	 *
	 * @param stringItemType
	 */
	Attack(String attackString) {
		this.attackString = attackString;
	}

	/**
	 * Returns a string representation of an Attack. The representation is a
	 * String version of the enum Attack
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return attackString;
	}
}
