/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import MainPackage.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Danieln Johansen
 */
public class WorldLoader {

	RoomContainment rc = new RoomContainment();
	RoomSaver rs = new RoomSaver();
	boolean finishRoom = false;
	boolean finishItem = false;
	boolean finishBoss = false;
	ArrayList<Boss> bosses = new ArrayList<>();
	ArrayList<String> links = new ArrayList<>();
	ItemContainment ic = new ItemContainment();
	BossContainment bossC = new BossContainment();

	public void loadWorld() {
		try {
			boolean createRoom = false, createItem = false;
			FileReader file;
			file = new FileReader("testfile.dne");
			BufferedReader buffer = new BufferedReader(file);

			while (buffer.ready()) {
				String evaluateString = buffer.readLine();
				if (createRoom) {
					createRoom = createRoom(evaluateString);

				} else if (createItem) {
					createItem = createItem(evaluateString);
				}

				switch (evaluateString.toLowerCase()) {
					case "[room]":
						System.out.println("room");
						createRoom = true;
						createItem = false;
						break;
					case "[item]":
						System.out.println("ITEM");
						createRoom = false;
						createItem = true;
						break;
					default:
						break;
				}
			}

		} catch (Exception e) {
			System.out.println("noget gik galt");
			System.out.println(e);

		}

	}

	private boolean createRoom(String evaluateString) {
		String[] strings = evaluateString.split("=");
		int length = strings.length;
		for (String s : strings) {
			switch (s) {
				case "id":
					rc.setId(strings[length - 1]);
					break;
				case "name":
					rc.setName(strings[length - 1]);
					break;
				case "description":
					rc.setDescription(strings[length - 1]);
					break;
				case "locked":
					rc.setLocked(strings[length - 1]);
					break;
				case "escapeRoom":
					rc.setEscapeRoom(strings[length - 1]);
					break;
				case "numberRoom":
					rc.setNumberRoom(strings[length - 1]);
					break;
				case "hidden":
					rc.setHidden(strings[length - 1]);
					break;
				case "linkedID":
					String[] linkStrings = strings[length - 1].split(":");
					rc.setLinkedID(linkStrings);
					finishRoom = true;
					break;
				default:
					break;
			}
		}
		if (finishRoom) {
			Room room = new Room(rc.getId(), rc.getDescription(), rc.getNumberRoom(), rc.getLocked(), rc.getEscapeRoom(), rc.getName(), rc.isHidden());
			rs.addRoom(room);
			buildLinkString();
			finishRoom = false;
			rc.flush();
			return false;
		}
		return true;
	}

	public ArrayList<Room> connectWorld() {
		Room mainRoom = null, secondRoom = null;
		String[] linkMap = {""};
		do { //Iterate through the arraylist links
			for (String str : links) { //Split every string in links at "=" and save the strings into linkmap
				//links consist of a string of the format "mainroomID=roomToConnectID:roomToConnectID:.."
				//This will generate two strings "mainroomID" and "roomToConnectID:roomToConnectID:.."
				linkMap = str.split("="); //For each iteration through links, iterate through all the rooms saved in RoomSaver
				for (Room r : rs.getAllRooms()) { //Compare the id of a room with the id that is the mainroom saved in linkMap
					if (r.getId().equalsIgnoreCase(linkMap[0])) { //Set r as the mainroom
						mainRoom = r; //remove the string from the arraylist links
						links.remove(str); //Break out of the for each loop
						break;
					}

				} //break out of the outer for each loop
				break;

			} //Split the second string in linkMap at each ":" and save it into the array values, the second string consists of "roomToConnectID:roomToConnectID:.."
			String[] values = linkMap[1].split(":"); //Iterate through the array called values
			for (String str2 : values) { //For each iteration through values, iterate through the rooms saved in RoomSaver
				for (Room r2 : rs.getAllRooms()) { //Compare the id of a room with the string from values. The string from values consist of a "roomToConnectID" string
					if (r2.getId().equalsIgnoreCase(str2)) { //If true, set the room as the secondRoom
						secondRoom = r2; //Print out a confirmation message to the console
						System.out.println("connected rooms"); //connect the mainroom and the secondroom by calling the setExit() method on mainRoom
						mainRoom.setExit(secondRoom.getName(), secondRoom);
					}
				}
			} //Do this while there are still links left in the links array
		} while (links.size() > 0); //Return an arraylist of all the rooms saved in RoomSaver
		return rs.getAllRooms();
	}

	private boolean createItem(String evaluateString) {
		String[] strings = evaluateString.split("=");
		int length = strings.length;
		for (String a : strings) {
			switch (a) {
				case "id":
					ic.setId(strings[length - 1]);
					break;
				case "type":
					ic.setType(strings[length - 1]);
					break;
				case "roomID":
					ic.setRoomID(strings[length - 1]);
					break;
				case "weight":
					ic.setWeight(strings[length - 1]);
					break;
				case "capacity":
					ic.setCapacity(strings[length - 1]);
					break;
				case "pickup":
					ic.setPickup(strings[length - 1]);
					break;
				case "useable":
					ic.setUseable(strings[length - 1]);
					break;
				case "charges":
					ic.setCharges(strings[length - 1]);
					break;
				case "name":
					ic.setName(strings[length - 1]);
					finishItem = true;
					break;
			}
		}
		if (finishItem) {
			switch (ic.getType()) {
				case FLASHLIGHT:
					Flashlight flashlight = new Flashlight(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity(), ic.getCharges());
					rs.addItem(flashlight, ic.getRoomID());
					break;
				case KEY:
					Key key = new Key(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity());
					rs.addItem(key, ic.getRoomID());
					break;
				case MISC:
					Misc misc = new Misc(ic.isPickup(), ic.getName(), ic.isUseable());
					rs.addItem(misc, ic.getRoomID());
					break;
				case BLUEPRINT:
					Blueprint blueprint = new Blueprint(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity());
					rs.addItem(blueprint, ic.getRoomID());
					break;
				case WEAPON:
					Weapon weapon = new Weapon(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity(), ic.getDamage(), ic.getWeapontype());
					rs.addItem(weapon, ic.getRoomID());
					break;
			}
			finishItem = false;
			ic.flush();
			return false;
		}
		return true;
	}

	private void buildLinkString() {
		StringBuilder sb = new StringBuilder();
		sb.append(rc.getId());
		sb.append("=");
		for (String str : rc.getLinkedID()) {
			sb.append(str);
			sb.append(":");
		}
		links.add(sb.toString());

	}

	public ArrayList<Boss> loadBosses() {
		try {
			boolean createBoss = false;
			FileReader file;
			file = new FileReader("bossfile.dne");
			BufferedReader buffer = new BufferedReader(file);

			while (buffer.ready()) {
				String evaluateString = buffer.readLine();
				if (createBoss) {
					createBoss = createBoss(evaluateString);
				}

				switch (evaluateString.toLowerCase()) {
					case "[boss]":
						System.out.println("boss");
						createBoss = true;
						break;
					default:
						break;
				}
			}

		} catch (Exception e) {
			System.out.println("noget gik galt");
			System.out.println(e);

		}
		return this.bosses;

	}

	private boolean createBoss(String evaluateString) {
		String[] strings = evaluateString.split("=");
		int length = strings.length;
		for (String s : strings) {
			switch (s.toLowerCase()) {
				case "roomid":
					bossC.setRoomId(strings[length - 1]);
					break;
				case "hitpoints":
					bossC.setHitpoints(strings[length - 1]);
					break;
				case "bosstype":
					bossC.setBossType(strings[length - 1]);
					break;
				case "name":
					bossC.setName(strings[length - 1]);
					finishBoss = true;
					break;
				default:
					break;
			}
		}
		if(finishBoss){
			Boss boss = new Boss(rs.getRoom(bossC.getRoomId()),bossC.getHitpoints(), bossC.getName(), bossC.getBossType());
			bosses.add(boss);
			bossC.flush();
			finishBoss = false;
			return false;			
		}
		return true;
	}
}
