/**
 * The RoomSaver class is used to add rooms to an arraylist 
 * and add items to those rooms
 * 
 * @author Termprojectgroup 13 (autum 2016)
 */
package WorldLoader;

import Items.Item;
import MainPackage.*;
import java.util.ArrayList;

public class RoomSaver {

	ArrayList<Room> roomSaver;

        /**
         * The RoomSaver constructor initializes roomSaver as an
         * arraylist that contains rooms
         */
	public RoomSaver() {
		roomSaver = new ArrayList<>();
	}

        /**
         * The addRoom method is used to add a room to the roomSaver ArrayList
         * @param room is the room that is to be added. 
         */        
	public void addRoom(Room room) {
		roomSaver.add(room);
	}

        /**
         * The getRoom method is used to iterate through the roomSaver ArrayList
         * @param id is the id of the room you wish to get
         * @return if a room with the id is found it will return that room 
         * otherwise it will return null
         */
	public Room getRoom(String id) {
		for (Room r : roomSaver) {
			if (r.getId().equalsIgnoreCase(id)) {
				return r;
			}
		}
		return null;
	}

        /**
         * The addItem method is used to add items to a room
         * @param item the item parameter is the item to be added
         * @param roomID the roomID parameter is the room which the item is to be added to
         */
	public void addItem(Item item, String roomID) {
		for (Room r : roomSaver) {
			if (roomID.equalsIgnoreCase(r.getId())) {
				r.getInventory().putItem(item);
				return;
			}
		}
	}

        /**
         * The getAllRooms method is used to get the rommSaver ArrayList
         * @return will return the roomSaver ArrayList of rooms
         */
	public ArrayList<Room> getAllRooms() {
		return roomSaver;
	}
}
