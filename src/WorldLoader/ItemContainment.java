/**
 * The ItemContainment class is used to set and return
 * the value of atributes related to items
 *
 * @author Termproject Group (Autumn 2016)
 */
package WorldLoader;

import Items.WeaponType;
import Items.ItemType;

public class ItemContainment {

	private ItemType type;
	private String roomId;
	private int weight;
	private int capacity;
	private boolean pickup;
	private boolean useable;
	private int charges;
	private String name;
	private int damage;
	private WeaponType weaponType;
	private int time;
	private String nameOfRoomThatFitsThisKey;
	private String roomBoltCutterCanBeUsedIn;

	/**
	 * The getType method is used to the the type of an item
	 *
	 * @return the type of the item
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * The setType method is used to set the type of an item
	 *
	 * @param type is the type that the item should be set to
	 */
	public void setType(String type) {
		type = type.toLowerCase();
		for (ItemType i : ItemType.values()) {
			if (type.equalsIgnoreCase(i.toString())) {
				this.type = i;
			}
		}
	}

	/**
	 * The getRoomID is used to get the roomID where an item is
	 *
	 * @return the roomID for an item
	 */
	public String getRoomID() {
		return roomId;
	}

	/**
	 * The setRoomID is used to set the roomId for an item
	 *
	 * @param roomId the roomID for an item
	 */
	public void setRoomID(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * The getWeight method is used to get the weight of an item
	 *
	 * @return the weight of the item
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * The setWeight method is used to set the weight of an item
	 *
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = Integer.parseInt(weight);
	}

	/**
	 * The getCapacity method is used to get the capacity of an item
	 *
	 * @return the capacity of the item
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * The setCapacity method is used to set the capacity of an item
	 *
	 * @param capacity the capacity of the item to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = Integer.parseInt(capacity);
	}

	/**
	 * The isPickup method is used to get the value of the boolean pickup
	 *
	 * @return the boolean pickup
	 */
	public boolean isPickup() {
		return pickup;
	}

	/**
	 * The setPickup method is used to set the boolean value of pickup
	 *
	 * @param pickup is the String that will set the value of the boolean
	 */
	public void setPickup(String pickup) {
		this.pickup = pickup.equalsIgnoreCase("true");
	}

	/**
	 * The isUseable method is used to get the value of the useable boolean
	 *
	 * @return the alue of the boolean useable
	 */
	public boolean isUseable() {
		return useable;
	}

	/**
	 * The setUseable method is used to set the value of the useable boolean
	 *
	 * @param useable is the String that will set the value of the boolean
	 */
	public void setUseable(String useable) {
		this.useable = useable.equalsIgnoreCase("true");
	}

	/**
	 * The getName method is used to get the name of an item
	 *
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setName method is used to set the name of an item
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The getCharges method is used to get the amount of charges
	 *
	 * @return the amount of charges
	 */
	public int getCharges() {
		return charges;
	}

	/**
	 * The setCharges methodd is used to set the amount of charges
	 *
	 * @param charges the charges to set
	 */
	public void setCharges(String charges) {
		this.charges = Integer.parseInt(charges);
	}

	/**
	 * The getDamage method is used to get the damage for an item
	 *
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * The setdamage is used to set the damage for an item
	 *
	 * @param damage the damage to set
	 */
	public void setDamage(String damage) {
		this.damage = Integer.parseInt(damage);
	}

	/**
	 * The getWeaponType is used to get the weaponType of an item
	 *
	 * @return the weapontype
	 */
	public WeaponType getWeapontype() {
		return weaponType;
	}

	/**
	 * The setWeaponType is used set the weaponType of an item
	 *
	 * @param weaponType is a String equal to a weaponType
	 */
	public void setWeapontype(String weaponType) {
		weaponType = weaponType.toLowerCase();
		for (WeaponType w : WeaponType.values()) {
			if (weaponType.equalsIgnoreCase(w.toString())) {
				this.weaponType = w;
			}
		}
	}

	/**
	 * The getTime method is used to get the time
	 *
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * The setTime method is used to set the time
	 *
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = Integer.parseInt(time);
	}

	/**
	 * The setNameOfRoomThatFitsThisKey method is used to set what room a key can
	 * be used in
	 *
	 * @param nameOfRoomThatFitsThisKey is the name of the room a key can be used
	 * in
	 */
	public void setNameOfRoomThatFitsThisKey(String nameOfRoomThatFitsThisKey) {
		this.nameOfRoomThatFitsThisKey = nameOfRoomThatFitsThisKey;
	}

	/**
	 * The getNameOfRoomThatFitsThisKey is used to get the String where a key can
	 * be used
	 *
	 * @return a String where a key can be used
	 */
	public String getNameOfRoomThatFitsThisKey() {
		return nameOfRoomThatFitsThisKey;
	}

	/**
	 * The getRoomBoltcutterCanBeUsedIn is used to get the String where a
	 * boltcutter can be used
	 *
	 * @return a String where a boltcutter can be used
	 */
	public String getRoomBoltCutterCanBeUsedIn() {
		return roomBoltCutterCanBeUsedIn;
	}

	/**
	 * The setRoomBoltcutterCanBeUsedIn is used to set where a boltcutter can be
	 * used
	 *
	 * @param roomBoltcutterCanBeUsedIn a String equal to the name of a room where
	 * the boltcutter can be used
	 */
	public void setRoomBoltCutterCanBeUsedIn(String roomBoltcutterCanBeUsedIn) {
		this.roomBoltCutterCanBeUsedIn = roomBoltcutterCanBeUsedIn;
	}

}
