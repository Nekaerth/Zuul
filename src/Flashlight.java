/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danieln Johansen
 */
public class Flashlight implements Item {

	private boolean pickup, useable;
	private int weight, capacity, charges;
	private String name;

	public Flashlight(boolean pickup, String name, boolean useable, int weight, int capacity, int charges) {
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
		this.charges = charges;
	}

	@Override
	public boolean isWeapon() {
		return false;
	}

	@Override
	public boolean isKey() {
		return false;
	}
	@Override
	public boolean isFlashlight(){
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
	public boolean isUseable() {
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
	
	public int getCharges(){
		return this.charges;
		
	}
	public void subtractCharge(int subCharge) {

		this.charges -= subCharge;
	}

	

}
