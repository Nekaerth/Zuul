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

	public Item(boolean pickUp, String name, boolean useable) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
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
}
