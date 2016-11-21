/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import MainPackage.WeaponType;
import MainPackage.ItemType;

/**
 *
 * @author simon
 */
public class ItemContainment {

	private String id;
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * @param type the key to set
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
	 * @return the roomID
	 */
	public String getRoomID() {
		return roomId;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = Integer.parseInt(weight);
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = Integer.parseInt(capacity);
	}

	/**
	 * @return the pickup
	 */
	public boolean isPickup() {
		return pickup;
	}

	/**
	 * @param pickup the pickup to set
	 */
	public void setPickup(String pickup) {
		switch (pickup.toLowerCase()) {
			case "true":
				this.pickup = true;
				break;
			case "false":
				this.pickup = false;
				break;
			default:
				System.out.println("Error in pickup in");
		}
	}

	/**
	 * @return the useable
	 */
	public boolean isUseable() {
		return useable;
	}

	/**
	 * @param useable the useable to set
	 */
	public void setUseable(String useable) {
		switch (useable.toLowerCase()) {
			case "true":
				this.useable = true;
				break;
			case "false":
				this.useable = false;
				break;
			default:
				System.out.println("Error");

		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the charges
	 */
	public int getCharges() {
		return charges;
	}

	/**
	 * @param charges the charges to set
	 */
	public void setCharges(String charges) {
		this.charges = Integer.parseInt(charges);
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(String damage) {
		this.damage = Integer.parseInt(damage);
	}

	/**
	 * @return the weapontype
	 */
	public WeaponType getWeapontype() {
		return weaponType;
	}

	/**
	 * @param weapontype the weapontype to set
	 */
	public void setWeapontype(String weaponType) {
		weaponType = weaponType.toLowerCase();
		for (WeaponType w : WeaponType.values()) {
			if (weaponType.equalsIgnoreCase(w.toString())) {
				this.weaponType = w;
			}
		}
	}

}
