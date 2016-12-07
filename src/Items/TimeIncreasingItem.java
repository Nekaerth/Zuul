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
	 * @param pickup
	 * @param name
	 * @param useable
	 * @param time
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
