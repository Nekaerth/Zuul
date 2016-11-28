package Items;


/**
 * An interface that can be used for items in the game. It contains methods that are required for the game to run.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public abstract class Item {
	
	private boolean pickup,useable;
	private String name;
	private int weight,capacity;

	public Item(boolean pickup, String name, boolean useable, int weight, int capacity){
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;	
		this.useable = useable;
	}
	
	public abstract ItemType getType();

	public String getName(){
		return this.name;
	}

	public boolean isPickup(){
		return this.pickup;
	}

	public boolean isUseable(){
		return this.useable;
	}

	public int getWeight(){
		return this.weight;
	}

	public int getCapacity(){
		return this.capacity;
	}

}