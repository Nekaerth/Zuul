package MainPackage;

import java.util.ArrayList;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class NPC {

	private Room currentRoom;
	private String name;
	private boolean teleportedPlayerLastEncounter;
	private boolean subtractedTimeFromPlayerLastEncounter;

	/**
	 * The constructor for an NPC sets the starting room and the name
	 *
	 * @param startRoom
	 * @param name
	 */
	public NPC(Room startRoom, String name) {
		this.currentRoom = startRoom;
		this.name = name;
	}

	/**
	 * There is a 40% chance of moving the NPC to a new room every time this
	 * method is called
	 */
	public void move() {
		//40% chance of moving
		if ((int) (Math.random() * 100) + 1 > 60) {
			ArrayList<Direction> directions = currentRoom.getListOfExitDirections();
			int indexOfRandomRoom = (int) (Math.random() * directions.size());
			Room nextRoom = currentRoom.getExit(directions.get(indexOfRandomRoom));
			this.setCurrentRoom(nextRoom);
		}
	}

	/**
	 * Returns the room that the NPC is currently in
	 *
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * sets the room that the NPC is in
	 *
	 * @param currentRoom the currentRoom to set
	 */
	private void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
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
	 * @return the teleportedPlayerLastEncounter
	 */
	public boolean hasTeleportedPlayerLastEncounter() {
		return this.teleportedPlayerLastEncounter;
	}

	/**
	 * @param teleportedPlayerLastEncounter the teleportedPlayerLastEncounter to
	 * set
	 */
	public void setTeleportedPlayerLastEncounter(boolean teleportedPlayerLastEncounter) {
		this.teleportedPlayerLastEncounter = teleportedPlayerLastEncounter;
	}

	/**
	 * @return the subtractedTimeFromPlayerLastEncounter
	 */
	public boolean hasSubtractedTimeFromPlayerLastEncounter() {
		return subtractedTimeFromPlayerLastEncounter;
	}

	/**
	 * @param subtractedTimeFromPlayerLastEncounter the
	 * subtractedTimeFromPlayerLastEncounter to set
	 */
	public void setSubtractedTimeFromPlayerLastEncounter(boolean subtractedTimeFromPlayerLastEncounter) {
		this.subtractedTimeFromPlayerLastEncounter = subtractedTimeFromPlayerLastEncounter;
	}
}
