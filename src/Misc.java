/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This method is for all the misc items that cant be picked up.
 * 
 * @return false so the item cant be picked up.
 */
public class Misc implements Item {
    private boolean pickup, useable;
	private int weight, capacity;
	private String name;
	public Misc (boolean pickup, String name, boolean useable){
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
		return false;
	}

	@Override
	public boolean isMisc() {
		return true;
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
		return 0;
	}

	@Override
	public int getCapacity() {
		return 0;
	}

	@Override
	public boolean isFlashlight() {
		return false;
	}
}
