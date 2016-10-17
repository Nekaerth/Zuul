/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author niklasbruun
 */
public class Item {

	boolean pickUp;
	String name;
	boolean useable;
	private final int weight;
	int charges = 1;
        private final int itemCapacity;  

	public Item(boolean pickUp, String name, boolean useable, int weight, int itemCapacity) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
		this.weight = weight;
                this.itemCapacity = itemCapacity;
	}
	public Item(boolean pickUp, String name, boolean useable,int weight, int itemCapacity, int charges) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
		this.weight = weight;
		this.charges = charges;
                this.itemCapacity = itemCapacity;
	}

	public boolean getPickUp() {
		return pickUp;
	}

	public String getName() {
		return name;
	}

	public boolean getUseable() {
		return useable;
	}
		public int getCharges() {
		return this.charges;
	}
	
	public void subtractCharge(int subCharge){
		this.charges -= subCharge;
	}
	public int getWeight() {
		return this.weight;
        }
        public int getItemCapacity() {
                return this.itemCapacity;
        }
}
