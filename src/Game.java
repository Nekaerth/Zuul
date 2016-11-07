
/**
 * *******************GAME CLASS*************************************
 * The game class cosists off X instance variable and X instance methods
 * The arraylist is imported from the java utility library
 */
import java.util.ArrayList;

public class Game {

	private final Parser parser;
	private Player player;
	private final ArrayList<Boss> bosses = new ArrayList<>();
	private Room cell, cellhall, dininghall, yard, office, storage, parkinglot, tunnel, employeeCanteen; // initializes the rooms available
	private ArrayList<Room> roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number

	/**
	 * The construter for the game class consists off calling a method The
	 * createRooms() method and creating a new object of the parser class.
	 */
	public Game() //Constructor
	{
		createRooms(); // calls the createRooms() method
		parser = new Parser(); // creates a new object of the parser class
	}

	/**
	 * This method creates all the rooms which are available and an object of the
	 * player class
	 */
	private void createRooms() //Called from the constructor
	{
		// initializes the rooms available
		cell = new Room("in your own cell.", false, false); //The constructor for room is called with parameters String, boolean
		cellhall = new Room("in the cellhall. Be carefull, the guards are on the lookout.", false, true);
		dininghall = new Room("in the dininghall. You find yourself stepping on a piece of ham. Yuck!", true, false);
		yard = new Room("in the yard. Fresh air, ahh.", false, false);
		office = new Room("in the office. They have alot of paperwork going on here.", true, false);
		storage = new Room("in the storage. Grab what you can and get on the run fast. They are monitoring this room!", false, false);
		parkinglot = new Room("outside at the parkinglot. There is a parked car, it could be your getaway.", false, false);
		tunnel = new Room("in a secret tunnel", true, false);
		employeeCanteen = new Room("in the employees canteen", false, false);

		cell.setExit("Cellhall", cellhall); // Calls the method in room called set exit, taking a string and room object as an argument.
		setCellInventory(); // calls the method setCellInventory()
		//to declare what items that are in the cell when the game begins

		tunnel.setExit("Canteen", employeeCanteen);
		tunnel.setExit("Cell", cell);
		setHiddenroomInventory();

		employeeCanteen.setExit("Tunnel", tunnel);
		setBossroomInventory();

		dininghall.setExit("Cellhall", cellhall);
		setDininghallInventory();

		cellhall.setExit("Dininghall", dininghall);
		cellhall.setExit("Yard", yard);
		cellhall.setExit("Office", office);
		cellhall.setExit("Cell", cell);

		office.setExit("Storage", storage);
		office.setExit("Cellhall", cellhall);
		setOfficeInventory();
		office.LockRoom();

		yard.setExit("Cellhall", cellhall);
		setYardInventory();

		storage.setExit("Office", office);
		setStorageInventory();
		storage.LockRoom();

		parkinglot.setEscapeRoom();

		player = new Player(cell, 100, 1200, 3, 20); // creates a new object of the player class
		setUpPlayer();

		bosses.add(0, new Boss(employeeCanteen, 100, "boss 1"));
		setUpBoss1();
	}

	/**
	 * The getPlayer() is a getter method that will return a player object
	 *
	 * @return will return the object player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Adds four moves to player move list.
	 */
	private void setUpPlayer() {
		ArrayList<Move> moves = this.player.getMoves();
		moves.add(new Move(Attack.STAB, 10));
		moves.add(new Move(Attack.DUCK, 0));
		moves.add(new Move(Attack.JUMP, 0));
		moves.add(new Move(Attack.SIDESTEP, 0));
	}

	/**
	 * Sets up the first boss, by adding all moves and adding all items to his
	 * inventory.
	 */
	private void setUpBoss1() {
		ArrayList<Move> moves = this.bosses.get(0).getMoves();
		moves.add(new Move(Attack.LASH, Attack.JUMP, 10));
		moves.add(new Move(Attack.CHARGE, Attack.SIDESTEP, 10));
		moves.add(new Move(Attack.PUNCH, Attack.STAB, 10));
		this.bosses.get(0).getInventory().putItem("Key", new Key(true, "Key", true, 1, 1));
	}

	/**
	 * Sets up the second boss, by adding all moves.
	 */
	private void setUpBoss2() {
		ArrayList<Move> moves = this.bosses.get(1).getMoves();
		moves.add(new Move(Attack.LASH, Attack.JUMP, 15));
		moves.add(new Move(Attack.CHARGE, Attack.SIDESTEP, 15));
		moves.add(new Move(Attack.PUNCH, Attack.STAB, 15));
		moves.add(new Move(Attack.SHOOT, Attack.DUCK, 15));
		moves.add(new Move(Attack.LAUGH, Attack.SHOOT, 5));
	}

	/**
	 * The setCellInventory() method will set the cell inventory when the game.
	 * starts
	 */
	private void setCellInventory() {
		Inventory inventory = cell.getInventory();
		inventory.putItem("Stone", new Weapon(true, "Stone", false, 1, 1, 11, "melee"));
		inventory.putItem("Stick", new Misc(false, "Stick", false));
	}

	/**
	 * This method will set the hidden rooms inventory when the game starts.
	 */
	private void setHiddenroomInventory() {
		Inventory inventory = tunnel.getInventory();
		inventory.putItem("Flashlight", new Flashlight(true, "Flashlight", true, 5, 1, 5));
	}

	/**
	 * This method will set the boss rooms inventory when the game starts
	 */
	private void setBossroomInventory() {
		Inventory inventory = employeeCanteen.getInventory();
		inventory.putItem("Key", new Key(true, "Key", false, 5, 1));
	}

	/**
	 * This method will set the dining hall inventory when the game starts.
	 */
	private void setDininghallInventory() {
		Inventory inventory = dininghall.getInventory();
		inventory.putItem("Key", new Key(true, "Key", true, 5, 1));
		inventory.putItem("Plate", new Misc(false, "Plate", false));
		inventory.putItem("Fork", new Weapon(true, "Fork", true, 1, 1, 12, "melee"));
	}

	/**
	 * This method will set the office inventory when the game starts.
	 */
	private void setOfficeInventory() {
		Inventory inventory = office.getInventory();
		inventory.putItem("Blueprints", new SpecialItem(true, "Blueprints", true, 5, 1));
		inventory.putItem("Papers", new Misc(false, "Papers", false));
	}

	/**
	 * This method will set the yard inventory when the game starts.
	 */
	private void setYardInventory() {
		Inventory inventory = yard.getInventory();
		inventory.putItem("Knife", new Weapon(true, "Knife", false, 5, 1, 15, "melee"));
	}

	/**
	 * This method will set the storage inventory when the game starts.
	 */
	private void setStorageInventory() {
		Inventory inventory = storage.getInventory();
		inventory.putItem("Boltcutter", new SpecialItem(true, "Boltcutter", true, 5, 1));
		inventory.putItem("Pistol", new Weapon(true, "Pistol", false, 5, 1, 25, "ranged"));
		inventory.putItem("Boxes", new Misc(false, "Box", false));
	}

	/**
	 * The play method is used to run the game it starts by calling the
	 * printWelcome() method, then a boolean is initialized and as long as the
	 * boolean is false a loop will run where inputs from the user is processed
	 */
	public void play() {
		printWelcome(); //calls the method printWelcome()

		boolean finished = false; // initializes boolean finished as false
		while (!finished) { // a loop that run as long as the boolean finished stay false
			Command command = parser.getCommand(); //Får command baseret på brugerens input,
			//og modtager det som et objekt command
			finished = processCommand(command); //processer commanden
		}
		System.out.println("Thank you for playing.  Good bye."); //prints this if you quit the game
	}

	/**
	 * The method printWelcome will print the text, and what to type if you need
	 * help, in the console
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("You wake up and realize there's a prisonriot going on. Now's your chance to escape!");
		System.out.println("Hurry! you have limited time to escape, before the warden gets everything under control again.");
		System.out.println("You got 20 minutes, 100 HP and your melee attack damage is 10");
		System.out.println("Type '" + CommandWord.HELP + "' if you need help."); //commandWord.HELP is a variable in commandWord
		System.out.println();
		System.out.println(player.getRoom().getLongDescription()); //Gives a description of the room you're in + exit options
	}

	/**
	 * The method processCommand will process the user input and reacts to the
	 * specific user input
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord(); //Gets the command word and saves as in the object commandWord

		if (commandWord == CommandWord.UNKNOWN) { //Prints this if commandWord isn't known
			System.out.println("I don't know what you mean...");
			System.out.println(player.getRoom().getExitString());
			return false; //Does so it won't quit program
		}

		if (null != commandWord) {
			switch (commandWord) {
				case HELP:
					//If help is typed
					printHelp(); //Prints all command words
					break;
				case GO:
					//If go + exitRoom is typed
					wantToQuit = goRoom(command); //Goes to typed room if the command is valid
					break;
				case QUIT:
					//If quit is typed
					wantToQuit = quit(command); //Returns true if only 'quit' is typed, and returns false if anything else is typed    
					break;
				case SEARCH:
					//If search is typed
					searchRoom(command); //Searches the room for items
					break;
				case PICKUP:
					//If pickup + secondWord is typed
					pickUp(command); //Picks up item to players inventory if secondWord is valid
					break;
				case DROP:
					//If drop + secondWord is typed
					drop(command); //Drops item in players inventory to currentRoom if secondWord is valid
					break;
				case USE:
					//If use + secondWord is typed
					use(command); //Uses an items functionality if the item have any
					break;
				case INVENTORY:
					//If inventory is typed
					showInventory(); //Shows what items the player currently have in the inventory
					break;
				case TIME:
					//If time is typed
					System.out.println("You have " + player.displayTime() + " left."); //Displays amount of time left, before you lose the game
					break;
				default:
					break;
			}

		}
		System.out.println(player.getRoom().getExitString());
		return wantToQuit; //returns boolean for 'go' and 'help' commands that doesnt change from false
	}

	/**
	 * The method printHelp is a case of the user input and will print what the
	 * objective of the game is and what commands that are available if the user
	 * types "help"
	 */
	private void printHelp() {
		System.out.println("You're a prisoner inside a prison, and there have just been a riot.");
		System.out.println("Your goal is to break out.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * The method goRoom is a case of the user input and are used when the user
	 * types "go" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private boolean goRoom(Command command) {
		boolean finish = false;
		if (!command.hasSecondWord()) { //Checks if there is a direction
			System.out.println("Go where?");
			return finish;
		}

		String direction = command.getSecondWord(); //Saves it as a string

		Room nextRoom = player.getRoom().getExit(direction); //Finds the next room in the hashmap room and sets this as NextRoom

		if (nextRoom == null) { //Prints this if there is no room that direction / the hashmap doesnt contain the value of the key
			System.out.println("There is no door!");
		} else if (!nextRoom.isLocked()) {

			player.subtractTime(10);
			if (nextRoom.getEscapeRoom()) {
				//Following code is run if the next room is the parkinglot
				String correctCode;
				System.out.println("There is a codelock locking the door, to get to the parkinglot you need to enter a 3 digit code: ");
				String inputCode = parser.getCode();
				if (roomNumber.size() == 3) {
					correctCode = getCorrectCode();
				} else {
					System.out.println("You haven't found all the hidden numbers, you wont know the code!");
					correctCode = "debugDevBugtool";
				}

				if (inputCode != null && inputCode.equalsIgnoreCase(correctCode) == true) {

					System.out.println("Congratulations, you have escaped!");
					System.out.println("Type \"quit\" to quit the game");
					player.setRoom(nextRoom);

				} else if (inputCode != null && inputCode.equalsIgnoreCase(correctCode) == false) {
					System.out.println("Wrong code!");
				}

			} else if (nextRoom.getEscapeRoom() == false) {
				player.setRoom(nextRoom); //Changes players current room to nextRoom.
				//Should be changed to more generic reuseable code
				if (nextRoom == storage && cellhall.needsBoss() == true) {

					bosses.add(1, new Boss(cellhall, 100, "boss 2"));
					setUpBoss2();
					cellhall.setNeedsBoss(false);
				}

				for (Boss boss : bosses) {
					if (player.getRoom() == boss.getRoom() && player.getRoom().needsBoss() == false) {
						System.out.println("You encounter a prison guard");
						System.out.println("Be prepared or you will die!");
						finish = boss.bossFight(player);
					}
				}
				System.out.println(player.getRoom().getShortDescription()); //Prints descriptions and exits of the new room
			}

		} else if (nextRoom.isLocked() == true) {
			System.out.println("The door is locked, you can't go in there without a key");
		}
		return finish;

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
			if (room.isNumberRoom()) {
				correctCode.append(room.getNumber());
			}
		}
		return correctCode.toString();
	}

	/**
	 * The quit method is a case of the user input and is used when the user types
	 * "quit" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) { //If anymore than quit is typed
			System.out.println("Quit what?");
			return false;
		} else {
			return true; //If only 'quit' is typed; quits the game
		}
	}

	/**
	 * The searchRoom method is a case of the user input and is used when the user
	 * types "search" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private void searchRoom(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Search what?");
		} else if (!player.getRoom().getInventory().isEmpty()) {  //If there exist any items in inv for currentRoom, prints this.       
			System.out.println("You search the room and find something interesting.");
			String items = player.getRoom().getInventory().getStringOfAllItems();
			System.out.println("You find the following items.");
			System.out.println(items);

			player.subtractTime(5);
		} else {
			System.out.println("You search the room, but find nothing."); //If there isnt any items in inv for currentRoom, prints this.

			player.subtractTime(5);
		}
	}

	/**
	 * The pickUp method is a case of the user input and is used when the user
	 * types "pickup" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private void pickUp(Command command) {
		if (!command.hasSecondWord()) { //If 'pickup' and something that doesnt exist in game is typed, prints this.
			System.out.println("Pick up what?");
			return;
		}
		Item item = player.getRoom().getInventory().getItem(command.getSecondWord());
		if (item == null) {
			System.out.println("There is no such item.");
			return;
		}

		if (item.isPickup()
						&& player.getInventory().itemWeight() + item.getWeight() <= player.getWeightCapacity()
						&& player.getInventory().size() + 1 <= player.getCapacity()) {

			System.out.println("You picked up " + item.getName());
			switch (item.getType()) {
				case WEAPON:
					Weapon weapon = (Weapon) item;
					player.changePlayerMove(weapon);
					System.out.println("Your melee attack increases by " + (weapon.getDamage() - 10));

					if (item.getName().equalsIgnoreCase("Pistol")) {
						System.out.println("You gain the ability to use shoot against prison guards");
						System.out.println("Your ranged attack damage is 25");
					}
					break;
				case FLASHLIGHT:
					System.out.println("Use it wisely, it won't last very long!");
					break;
				case SPECIALITEM:
					if (item.getName().equalsIgnoreCase("boltcutter")) {
						System.out.println("This might be usefull for escaping");
					} else if (item.getName().equalsIgnoreCase("blueprints")) {
						System.out.println("The blueprints could be useful for finding new places to go,");
						System.out.println("just don't wander around for too long");
					}
					break;
				case KEY:
					System.out.println("Look for a locked door");
					break;
				case MISC:
					if (item.getName().equalsIgnoreCase("stick")) {
						System.out.println("The stick is stuck in the wall");
						System.out.println("go find something more usefull instead");
					} else if (item.getName().equalsIgnoreCase("papers")) {
						System.out.println("You don't have time to go through that stack of papers");
						System.out.println("Move ON!");
					} else if (item.getName().equalsIgnoreCase("boxes")) {
						System.out.println("You don't have time to find the box of evidence related to your case");
						System.out.println("Move ON!");
					} else if (item.getName().equalsIgnoreCase("plate")) {
						System.out.println("Seriously! you want to eat now?");
						System.out.println("Hurry up instead and escape while you still got a chance to");
					}
					return;
				default:
					break;
			}
			player.getInventory().putItem(command.getSecondWord(), item);
			player.getRoom().getInventory().removeItem(command.getSecondWord());

		} else if (player.getInventory().itemWeight() + item.getWeight() > player.getWeightCapacity()) {
			System.out.println("OOPS!! It's too heavy for you to pickup.");
			System.out.println("Your weight is: " + player.getInventory().itemWeight() + "/" + player.getWeightCapacity());
			System.out.println("The item you want to pickup weighs: " + item.getWeight());

		} else if (player.getInventory().size() + 1 > player.getCapacity()) {
			System.out.println("OOPS!! Your inventory is full: " + player.getInventory().size() + "/" + player.getCapacity() + " items");
			System.out.println("The capacity of the item you want to pickup is: " + item.getCapacity());
		}
	}

	/**
	 * The drop method is a case of the user input and is used when the user types
	 * "drop" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private void drop(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Drop what?");
			return;
		}
		Item item = player.getInventory().getItem(command.getSecondWord());
		if (item == null) {
			System.out.println("There is no such item.");
			return;
		}

		if (item.getType() == ItemType.WEAPON) {
			player.droppedWeapon((Weapon) item);
		}
		player.getRoom().getInventory().putItem(command.getSecondWord(), item);
		player.getInventory().removeItem(command.getSecondWord());
		System.out.println("You drop " + item.getName());

	}

	/**
	 * The use method is a case of the user input and is used when the user types
	 * "use" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 */
	private void use(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Use what?");
			return;
		}
		Item item = player.getInventory().getItem(command.getSecondWord());
		if (item == null) {
			System.out.println("You don't have that item in your inventory");
			return;
		}
		if (!item.isUseable()) {//There are only 4 items that are useable. Either key, flashlight, blueprints or boltcutter
			System.out.println("You can't use that item for anything");
		}

		switch (item.getType()) {
			case KEY:
				useKey(command);
				break;
			case FLASHLIGHT:
				useFlashlight(item);
				break;
			case SPECIALITEM:
				if (item.getName().equalsIgnoreCase("blueprints")) {
					useBlueprints(command);
				} else if (item.getName().equalsIgnoreCase("boltcutter")) {
					useBoltcutter(command);
				}
				break;
			default:
				break;
		}
	}

	/**
	 * The useKey method is a case when the user types "use" and is used when the
	 * user types "use key" as a command
	 *
	 * @param command is a parameter that needs a command object as an input
	 * @param key the key is a item you must have in yor inventory to use the
	 * command "use key" the key is used as an input to this method
	 */
	private void useKey(Command command) {
		if (!command.hasThirdWord()) {
			System.out.println("Use key where?"); //Prints this if 'use key' isn't used at a setExit.
			return;
		}
		Room nextRoom = player.getRoom().getExit(command.getThirdWord());

		if (nextRoom == null) {
			System.out.println("You can't use key there");
			return;
		}
		if (nextRoom.isLocked()) {
			nextRoom.unlock();
			System.out.println("You successfully unlock the door");
			player.getInventory().removeItem(command.getSecondWord());
		} else {
			System.out.println("The door is already unlocked"); //Prints this if you try to 'use key' any other place than a locked door.
		}

	}

	/**
	 * The useFlashlight method is a case when the user types "use" and is used
	 * when the user types "use flashlight"
	 *
	 * @param command is a parameter that needs a command object as an input
	 * @param flashlight is a item you must have in your inventory to use the
	 * command "use flashlight"
	 */
	private void useFlashlight(Item item) {
		Flashlight flashlight = (Flashlight) item; //Uses up charges on players flashlight, and prints line below telling you how many charges you have left.
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			System.out.println("You used the flashlight and the battery drained, you think you will have " + flashlight.getCharges() + " use(s) left");
			if (player.getRoom().isNumberRoom()) {
				System.out.println("You search the room and find a mysterious number that was hidden");
				System.out.println("The number is " + player.getRoom().getNumber());
				if (roomNumber.contains(player.getRoom()) == false) { //add a room to the arraylist roomNumber, that tracks the rooms with numbers in them
					roomNumber.add(player.getRoom());
				}
			} else {
				System.out.println("To your disappointment you find nothing new");
			}

		} else if (flashlight.getCharges() <= 0) {
			System.out.println("You don't have anymore charges in your flashlight");
			System.out.println("if you haven't found anything with it, you will be in trouble");
		}
	}

	/**
	 * The useBlueprints method is a case when the user types "use". This method
	 * is a case of the "use" input from the user
	 *
	 * @param command the parameter command is what the method requires when it is
	 * called
	 */
	private void useBlueprints(Command command) {
		cell.setExit("Tunnel", tunnel);
		System.out.println("You take a look at the blueprints of the prison and find a secret area behind your cell");
		player.getInventory().removeItem(command.getSecondWord());
	}

	/**
	 * The useBoltcutter method is a case when the user types "use". This method
	 * is a case of the "use" input from the user
	 *
	 * @param command the parameter command is what the method requires when it is
	 * called
	 */
	private void useBoltcutter(Command command) {
		if (player.getRoom() != yard) {//You can only use boltcutter at the yard
			System.out.println("You got no use for the boltcutter here");
		} else if (player.getRoom().getExit("Parkinglot") == null) {
			System.out.println("You use the boltcutter to cut open the net. You can now escape to the parkinglot.");
			System.out.println("Find a car and get out of here.");
			yard.setExit("Parkinglot", parkinglot);
		} else {
			System.out.println("You already have opened up to the parkinglot.");
		}
	}

	/**
	 * The showInventory method will print the items that are currently in the
	 * players inventory
	 */
	private void showInventory() { //Shows players current inventory containing; items, weight and capacity.
		System.out.println("Your inventory contains the following:");
		System.out.println(player.getInventory().getStringOfAllItems());
		System.out.println("Your total weight is: " + player.getInventory().itemWeight() + "/" + player.getWeightCapacity());
		System.out.println("Your total capacity is: " + player.getInventory().size() + "/" + player.getCapacity());
	}
}
