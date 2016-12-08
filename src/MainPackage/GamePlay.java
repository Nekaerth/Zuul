/*
 * Facade class that is used to connect the frontend(GUI) and backend
 */
package MainPackage;

import HighscoreLoader.Highscore;
import HighscoreLoader.Score;
import Items.Boltcutter;
import Items.Flashlight;
import Items.Item;
import Items.ItemType;
import Items.Key;
import Items.TimeIncreasingItem;
import Items.Weapon;
import Items.WeaponType;
import WorldLoader.WorldLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class GamePlay implements GUIdisplayable {

    private Player player;
    private ArrayList<NPC> npc;
    private ArrayList<Boss> bosses;
    private ArrayList<Room> rooms; // initializes the rooms available
    private ArrayList<Room> roomNumber; //An arraylist of rooms that contains a hidden number
    private ArrayList<Room> visitedRooms;
    private Highscore highscore;

    /**
     * The constructor for gameplay initialises the game
     */
    public GamePlay() {
        this.highscore = new Highscore();
        this.bosses = new ArrayList<>();
        this.rooms = new ArrayList<>(); // initializes the rooms available
        this.roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number
        this.visitedRooms = new ArrayList<>();
        this.npc = new ArrayList<>();
    }

    /**
     * The goRoom method is used to change the room the player is in based on
     * the direction that is given
     *
     * @param direction is a Direction used to determine where the player is
     * going
     * @return boolean false if the player did not move and returns true if the
     * player did move
     */
    @Override
    public boolean goRoom(Direction direction) {

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
                npcInteractWithPlayer();
            }                   
            return true;
        }
        return false;

    }

    /**
     * This method checks whether any NPC's are in the same room as the player,
     * and if so the player has a chance to be teleported
     */
    private void npcInteractWithPlayer() {
        for (NPC n : npc) {
            if (player.getRoom().equals(n.getCurrentRoom())) {
                player.subtractTime(50);
                if ((int) (Math.random() * 100) + 1 > 50) {
                    int indexOfRandomRoom = (int) (Math.random() * (visitedRooms.size() - 1));
                    player.setRoom(visitedRooms.get(indexOfRandomRoom));
                } if ((int) (Math.random() * 100) +1 > 50)
                    player.addTime(60);
            }
        }
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
     * @return a boolean that is true if the item has been used and false if it
     * has not been used
     */
    @Override
    public boolean use(Item item) {
        if (item == null) {
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
            return false;
        }

        if (item.isPickUpAble()
                && player.getInventory().getTotalItemWeight() + item.getWeight() <= player.getMaxWeight()
                && player.getInventory().size() + 1 <= player.getMaxItemCapacity()) {

            switch (item.getItemType()) {
                case WEAPON:
                    Weapon weapon = (Weapon) item;
                    player.changePlayerMove(weapon);
                    break;
                case TIMEINCREASINGITEM:

                    player.addTime(((TimeIncreasingItem) item).getTime());
                    player.getRoom().getInventory().removeItem(item);
                    return true;

                default:
                    break;
            }
            //Transfers the item from the room inventory to the player inventory
            player.getInventory().transferItem(player.getRoom().getInventory(), item);
            return true;
        } else if (player.getInventory().getTotalItemWeight() + item.getWeight() > player.getMaxWeight()) {
            return false;
        } else if (player.getInventory().size() + 1 > player.getMaxItemCapacity()) {
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
     * Returns a String that has been read in from the file "helpfile.dne"
     *
     * @return String
     */
    @Override
    public String getHelpDescription() {
        try {
            FileReader file = new FileReader("helpfile.dne");
            Scanner scanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception in getHelpDescription" + ex);
        }
        return " ";
    }

    /**
     * Sets up the game so it can be played. The game is read in from a file and
     * the name of the file is the parameter
     *
     * @param fileToRead
     */
    @Override
    public void constructWorld(String fileToRead) {
        WorldLoader wl = new WorldLoader();
        this.rooms = wl.loadWorld(fileToRead);
        this.bosses = wl.loadBosses(fileToRead);
        player = new Player(rooms.get(0), 100, 1200, 3, 20); // creates a new object of the player class
        npc.add(new NPC(rooms.get(rooms.size() - 1), "Dobby the alf"));        
        ArrayList<Move> moves = this.player.getMoves();
        moves.add(new Move(10, Attack.STAB, WeaponType.MELEE));
        moves.add(new Move(0, Attack.DUCK, WeaponType.MELEE));
        moves.add(new Move(0, Attack.JUMP, WeaponType.MELEE));
        moves.add(new Move(0, Attack.SIDESTEP, WeaponType.MELEE));
    }

    /**
     * Returns a boolean that is true if an Item of the type key has been used
     * and false if it wasn't used. A key item unlocks a Room if it is used
     *
     * @param item
     * @return boolean
     */
    private boolean useKey(Item item) {
        Key key = (Key) item;
        Room roomToUnlock;
        for (Direction r : player.getRoom().getListOfExitDirections()) {
            roomToUnlock = player.getRoom().getExit(r);
            if (key.getNameOfRoomThatFitsThisKey().equalsIgnoreCase(roomToUnlock.getName())) {
                if (roomToUnlock.isLocked()) {
                    roomToUnlock.unlock();
                    player.getInventory().removeItem(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets all rooms hidden boolean to false
     */
    private void showAllRooms() {
        for (Room room : rooms) {
            room.setHidden(false);
        }
    }

	/**
	 * Uses a flashlight, when a flashlight is used it checks whether or not there
	 * are any secret numbers in the room. if there is they are added to the list
	 * of numbers found
	 *
	 * @param item
	 */
	private void useFlashlight(Item item) {
		Flashlight flashlight = (Flashlight) item; //Uses up charges on players flashlight, and prints line below telling you how many charges you have left.
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			if (player.getRoom().hasEscapeCode()) {
				if (!roomNumber.contains(player.getRoom())) { //add a room to the arraylist roomNumber, that tracks the rooms with numbers in them
					roomNumber.add(player.getRoom());
				}
			}
		}
	}

    /**
     * Returns a boolean that is true if the boltcutter has been used and false
     * if the boltcutter haven't been used Using a boltcutter does so that the
     * escapeable room is able to finish the game
     *
     * @param item
     * @return boolean
     */
    private boolean useBoltcutter(Item item) {
        Boltcutter boltcutter = (Boltcutter) item;
        Room roomToUnlock;
        for (Room room : rooms) {
            for (Direction dir : room.getListOfExitDirections()) {
                roomToUnlock = room.getExit(dir);
                if (boltcutter.getRoomBoltcutterCanBeUsedIn().equalsIgnoreCase(room.getExit(dir).getName())) {
                    if (roomToUnlock.isEscapeableRoom() && roomToUnlock.isLocked()) {
                        roomToUnlock.unlock();
                        player.getInventory().removeItem(item);
                        return true;
                    } else if (!roomToUnlock.isEscapeableRoom() && roomToUnlock.isLocked()) {
                        return false;
                    } else if (roomToUnlock.isEscapeableRoom() && !roomToUnlock.isLocked()) {
                        return false;
                    }
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Saves the given parameters as a highscore
     *
     * @param name
     * @param score
     */
    @Override
    public void saveHighScore(String name, int score) {
        this.highscore.saveHighscore(score, name);
    }

    /**
     * Returns an observable list of highscores
     *
     * @return ObservableList containing scores
     */
    @Override
    public ObservableList<Score> getHighScoreList() {
        return highscore.getHighscoreList();
    }

    /**
     * Calculates the score for the player, and returns the score as an int
     *
     * @return int
     */
    @Override
    public int calculateHighScore() {
        return Highscore.calculateScore(player.getTime(), player.getAmountOfBossKill());
    }

    /**
     * Returns an ArrayList of NPC's in the game
     *
     * @return ArrayList containing NPC's
     */
    @Override
    public ArrayList<NPC> getAllNpc() {
        return npc;
    }

    /**
     * Returns the player object
     *
     * @return Player
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns an ArrayList containing all the bosses in the game
     *
     * @return ArrayList containing Boss
     */
    @Override
    public ArrayList<Boss> getBosses() {
        return bosses;
    }
	/**
	 * The getCorrectCode method returns the hidden code that is found in all
	 * rooms, the order of the code is determined by the order of the arraylist
	 *
	 * @return returns a string with the correct key code
	 */
	public String getCorrectCode() {
		StringBuilder correctCode = new StringBuilder();
		for (Room room : roomNumber) {
			if (room.hasEscapeCode()) {
				correctCode.append(room.getNumber());
			}
		}
		return correctCode.toString();
	}

	@Override
	public boolean isCodeCorrect(String code) {
		if (code != null) {
			return code.equalsIgnoreCase(getCorrectCode());
		}
		return false;
	}
	@Override
	public ObservableList<String> getListOfFiles(){
		ObservableList<String> returnList = FXCollections.observableArrayList();
		File folder = new File("./GameFiles");
		File[] listOfFiles = folder.listFiles();
		for(File file : listOfFiles){
			if(file.isFile()){
				returnList.add(file.getName());
			}
		}
		return returnList;
	}
}
