package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Misc extends Item {

	/**
	 * The constructor for the Weapon class is called when we want to create
	 * objects of the misc class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the misc
	 * @param useable is a boolean used to check if the item can be used once you
	 * have picked it up
	 */
	public Misc(boolean pickup, String name, boolean useable, int weight, int capacity) {
		super(pickup, name, useable, weight, capacity);
	}

	/**
	 * The abstract method which is declared in the abstract class Item is
	 * overrided so that The getType method returns the enum value corresponding
	 * to this item type
	 *
	 * @return will return a value of the type ItemType enum
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.MISC;
	}
}
