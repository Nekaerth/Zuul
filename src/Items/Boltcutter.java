package Items;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Boltcutter extends Item {

	private String roomBoltcutterCanBeUsedIn;

	/**
	 * The constructor for boltcutter takes 6 parameters
	 *
	 * @param pickup
	 * @param name
	 * @param useable
	 * @param weight
	 * @param capacity
	 * @param roomBoltcutterCanBeUsedIn
	 */
	public Boltcutter(boolean pickup, String name, boolean useable, int weight, int capacity, String roomBoltcutterCanBeUsedIn) {
		super(pickup, name, useable, weight, capacity);
		this.roomBoltcutterCanBeUsedIn = roomBoltcutterCanBeUsedIn;
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
	 * Returns a string that contains the name of the room that the boltcutter
	 * can be used in
	 *
	 * @return String
	 */
	public String getRoomBoltcutterCanBeUsedIn() {
		return roomBoltcutterCanBeUsedIn;
	}

}
