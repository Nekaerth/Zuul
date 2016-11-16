/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import MainPackage.*;
import java.util.ArrayList;

/**
 *
 * @author Danieln Johansen
 */
public class roomSaver {

    ArrayList<Room> roomSaver;

    public roomSaver() {
        roomSaver = new ArrayList<>();
    }

    public void addRoom(Room room) {
        roomSaver.add(room);
    }

    public Room getRoom(String id) {
        for (Room r : roomSaver) {
            if (r.getId().equalsIgnoreCase(id)) {
                return r;
            }
        }
        return null;
    }

    public void addItem(Item item, String roomID) {
        for (Room r : roomSaver) {
            if (roomID.equalsIgnoreCase(r.getId())) {
                r.getInventory().putItem(item.getName(), item);
                return;
            }
            
        }
        System.out.println("Item not added, "+item.getName());
    }

    public ArrayList<Room> getAllRooms() {
        return roomSaver;
    }
}
