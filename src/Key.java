
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Key implements Item {

	private boolean pickup, useable;
	private int weight, capacity;
	private String name;
        
        /**
         * The constructor for the Key class is called when we want to create objects
         * of the key class with a specific set of instace variables.
         * @param pickup is a boolean used to check if the item can be picked up
         * @param name is a String that refers to the name of the key
         * @param useable is a boolean used to check if the item can be used once you have picked it up
         * @param weight is an int that refers to the weight of the item
         * @param capacity is an int that refers to how much space it requires in the inventory
         */
	public Key(boolean pickup, String name, boolean useable, int weight, int capacity) {
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isWeapon method returns false if called to an object of the key class
         * @return will return a boolean as false
         */	
	@Override
	public boolean isWeapon() {
		return false;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isKey method returns true if called to an object of the key class
         * @return will return a boolean as true
         */
	@Override
	public boolean isKey() {
		return true;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isMisc method returns false if called to an object of the key class
         * @return will return a boolean as false
         */
	@Override
	public boolean isMisc() {
		return false;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isSpecial method returns false if called to an object of the key class
         * @return will return a boolean as false
         */
	@Override
	public boolean isSpecial() {
		return false;
	}

        /**
         * We override the instance method which is declare in the interface
         * The getName method returns the name of the weapon object
         * @return will return the name of the item in a String
         */
	@Override
	public String getName() {
		return this.name;
	}
/**
         * We override the instance method which is declare in the interface
         * The isPickup method returns the boolean value declared when creating the key object
         * @return will return a boolean equal to what is declared when creating the object
         */
	@Override
	public boolean isPickup() {
		return this.pickup;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isUseable method returns the boolean value declared when creating the key object
         * @return will return a boolean equal to what is declared when creating the object
         */
	@Override
	public boolean isUseable() {
		return this.useable;
	}

        /**
         * We override the instance method which is declare in the interface
         * The getWeight method returns the int value declared when creating the key object
         * @return will return an int equal to what is declared when creating the object
         */
	@Override
	public int getWeight() {
		return this.weight;
	}

        /**
         * We override the instance method which is declare in the interface
         * The getCapacity method returns the int value declared when creating the key object
         * @return will return a int equal to what is declared when creating the object
         */
	@Override
	public int getCapacity() {
		return this.capacity;
	}

        /**
         * We override the instance method which is declare in the interface
         * The isFlashlight method returns false if called to an object of the key class
         * @return will return a boolean as false
         */
	@Override
	public boolean isFlashlight() {
		return false;
	}

}
