package Items;


/**
 * The Weapon class implements the interface Item
 * It is used to create weapons which is a specific type of items
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Weapon extends Item {


	private int damage;
	private WeaponType weaponType;

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
	public Weapon(boolean pickup, String name, boolean useable, int weight, int capacity, int damage, WeaponType weaponType) {
		super(pickup,name,useable,weight,capacity);
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
	public ItemType getType() {
		return ItemType.WEAPON;
	}

	/**
	 * The weaponType method returns the WeaponType declared when creating the weapon
	 * object
	 *
	 * @return will return a WeaponType enum equal to what is declared when creating the
	 * object
	 */
	public WeaponType weaponType() {
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
