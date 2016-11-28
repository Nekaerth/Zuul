/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Items.Item;
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
				useKey(String direction
				);
				break;
			case FLASHLIGHT:
				useFlashlight(item);
				break;
			case BLUEPRINT:
				showAllRooms();
				System.out.println("You take a look at the blueprints of the prison and find a secret area behind your cell");
				player.inventory.removeItem(command.getSecondWord());
				break;
			case BOLTCUTTER:
				useBoltcutter(command);
				System.out.println("boltcutter test");
				break;
			default:
				break;
		}
	}

	@Override
	public void pickUp(Item item) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void drop(Item item) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

	@Override
	public void saveHighScore(String name, int highScore) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getHighScore() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getItemCapacity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getCurrentItemAmount() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getWeightCapacity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getCurrentWeight() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
