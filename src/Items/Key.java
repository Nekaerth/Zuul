package Items;


/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Key extends Item {

	private String nameOfRoomThatFitsThisKey;
	

	/**
	 * The constructor for the Key class is called when we want to create objects
	 * of the key class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the key
	 * @param useable is a boolean used to check if the item can be used once you
	 * have picked it up
	 * @param weight is an int that refers to the weight of the item
	 * @param capacity is an int that refers to how much space it requires in the
	 * inventory
	 */
	public Key(boolean pickup, String name, boolean useable, int weight, int capacity, String nameOfRoomThatFitsThisKey) {
		super(pickup,name,useable,weight,capacity);
		this.nameOfRoomThatFitsThisKey = nameOfRoomThatFitsThisKey;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.KEY;
	}

	/**
	 * @return the nameOfRoomThatFitsThisKey
	 */
	public String getNameOfRoomThatFitsThisKey() {
		return nameOfRoomThatFitsThisKey;
	}
}