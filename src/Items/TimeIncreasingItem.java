package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class TimeIncreasingItem extends Item {

	private final int time;

	/**
	 * the constructor for the class TimeIncreasingItem
	 *
	 * @param pickup is a boolean to determine if the item can be picked up
	 * @param name is a String that determine the name of the items
	 * @param useable is a boolean to determine if the item can be used
	 * @param time is an int to determine the time the item will add to the
	 * players time
	 */
	public TimeIncreasingItem(boolean pickup, String name, boolean useable, int time) {
		super(pickup, name, useable, 0, 0);
		this.time = time;
	}

	/**
	 * The abstract method which is declared in the abstract class Item is
	 * overrided so that The getType method returns the enum value corresponding
	 * to this item type
	 *
	 * @return
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.TIMEINCREASINGITEM;
	}

	/**
	 * Returns the amount of time in seconds as an int that this item contains
	 *
	 * @return int
	 */
	public int getTime() {
		return time;
	}

}
