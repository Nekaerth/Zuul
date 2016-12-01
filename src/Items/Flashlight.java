package Items;

/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Flashlight extends Item {

	private int charges;

	/**
	 * The constructor for the Flashlight class is called when we want to create
	 * objects of the Flashlight class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the item
	 * @param useable is a boolean used to check if the item can be used
	 * @param weight is an int that refers to the weight of the item
	 * @param capacity is an int that refers to the capacity of the item
	 * @param charges is an int that refers to how many charges the item has
	 */
	public Flashlight(boolean pickup, String name, boolean useable, int weight, int capacity, int charges) {
		super(pickup, name, useable, weight, capacity);
		this.charges = charges;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * isPickup method returns the boolean value declared when creating the
	 * flashlight object
	 *
	 * @return will return a value of the type ItemType enum
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.FLASHLIGHT;
	}

	/**
	 * The getCharges method returns the int value declared when creating the
	 * flashlight object
	 *
	 * @return will return an int equal to what is declared when creating the
	 * object
	 */
	public int getCharges() {
		return this.charges;

	}

	/**
	 * The subtractCharge method will subtract the int value of subCharge from
	 * charges
	 *
	 * @param subCharge is an int used to determine how many charges we subract
	 */
	public void subtractCharge(int subCharge) {

		this.charges -= subCharge;
	}

}
