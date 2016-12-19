package Items;

/**
 * The Weapon class implements the interface Item It is used to create weapons
 * which is a specific type of items
 *
 * @author Termproject Group 13 (Autumn 2016)
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
		super(pickup, name, useable, weight, capacity);
		this.damage = damage;
		this.weaponType = weaponType;
	}

	/**
	 * The abstract method which is declared in the abstract class Item is
	 * overrided so that The getType method returns the enum value corresponding
	 * to this item type
	 *
	 * @return ItemType
	 */
	@Override
	public ItemType getItemType() {
		return ItemType.WEAPON;
	}

	/**
	 * The weaponType method returns the WeaponType declared when creating the
	 * weapon object
	 *
	 * @return WeaponType
	 */
	public WeaponType weaponType() {
		return weaponType;
	}

	/**
	 * The getDamage method returns the int value declared when creating the
	 * weapon object
	 *
	 * @return int
	 */
	public int getDamage() {
		return damage;
	}

}
