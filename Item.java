package Items;

/**
 * An interface that can be used for items in the game. It contains methods that
 * are required for the game to run.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public abstract class Item {

	private boolean pickUpAble, useAble;
	private String name;
	private int weight, capacity;

	public Item(boolean pickup, String name, boolean useAble, int weight, int capacity) {
		this.pickUpAble = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useAble = useAble;
	}

	public abstract ItemType getItemType();

	public String getName() {
		return this.name;
	}

	public boolean isPickUpAble() {
		return this.pickUpAble;
	}

	public boolean isUseable() {
		return this.useAble;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
