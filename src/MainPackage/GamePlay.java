/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Items.Item;
import Items.ItemType;
import Items.Key;
import Items.TimeIncreasingItem;
import Items.Weapon;
import WorldLoader.WorldLoader;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Niklas
 */
public class GamePlay implements GUIdisplayable {

	private Player player;
	private ArrayList<Boss> bosses = new ArrayList<>();
	private ArrayList<Room> rooms = new ArrayList<>(); // initializes the rooms available
	private ArrayList<Room> roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number

	@Override
	public boolean goRoom(String direction) {

		Room nextRoom = player.getRoom().getExit(direction); //Finds the next room in the hashmap room and sets this as NextRoom

		if (nextRoom == null || nextRoom.isHidden()) { //Prints this if there is no room that direction / the hashmap doesnt contain the value of the key
			return false;
		} else if (!nextRoom.isLocked()) {

			player.subtractTime(10);

			if (!nextRoom.getEscapeRoom()) {
				player.setRoom(nextRoom); //Changes players current room to nextRoom.     
				return true;
			}

		} else if (nextRoom.isLocked()) {
			return false;
		}
		return false;

	}

	@Override
	public String getCurrentRoom() {
		return player.getRoom().getName();
	}

	@Override
	public ObservableList<Item> getCurrentRoomInventory() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void use(Item item) {
		if (item == null) {
			System.out.println("You don't have that item in your inventory");
			return;
		}
		if (!item.isUseable()) {//There are only 4 items that are useable. Either key, flashlight, blueprints or boltcutter
			return;
		}

		switch (item.getType()) {
			case KEY:
				useKey(item);
				break;
			case FLASHLIGHT:
				useFlashlight(item);
				break;
			case BLUEPRINT:
				showAllRooms();
				player.getInventory().removeItem(item.getName());
				break;
			case BOLTCUTTER:
				useBoltcutter(item);
				break;
			default:
				break;
		}
	}

	@Override
	public boolean pickUp(Item item) {
		if (item == null) {
			System.out.println("There is no such item.");
			return false;
		}

		if (item.isPickup()
				&& player.getInventory().itemWeight() + item.getWeight() <= player.getWeightCapacity()
				&& player.getInventory().size() + 1 <= player.getCapacity()) {

			switch (item.getType()) {
				case WEAPON:
					Weapon weapon = (Weapon) item;
					player.changePlayerMove(weapon);
					break;
				case TIMEINCREASINGITEM:
					if (item instanceof TimeIncreasingItem) {
						player.addTime(((TimeIncreasingItem) item).getTime());
						player.getRoom().getInventory().removeItem(item.getName());
						System.out.println("Your time to escape increased");
						return true;
					}
					break;
				default:
					break;
			}
			//Transfers the item from the room inventory to the player inventory
			player.getInventory().transferItem(player.getRoom().getInventory(), item);

		} else if (player.getInventory().itemWeight() + item.getWeight() > player.getWeightCapacity()) {
			return false;
		} else if (player.getInventory().size() + 1 > player.getCapacity()) {
			return false;
		}
		return true;
	}

	@Override
	public void drop(Item item) {
		if (item.getType() == ItemType.WEAPON) {
			player.droppedWeapon((Weapon) item);
		}
		//Transfers the item from the player inventory to the room inventory
		player.getRoom().getInventory().transferItem(player.getInventory(), item);
	}

	@Override
	public ObservableList<Item> getPlayerInventory() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getTime() {
		return player.getTime();
	}

	@Override
	public String getHelpDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("You wake up and realize there's a prisonriot going on. Now's your chance to escape!");
		sb.append("Hurry! you have limited time to escape, before the warden gets everything under control again.");
		sb.append("You got 20 minutes, 100 HP and your melee attack damage is 10");
		sb.append("Click help if you need help");
		return sb.toString();
	}

	@Override
	public void constructWorld(String fileToRead) {
		WorldLoader wl = new WorldLoader();
		this.rooms = wl.loadWorld(fileToRead);
		this.bosses = wl.loadBosses(fileToRead);
		player = new Player(rooms.get(0), 100, 1200, 3, 20); // creates a new object of the player class
		ArrayList<Move> moves = this.player.getMoves();
		moves.add(new Move(Attack.STAB, 10));
		moves.add(new Move(Attack.DUCK, 0));
		moves.add(new Move(Attack.JUMP, 0));
		moves.add(new Move(Attack.SIDESTEP, 0));

	}

	@Override
	public boolean isBossPresent() {
		for (Boss boss : bosses) {
			if (player.getRoom() == boss.getRoom()) {
				return true;
			}
		}
		return false;
	}

	private void useKey(Item item) {
		Key key = (Key) item;
		Room roomToUnlock;
		for (Room r : rooms) {
			if (key.getNameOfRoomThatFitsThisKey().toLowerCase().equals(r.getName().toLowerCase())) {
				roomToUnlock = r;
				break;
			}
		}
//Nået hertil fredag
		if (roomToUnlock.isLocked()) {
			nextRoom.unlock();
			System.out.println("You successfully unlock the door");
			player.getInventory().removeItem(command.getSecondWord());
		} else {
			System.out.println("The door is already unlocked"); //Prints this if you try to 'use key' any other place than a locked door.
		}

		if (nextRoom.isLocked() && nextRoom.getEscapeRoom()) {
			nextRoom.unlock();
			System.out.println("You opended up the fence to the parkinglot");
		}
	}

	private void useFlashlight(Item item) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void showAllRooms() {
		for (Room r : rooms) {
			r.setHidden(false);
		}
	}

	private void useBoltcutter(Item item) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
