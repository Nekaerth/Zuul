package Items;

/**
 *
 * @author Semesterproject Group 13 (Autumn 2016)
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
	 * The abstract method which is declared in the abstract class Item is overrided so that
	 * The getType method returns the enum value corresponding to this item type
	 *
	 * @return will return a value of the type ItemType enum
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.FLASHLIGHT;
	}

	/**
	 * The getCharges method returns the int value that contains how many charges that are left
	 *
	 * @return will return an int of how many charges is left
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
