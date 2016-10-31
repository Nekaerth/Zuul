
/**
 * The Weapon class implements the interface Item
 * It is used to create weapons which is a specific type of items
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Weapon implements Item {

	private boolean pickup, useable;
	private int weight, capacity, damage;
	private String name, weaponType;

	/**
	 * The constructor for the Weapon class is called when we want to create
	 * objects of the weapon class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the weapon
	 * @param useable is a boolean used to check if the item can be used once you
	 * have picked it up
	 * @param weight is an int that refers to the weight of the item
	 * @param capacity is an int that refers to how much space it requires in the
	 * inventory
	 * @param damage is an int that refers to how much damage you deal to bosses
	 * while wielding this weapon
	 * @param weaponType is a String that refers to the type e.g. ranged or melee
	 */
	public Weapon(boolean pickup, String name, boolean useable, int weight, int capacity, int damage, String weaponType) {
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
		this.damage = damage;
		this.weaponType = weaponType;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getType method returns the enum value corresponding to this item type
	 *
	 * @return will return a value of the type ItemType enum 
	 */
	@Override
	public ItemType getType(){
		return ItemType.WEAPON;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getName method returns the name of the weapon object
	 *
	 * @return will return the name of the item in a String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * isPickup method returns the boolean value declared when creating the weapon
	 * object
	 *
	 * @return will return a boolean equal to what is declared when creating the
	 * object
	 */
	@Override
	public boolean isPickup() {
		return this.pickup;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * isUseable method returns the boolean value declared when creating the
	 * weapon object
	 *
	 * @return will return a boolean equal to what is declared when creating the
	 * object
	 */
	@Override
	public boolean isUseable() {
		return this.useable;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getWeight method returns the int value declared when creating the weapon
	 * object
	 *
	 * @return will return an int equal to what is declared when creating the
	 * object
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getCapacity method returns the int value declared when creating the weapon
	 * object
	 *
	 * @return will return a int equal to what is declared when creating the
	 * object
	 */
	@Override
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * The weaponType method returns the String declared when creating the weapon
	 * object
	 *
	 * @return will return a String equal to what is declared when creating the
	 * object
	 */
	public String weaponType() {
		return weaponType;
	}

	/**
	 * The getDamage method returns the int value declared when creating the
	 * weapon object
	 *
	 * @return will return an int equal to what is declared when creating the
	 * object
	 */
	public int getDamage() {
		return damage;
	}

}
