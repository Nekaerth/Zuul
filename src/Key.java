/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danieln Johansen
 */
public class Key implements Item {
	private boolean key, weapon, misc, pickup, useable;
	private int weight, capacity;
	private String name;
	public Key(boolean pickup, String name, boolean useable, int weight, int capacity){
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
	}
	
	@Override
	public boolean isWeapon() {
		return false;
	}

	@Override
	public boolean isKey() {
		return true;
	}

	@Override
	public boolean isMisc() {
		return false;
	}
	@Override
	public boolean isSpecial(){
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isPickup() {
		return this.pickup;
	}
	
	@Override
	public boolean isUseable(){
		return this.useable;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public boolean isFlashlight() {
		return false;
	}
	
	
	
}
