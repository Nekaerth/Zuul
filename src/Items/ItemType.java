package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public enum ItemType {

	KEY("key"), WEAPON("weapon"), FLASHLIGHT("flashlight"), BLUEPRINT("blueprint"), MISC("misc"), TIMEINCREASINGITEM("timeincreasingitem"), BOLTCUTTER("boltcutter");

	String stringItemType;

	/**
	 * The contructor of the Enum ItemType. It is automatically called when a Enum
	 * is used
	 *
	 * @param stringItemType
	 */
	private ItemType(String stringItemType) {
		this.stringItemType = stringItemType;
	}

	/**
	 * Returns a string representation of an ItemType. The representation is a
	 * String version of the enum ItemType
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return stringItemType;
	}
}
