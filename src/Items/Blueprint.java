package Items;

/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Blueprint extends Item {
    

	/**
	 * The constructor for the specialItem class is called when we want to create
	 * objects of the specialItem class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the specialItem
	 * @param useable is a boolean used to check if the item can be used once you
	 * have picked it up
	 * @param weight is an int that refers to the weight of the item
	 * @param capacity is an int that refers to how much space it requires in the
	 * inventory
	 */
	public Blueprint(boolean pickup, String name, boolean useable, int weight, int capacity) {
		super(pickup, name, useable, weight, capacity);
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getType method returns the enum value corresponding to this item type
	 *
	 * @return will return a value of the type ItemType enum
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.BLUEPRINT;
	}
}
