package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class BoltCutter extends Item {

	private String roomBoltCutterCanBeUsedIn;

	/**
	 * The constructor for boltcutter takes 6 parameters
	 *
	 * @param pickup
	 * @param name
	 * @param useable
	 * @param weight
	 * @param capacity
	 * @param roomBoltCutterCanBeUsedIn
	 */
	public BoltCutter(boolean pickup, String name, boolean useable, int weight, int capacity, String roomBoltCutterCanBeUsedIn) {
		super(pickup, name, useable, weight, capacity);
		this.roomBoltCutterCanBeUsedIn = roomBoltCutterCanBeUsedIn;
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
		return ItemType.BOLTCUTTER;
	}

	/**
	 * Returns a string that contains the name of the room that the boltcutter can
	 * be used in
	 *
	 * @return String
	 */
	public String getRoomBoltCutterCanBeUsedIn() {
		return roomBoltCutterCanBeUsedIn;
	}

}
