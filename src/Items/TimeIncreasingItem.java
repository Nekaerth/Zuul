/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author simon
 */
public class TimeIncreasingItem extends Item {

	private int time;

	public TimeIncreasingItem(boolean pickup, String name, boolean useable, int time) {
		super(pickup, name, useable, 0, 0);
		this.time = time;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.TIMEINCREASINGITEM;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

}
