/*
 * Facade class that is used to connect the frontend(GUI) and backend
 */
package MainPackage;

import HighscoreLoader.Highscore;
import Items.Boltcutter;
import Items.Flashlight;
import Items.Item;
import Items.ItemType;
import Items.Key;
import Items.TimeIncreasingItem;
import Items.Weapon;
import Items.WeaponType;
import WorldLoader.WorldLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Niklas
 */
public class GamePlay implements GUIdisplayable {

	private Player player;
	private ArrayList<NPC> npc;
	private ArrayList<Boss> bosses;
	private ArrayList<Room> rooms; // initializes the rooms available
	private ArrayList<Room> roomNumber; //An arraylist of rooms that contains a hidden number
	private ArrayList<Room> visitedRooms;
	private Highscore highscore;

	public GamePlay() {
		this.highscore = new Highscore();
		this.bosses = new ArrayList<>();
		this.rooms = new ArrayList<>(); // initializes the rooms available
		this.roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number
		this.visitedRooms = new ArrayList<>();
		this.npc = new ArrayList<>();
	}

	/**
	 * The goRoom method is used to change the room the player is in based on the
	 * direction that is given
	 *
	 * @param direction is a String used to determine where the player is going
	 * @return boolean false if the player did not move and returns true if the
	 * player moved
	 */
	@Override
	public boolean goRoom(String direction) {

		Room nextRoom = player.getRoom().getExit(direction); //Finds the next room in the hashmap room and sets this as NextRoom

		if (nextRoom == null || nextRoom.isHidden() || nextRoom.isLocked()) { //Prints this if there is no room that direction / the hashmap doesnt contain the value of the key
			return false;
		} else if (!nextRoom.isLocked()) {

			player.subtractTime(10);
			if (!visitedRooms.contains(nextRoom)) {
				visitedRooms.add(nextRoom);
			}

			player.setRoom(nextRoom); //Changes players current room to nextRoom.
			for (NPC n : npc) {
				n.move();
			}
			npcInteractWithPlayer();
			return true;

		}
		return false;

	}

	private void npcInteractWithPlayer() {
		for (NPC n : npc) {
			if (player.getRoom().equals(n.getCurrentRoom())) {
				player.subtractTime(50);
				if ((int) (Math.random() * 100) + 1 > 50) {
					int indexOfRandomRoom = (int) (Math.random() * (visitedRooms.size() - 1));
					player.setRoom(visitedRooms.get(indexOfRandomRoom));
				}
			}
		}
	}

	/**
	 * The getCurrentRoom returns the room that the player is currently in
	 *
	 * @return an object of Room
	 */
	/**
	 * The getCurrentRoomInventory returns the inventory of the room the player is
	 * in
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
	 * @return
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

		switch (item.getItemType()) {
			case KEY:
				return useKey(item);
			case FLASHLIGHT:
				useFlashlight(item);
				break;
			case BLUEPRINT:
				showAllRooms();
				player.getInventory().removeItem(item);
				break;
			case BOLTCUTTER:
				return useBoltcutter(item);
			default:
				break;
		}
		return true;
	}

	/**
	 * The pickUp method is used to pick up a specific item, the action depends on
	 * the item type
	 *
	 * @param item is the item to be picked up
	 * @return a boolean as false if an item is not picked up, returns true of an
	 * item is picked up
	 */
	@Override
	public boolean pickUp(Item item) {
		if (item == null) {
			return false;
		}

		if (item.isPickUpAble()
						&& player.getInventory().getItemWeight() + item.getWeight() <= player.getMaxWeight()
						&& player.getInventory().size() + 1 <= player.getItemCapacity()) {

			switch (item.getItemType()) {
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
			return true;
		} else if (player.getInventory().getItemWeight() + item.getWeight() > player.getMaxWeight()) {
			return false;
		} else if (player.getInventory().size() + 1 > player.getItemCapacity()) {
			return false;
		} else {
			return false;
		}

	}

	/**
	 * The drop method is used to remove an item from the players inventory and
	 * add it to the rooms inventory
	 *
	 * @param item is the item to be transfered to the rooms inventory from the
	 * players inventory
	 */
	@Override
	public void drop(Item item) {
		if (item.getItemType() == ItemType.WEAPON) {
			player.droppedWeapon((Weapon) item);
		}
		//Transfers the item from the player inventory to the room inventory
		player.getRoom().getInventory().transferItem(player.getInventory(), item);
	}

	/**
	 * The getPlayerInventory method will return all item in the players inventory
	 *
	 * @return will return a list of items
	 */
	/**
	 * The getTime method is used to return the amount of time the player has
	 *
	 * @return will return an int equal to the amount of time left
	 */
	@Override
	public int getTime() {
		return player.getTime();
	}

	@Override
	public String getHelpDescription() {
		try {
			FileReader file = new FileReader("helpfile.dne");
			BufferedReader buffer = new BufferedReader(file);
			StringBuilder sb = new StringBuilder();
			while (buffer.ready()) {
				sb.append(buffer.readLine());
				sb.append("\n");
			}
			return sb.toString();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
		}
		return " ";
	}

	@Override
	public void constructWorld(String fileToRead) {
		WorldLoader wl = new WorldLoader();
		this.rooms = wl.loadWorld(fileToRead);
		this.bosses = wl.loadBosses(fileToRead);
		player = new Player(rooms.get(0), 100, 1200, 3, 20); // creates a new object of the player class
		npc.add(new NPC(rooms.get(rooms.size() - 1)));
		ArrayList<Move> moves = this.player.getMoves();
		moves.add(new Move(10, Attack.STAB, WeaponType.RANGED));
		moves.add(new Move(0, Attack.DUCK, WeaponType.MELEE));
		moves.add(new Move(0, Attack.JUMP, WeaponType.MELEE));
		moves.add(new Move(0, Attack.SIDESTEP, WeaponType.MELEE));
	}

	private boolean useKey(Item item) {
		Key key = (Key) item;
		Room roomToUnlock = new Room("", "", false, false, false, "", false);
		for (Room r : rooms) {
			if (key.getNameOfRoomThatFitsThisKey().toLowerCase().equals(r.getName().toLowerCase())) {
				roomToUnlock = r;
				if (roomToUnlock.isLocked()) {
					roomToUnlock.unlock();
					player.getInventory().removeItem(item);
					return true;
				}
			}
		}
		return false;
	}

	private void useFlashlight(Item item) {
		Flashlight flashlight = (Flashlight) item; //Uses up charges on players flashlight, and prints line below telling you how many charges you have left.
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			if (player.getRoom().hasEscapeCode()) {
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

	private boolean useBoltcutter(Item item) {
		Boltcutter boltcutter = (Boltcutter) item;
		Room roomToUnlock = new Room("", "", false, false, false, "", false);
		for (Room room : rooms) {
			for (String str : room.getListOfExitDirections()) {
				if (boltcutter.getRoomBoltcutterCanBeUsedIn().equalsIgnoreCase(room.getExit(str).getName())) {
					roomToUnlock = room.getExit(str);
					if (roomToUnlock.isEscapeAbleRoom() && roomToUnlock.isLocked()) {
						roomToUnlock.unlock();
						player.getInventory().removeItem(item);
						return true;
					} else if (!roomToUnlock.isEscapeAbleRoom() && roomToUnlock.isLocked()) {
						System.out.println("You got no use of the boltcutter here");
						return false;
					} else if (roomToUnlock.isEscapeAbleRoom() && !roomToUnlock.isLocked()) {
						System.out.println("You have allready opended the fence");
						System.out.println("Get out of here with the code");
						return false;
					}
					break;
				}
			}
		}
		return false;
	}

	@Override
	public void saveHighScore(String name, int highScore) {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" ");
		sb.append(highScore);
		highscore.saveHighscore(sb.toString());
	}

	@Override
	public ObservableList<String> getHighScoreList() {
		return highscore.getHighscoreList();
	}

	@Override
	public int getHighScore() {
		return Highscore.calculateScore(player.getTime(), player.getAmountOfBossKill());
	}

	@Override
	public ArrayList<NPC> getAllNpc() {
		return npc;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public ArrayList<Boss> getBosses() {
		return bosses;
	}
}
