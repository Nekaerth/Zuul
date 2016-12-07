package MainPackage;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public enum Direction {
	NORTH("north"), SOUTH("south"), EAST("east"), WEST("west"), UNKNOWN("?");

	private String directionString;

	/**
	 * The contructor of the Enum Direction. It is automatically called when a
	 * Enum is used
	 *
	 * @param directionString
	 */
	Direction(String directionString) {
		this.directionString = directionString;
	}

	/**
	 * Returns a string representation of an Direction. The representation is a
	 * String version of the enum Direction
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return this.directionString;
	}
}
