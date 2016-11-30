/*
 * Facade class that is used to connect the frontend(GUI) and backend
 */
package MainPackage;

import HighscoreLoader.Highscore;
import Items.Blueprint;
import Items.Boltcutter;
import Items.Flashlight;
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
	private NPC npc;
	private ArrayList<Boss> bosses = new ArrayList<>();
	private ArrayList<Room> rooms = new ArrayList<>(); // initializes the rooms available
	private ArrayList<Room> roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number

	/**
	 * The goRoom method is used to change the room the player is in based on
	 * the direction that is given
	 *
	 * @param direction is a String used to determine where the player is going
	 * @return boolean false if the player did not move and returns true if the
	 * player moved
	 */
	@Override
	public boolean goRoom(String direction) {

		Room nextRoom = player.getRoom().getExit(direction); //Finds the next room in the hashmap room and sets this as NextRoom

		if (nextRoom == null || nextRoom.isHidden()) { //Prints this if there is no room that direction / the hashmap doesnt contain the value of the key
			return false;
		} else if (!nextRoom.isLocked()) {

			player.subtractTime(10);

			if (!nextRoom.getEscapeRoom()) {
				player.setRoom(nextRoom); //Changes players current room to nextRoom.
				npc.move();
				npc.interactWithPlayer(player);
				return true;
			}

		} else if (nextRoom.isLocked()) {
			return false;
		}
		return false;

	}

	/**
	 * The getCurrentRoom returns the room that the player is currently in
	 *
	 * @return an object of Room
	 */
	@Override
	public Room getCurrentRoom() {
		return player.getRoom();
	}

	/**
	 * The getCurrentRoomInventory returns the inventory of the room the player
	 * is in
	 *
	 * @return an ObservableList of items
	 */
	@Override
	public ObservableList<Item> getCurrentRoomInventory() {
		return player.getRoom().getInventory().getAllItems();
	}

	/**
	 * The use method uses a specified item the outcome of the action depends on
	 * the item type
	 *
	 * @param item is the Item which is to be used
	 */
	@Override
	public boolean use(Item item) {
		if (item == null) {
			System.out.println("You don't have that item in your inventory");
			return false;
		}
		if (!item.isUseable()) {//There are only 4 items that are useable. Either key, flashlight, blueprints or boltcutter
			return false;
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
				player.getInventory().removeItem(item);
				break;
			case BOLTCUTTER:
				useBoltcutter(item);
				break;
			default:
				break;
		}
		return true;
	}

	/**
	 * The pickUp method is used to pick up a specific item, the action depends
	 * on the item type
	 *
	 * @param item is the item to be picked up
	 * @return a boolean as false if an item is not picked up, returns true of
	 * an item is picked up
	 */
	@Override
	public boolean pickUp(Item item) {
		if (item == null) {
			System.out.println("There is no such item.");
			return false;
		}

		if (item.isPickup()
				&& player.getInventory().getItemWeight() + item.getWeight() <= player.getWeightCapacity()
				&& player.getInventory().size() + 1 <= player.getCapacity()) {

			switch (item.getType()) {
				case WEAPON:
					Weapon weapon = (Weapon) item;
					player.changePlayerMove(weapon);
					break;
				case TIMEINCREASINGITEM:
					if (item instanceof TimeIncreasingItem) {
						player.addTime(((TimeIncreasingItem) item).getTime());
						player.getRoom().getInventory().removeItem(item);
						return true;
					}
					break;
				default:
					break;
			}
			//Transfers the item from the room inventory to the player inventory
			player.getInventory().transferItem(player.getRoom().getInventory(), item);

		} else if (player.getInventory().getItemWeight() + item.getWeight() > player.getWeightCapacity()) {
			return false;
		} else if (player.getInventory().size() + 1 > player.getCapacity()) {
			return false;
		}
		return true;
	}

        /**
         * The drop method is used to remove an item from the players inventory and add it to the rooms inventory
         * @param item is the item to be transfered to the rooms inventory from the players inventory
         */
	@Override
	public void drop(Item item) {
		if (item.getType() == ItemType.WEAPON) {
			player.droppedWeapon((Weapon) item);
		}
		//Transfers the item from the player inventory to the room inventory
		player.getRoom().getInventory().transferItem(player.getInventory(), item);
	}

        /**
         * The getPlayerInventory method will return all item in the players inventory
         * @return will return a list of items 
         */
	@Override
	public ObservableList<Item> getPlayerInventory() {
		return player.getInventory().getAllItems();

	}

        /**
         * The getTime method is used to return the amount of time the player has
         * @return will return an int equal to the amount of time left
         */
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
		npc = new NPC(rooms.get(rooms.size() - 1));
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
		Room roomToUnlock = new Room("", "", false, false, false, "", false);
		for (Room r : rooms) {
			if (key.getNameOfRoomThatFitsThisKey().toLowerCase().equals(r.getName().toLowerCase())) {
				roomToUnlock = r;
				break;
			}
		}
		if (roomToUnlock.isLocked()) {
			roomToUnlock.unlock();
			System.out.println("You successfully unlock the door");
			player.getInventory().removeItem(item);
		} else {
			System.out.println("The door is already unlocked"); //Prints this if you try to 'use key' any other place than a locked door.
		}
	}

	private void useFlashlight(Item item) {
		Flashlight flashlight = (Flashlight) item; //Uses up charges on players flashlight, and prints line below telling you how many charges you have left.
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			if (player.getRoom().isNumberRoom()) {
				player.getRoom().getNumber();
				if (roomNumber.contains(player.getRoom()) == false) { //add a room to the arraylist roomNumber, that tracks the rooms with numbers in them
					roomNumber.add(player.getRoom());
				}
			}
		}
	}

	private void showAllRooms() {
		for (Room r : rooms) {
			r.setHidden(false);
		}
	}

	private void useBoltcutter(Item item) {
		Boltcutter boltcutter = (Boltcutter) item;
		Room roomToUnlock = new Room("", "", false, false, false, "", false);
		for (Room r : rooms) {
			if (boltcutter.getRoomBoltcutterCanBeUsedIn().toLowerCase().equals(r.getName().toLowerCase())) {
				roomToUnlock = r;
				if (roomToUnlock.getEscapeRoom() && roomToUnlock.isLocked()) {
					roomToUnlock.unlock();
					player.getInventory().removeItem(item);
				}
			}
		}

			if (!roomToUnlock.getEscapeRoom() && roomToUnlock.isLocked()) {
				System.out.println("You got no use of the boltcutter here");
			} else if (roomToUnlock.getEscapeRoom() && !roomToUnlock.isLocked()) {
				System.out.println("You have allready opended the fence");
				System.out.println("Get out of here with the code");
			}
		
	}

		@Override
		public void saveHighScore
		(String name, int highScore
		
			) {
		StringBuilder sb = new StringBuilder();
			sb.append(name);
			sb.append(" ");
			sb.append(highScore);
			Highscore.saveHighscore(sb.toString());
		}

		@Override
		public int getHighScore
		
			() {
		return Highscore.calculateScore(player.getTime(), player.getBossKill());
		}

		@Override
		public int getItemCapacity
		
			() {
		return player.getCapacity();
		}

		@Override
		public int getCurrentItemAmount
		
			() {
		return player.getInventory().getItemCapacity();
		}

		@Override
		public int getWeightCapacity
		
			() {
		return player.getWeightCapacity();
		}

		@Override
		public int getCurrentWeight
		
			() {
		return player.getInventory().getItemWeight();
		}
	}
