package Items;

/**
 * An abstract class that can be used for items in the game.
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public abstract class Item {

	private boolean pickUpAble, useAble;
	private String name;
	private int weight, capacity;

	/**
	 * The constructor for the Abstract class item
	 *
	 * @param pickup
	 * @param name
	 * @param useAble
	 * @param weight
	 * @param capacity
	 */
	public Item(boolean pickup, String name, boolean useAble, int weight, int capacity) {
		this.pickUpAble = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useAble = useAble;
	}

	/**
	 * An abstract method
	 *
	 * @return
	 */
	public abstract ItemType getItemType();

	/**
	 * Returns the name of an item
	 *
	 * @return String The name of the item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns a boolean that is true if the item can be picked up and false if it
	 * cannot be picked up.
	 *
	 * @return boolean
	 */
	public boolean isPickUpAble() {
		return this.pickUpAble;
	}

	/**
	 * Returns a boolean that is true if the item can be used and false if it
	 * cannot be used
	 *
	 * @return boolean
	 */
	public boolean isUseable() {
		return this.useAble;
	}

	/**
	 * Returns the weight of the item as an int
	 *
	 * @return int
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Returns the capacity of the item as an int
	 *
	 * @return int
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Returns a string representation of a Item object. The string representation
	 * is the name of the item
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
