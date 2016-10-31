/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Misc implements Item {

	private boolean pickup, useable;
	private String name;

	/**
	 * The constructor for the Weapon class is called when we want to create
	 * objects of the misc class with a specific set of instace variables.
	 *
	 * @param pickup is a boolean used to check if the item can be picked up
	 * @param name is a String that refers to the name of the misc
	 * @param useable is a boolean used to check if the item can be used once you
	 * have picked it up
	 */
	public Misc(boolean pickup, String name, boolean useable) {
		this.pickup = pickup;
		this.name = name;
		this.useable = useable;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getType method returns the enum value corresponding to this item type
	 *
	 * @return will return a value of the type ItemType enum 
	 */
	@Override
	public ItemType getType(){
		return ItemType.MISC;
	}


	/**
	 * We override the instance method which is declare in the interface The
	 * getName method returns the name of the misc object
	 *
	 * @return will return the name of the item in a String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * isPickup method returns the boolean value declared when creating the misc
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
	 * isUseable method returns the boolean value declared when creating the misc
	 * object
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
	 * getWeight method returns 0 as an int when called on an object of the misc
	 * class
	 *
	 * @return will return 0 as an int
	 */
	@Override
	public int getWeight() {
		return 0;
	}

	/**
	 * We override the instance method which is declare in the interface The
	 * getCapacity method returns 0 as an int when called on an object of the misc
	 * class
	 *
	 * @return will return 0 as an int
	 */
	@Override
	public int getCapacity() {
		return 0;
	}

}
