/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class NPC {

	private Room currentRoom;

	public NPC(Room startRoom) {
		this.currentRoom = startRoom;
	}

	public void move() {
		//40% chance of moving
		if ((int) (Math.random() * 100) + 1 > 60) {
			ArrayList<String> directions = currentRoom.getListOfExitDirections();
			int indexOfRandomRoom = (int) (Math.random() * directions.size());
			Room nextRoom = currentRoom.getExit(directions.get(indexOfRandomRoom));
			this.setCurrentRoom(nextRoom);
		}
	}

	public void interactWithPlayer(Player player) {
		if (player.getRoom().equals(currentRoom)) {
			player.subtractTime(40);
		}
	}

	/**
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}
