package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public enum WeaponType {
	MELEE("melee"), RANGED("ranged");

	private String stringWeaponType;

	/**
	 * The contructor of the Enum WEaponType. It is automatically called when a
	 * Enum is used
	 *
	 * @param stringItemType
	 */
	WeaponType(String stringWeaponType) {
		this.stringWeaponType = stringWeaponType;
	}

	/**
	 * Returns a string representation of an WeaponType. The representation is a
	 * String version of the enum WeaponType
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return stringWeaponType;
	}
}
