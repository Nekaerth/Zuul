/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import MainPackage.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Danieln Johansen
 */
public class WorldLoader {

	roomContainment rc = new roomContainment();
	roomSaver rs = new roomSaver();
	boolean finishRoom = false;
	ArrayList<String> links = new ArrayList<>();

	public void loadWorld() {
		try {
			boolean createRoom = false, createItem = false;
			FileReader file;
			file = new FileReader("D:\\Programmerings Projekter\\ZuulOriginal\\src\\testfile.dne");
			BufferedReader buffer = new BufferedReader(file);

			while (buffer.ready()) {
				String evaluateString = buffer.readLine();

				if (createRoom) {
					createRoom = createRoom(evaluateString);
				} else if (createItem) {
					//createItem(evaluateString);
				}

				switch (evaluateString) {
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
						System.out.println("NOTHING");
						break;
				}
			}

		} catch (Exception e) {
			System.out.println("noget gik galt");

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
			Room room = new Room(rc.getId(), rc.getDescription(), rc.getNumberRoom(), rc.getLocked(), rc.getEscapeRoom(),rc.getName());
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
		do {
			for (String str : links) {
				linkMap = str.split("=");
				for (Room r : rs.getAllRooms()) {
					if (r.getId().equalsIgnoreCase(linkMap[0])) {
						mainRoom = r;
						links.remove(str);
						break;
					}

				}
			    break;

			}
			String[] values = linkMap[1].split(":");
			for (String str2 : values) {
				for (Room r2 : rs.getAllRooms()) {
					if (r2.getId().equalsIgnoreCase(str2)) {
						secondRoom = r2;
						System.out.println("connected rooms");
						mainRoom.setExit(secondRoom.getName(), secondRoom);
					}
				}
			}
		} while (links.size() > 0);
		return rs.getAllRooms();
	}

	private void createItem(String evaluateString) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
