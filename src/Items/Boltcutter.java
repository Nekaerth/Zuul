/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author Niklas
 */
public class Boltcutter extends Item {

	private String roomBoltcutterCanBeUsedIn;

	public Boltcutter(boolean pickup, String name, boolean useable, int weight, int capacity, String roomBoltcutterCanBeUsedIn) {
		super(pickup, name, useable, weight, capacity);
		this.roomBoltcutterCanBeUsedIn = roomBoltcutterCanBeUsedIn;
	}

	@Override
	public ItemType getType() {
		return ItemType.BOLTCUTTER;
	}

	public String getRoomBoltcutterCanBeUsedIn() {
		return roomBoltcutterCanBeUsedIn;
	}

}
