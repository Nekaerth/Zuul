
/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Flashlight implements Item {

	private boolean pickup, useable;
	private int weight, capacity, charges;
	private String name;

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
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
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
	public ItemType getType(){
		return ItemType.FLASHLIGHT;
	}
	
	/**
	 * We override the instance method which is declare in the interface The
	 * getName method returns the name of the flashlight object
	 *
	 * @return will return the name of the item in a String
	 */
	@Override
	public String getName() {
		return this.name;
	}


	/**
	 * We override the instance method which is declare in the interface The
	 * isPickup method returns the boolean value declared when creating the
	 * flashlight object
	 *
	 * @return will return a boolean equal to what is declared when creating the
	 * object
	 */
	@Override
	public boolean isPickup() {
		return this.pickup;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * isUseable method returns the boolean value declared when creating the
	 * flashlight object
	 *
	 * @return will return a boolean equal to what is declared when creating the
	 * object
	 */
	@Override
	public boolean isUseable() {
		return this.useable;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getWeight method returns the int value declared when creating the
	 * flashlight object
	 *
	 * @return will return an int equal to what is declared when creating the
	 * object
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getCapacity method returns the int value declared when creating the
	 * flashlight object
	 *
	 * @return will return a int equal to what is declared when creating the
	 * object
	 */
	@Override
	public int getCapacity() {
		return this.capacity;
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
