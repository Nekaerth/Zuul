
/**
 * *******************GAME CLASS*************************************
 * The game class cosists off X instance variable and X instance methods
 * The arraylist is imported from the java utility library
 */
import java.util.ArrayList;

public class Game {

	private final Parser parser;
	private Room currentRoom;
	private Player player;
	private Room cell, cellhall, dininghall, yard, office, storage, parkinglot, hiddenroom, bossroom; // initializes the rooms available
	private ArrayList<Room> roomNumber = new ArrayList<>(); //An arraylist of rooms that contains a hidden number
	private int time;

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
		player = new Player(100, new ArrayList<>(), new Inventory(), 3, 20); // creates a new object of the player class
		player.setUpPlayer();

		this.time = 1200;

		cell = new Room("in your own cell.", false, false); //The constructor for room is called with parameters String, boolean
		cellhall = new Room("in the cellhall. Be carefull, the guards are on the lookout.", false, true);
		dininghall = new Room("in the dininghall. You find yourself stepping on a piece of ham. Yuck!", true, false);
		yard = new Room("in the yard. Fresh air, ahh.", false, false);
		office = new Room("in the office. They have alot of paperwork going on here.", true, false);
		storage = new Room("in the storage. Grab what you can and get on the run fast. They are monitoring this room!", false, false);
		parkinglot = new Room("outside at the parkinglot. There is a parked car, it could be your getaway.", false, false);
		hiddenroom = new Room("in a secret room", true, false);
		bossroom = new Room("in the bossroom", false, false);

		cell.setExit("Cellhall", cellhall); // Calls the method in room called set exit, taking a string and room object as an argument.
		cell.inv = setCellInventory(); // calls the method setCellInventory()
		//to declare what items that are in the cell when the game begins

		hiddenroom.setExit("Bossroom", bossroom);
		hiddenroom.setExit("Cell", cell);
		hiddenroom.inv = setHiddenroomInventory();

		bossroom.setExit("Hiddenroom", hiddenroom);
		bossroom.boss = new Boss(100, new ArrayList<>(), new Inventory(), "boss 1");
		bossroom.boss.setUpPrisonGuard();

		dininghall.setExit("Cellhall", cellhall);
		dininghall.inv = setDininghallInventory();

		cellhall.setExit("Dininghall", dininghall);
		cellhall.setExit("Yard", yard);
		cellhall.setExit("Office", office);
		cellhall.setExit("Cell", cell);

		office.setExit("Storage", storage);
		office.setExit("Cellhall", cellhall);
		office.inv = setOfficeInventory();
		office.LockRoom();

		yard.setExit("Cellhall", cellhall);
		yard.inv = setYardInventory();

		storage.setExit("Office", office);
		storage.inv = setStorageInventory();
		storage.LockRoom();

		parkinglot.setEscapeRoom();

		bossroom.setExit("Hiddenroom", hiddenroom);
		bossroom.inv = setBossroomInventory();

		currentRoom = cell;
		/* currentRoom is the variable that keeps track of what room you are in
		the variable is set to cell to declare the room you begin the game in
		 */

	}

	/**
	 * The getPlayer() is a getter method that will return a player object
	 * @return will return the object player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * The getTime() is a getter method to get the integer "time"
	 * @return will return the integer "time"
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * The subtractTime() method is used as a count down timer to keep track of
	 * how much time the player has left Time is used as a ressource that you
	 * spend while moving through rooms and looking for items.
	 * @param time is an integer that we subtract from to reduce the time the
	 * player has left to win the game.
	 */
	public void subtractTime(int time) {
		int fiveMinuteMark = (this.time - 1) / 300;
		this.time -= time;
		int newFiveMinuteMark = (this.time - 1) / 300;
		if (fiveMinuteMark > newFiveMinuteMark) {
			System.out.println("You have " + displayTime() + " left.");
		}
	}

	/**
	 * The displayTime() method is a case of the user input and occours when the
	 * user types "time"
	 * @return will return the time that is left in minutes and seconds
	 */
	public String displayTime() {
		int minutes = this.time / 60;
		int seconds = this.time % 60;
		return minutes + " min and " + seconds + " sec";
	}

	/**
	 * The setCellInventory() method will set the cell inventory when the game
	 * starts
	 * @return will return the cell inventory
	 */
	private Inventory setCellInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Stone", new Weapon(true, "Stone", false, 1, 1, 11, "melee"));
		inv.putItem("Stick", new Misc(false, "Stick", false));
		return inv;
	}

	/**
	 * This method will set the storage inventory when the game starts
	 * @return will return the storage inventory
	 */
	private Inventory setStorageInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Boltcutter", new SpecialItem(true, "Boltcutter", true, 5, 1));
		inv.putItem("Pistol", new Weapon(true, "Pistol", false, 5, 1, 25, "ranged"));
		inv.putItem("Boxes", new Misc(false, "Box", false));
		return inv;
	}

	/**
	 * This method will set the dining hall inventory when the game starts
	 * @return will return the dining hall inventory
	 */
	private Inventory setDininghallInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Key", new Key(true, "Key", true, 5, 1));
		inv.putItem("Plate", new Misc(false, "Plate", false));
		inv.putItem("Fork", new Weapon(true, "Fork", true, 1, 1, 12, "melee"));
		return inv;
	}

	/**
	 * This method will set the yard inventory when the game starts
	 * @return will return the yard inventory
	 */
	private Inventory setYardInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Knife", new Weapon(true, "Knife", false, 5, 1, 15, "melee"));
		return inv;
	}

	/**
	 * This method will set the office inventory when the game starts
	 * @return will return the office inventory
	 */
	private Inventory setOfficeInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Blueprints", new SpecialItem(true, "Blueprints", true, 5, 1));
		inv.putItem("Papers", new Misc(false, "Papers", false));
		return inv;
	}

	/**
	 * This method will set the hidden rooms inventory when the game starts
	 * @return will return the hidden rooms inventory
	 */
	private Inventory setHiddenroomInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Flashlight", new Flashlight(true, "Flashlight", true, 5, 1, 5));
		return inv;
	}

	/**
	 * This method will set the boss rooms inventory when the game starts
	 * @return will return the boss rooms inventory
	 */
	private Inventory setBossroomInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Key", new Key(true, "Key", false, 5, 1));
		return inv;
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
		System.out.println(currentRoom.getLongDescription()); //Gives a description of the room you're in + exit options
	}

	/**
	 * The method processCommand will process the user input and reacts to the
	 * specific user input
	 * @param command is a parameter that needs a command object as an input
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord(); //Gets the command word and saves as in the object commandWord

		if (commandWord == CommandWord.UNKNOWN) { //Prints this if commandWord isn't known
			System.out.println("I don't know what you mean...");
			System.out.println(currentRoom.getExitString());
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
					System.out.println("You have " + displayTime() + " left."); //Displays amount of time left, before you lose the game
					break;
				default:
					break;
			}

		}
		System.out.println(currentRoom.getExitString());
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
	 * @param command is a parameter that needs a command object as an input
	 */
	private boolean goRoom(Command command) {
		boolean finish = false;
		if (!command.hasSecondWord()) { //Checks if there is a direction
			System.out.println("Go where?");
			return finish;
		}

		String direction = command.getSecondWord(); //Saves it as a string

		Room nextRoom = currentRoom.getExit(direction); //Finds the next room in the hashmap room and sets this as NextRoom

		if (nextRoom == null) { //Prints this if there is no room that direction / the hashmap doesnt contain the value of the key
			System.out.println("There is no door!");
		} else if (!nextRoom.isLocked()) {

			subtractTime(10);
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
					currentRoom = nextRoom;

				} else if (inputCode != null && inputCode.equalsIgnoreCase(correctCode) == false) {
					System.out.println("Wrong code!");
				}

			} else if (nextRoom.getEscapeRoom() == false) {
				currentRoom = nextRoom; //Changes nextRoom you go to, to currentRoom.
				//Should be changed to more generic reuseable code
				if (nextRoom == storage && cellhall.needsBoss() == true) {

					cellhall.boss = new Boss(100, new ArrayList<>(), new Inventory(), "boss 2");
					cellhall.boss.setUpPrisonGuard2();
					cellhall.setNeedsBoss(false);
				}

				if (currentRoom.boss != null && currentRoom.needsBoss() == false) {
					System.out.println("You encounter a prison guard");
					System.out.println("Be prepared or you will die!");
					finish = currentRoom.bossFight(this);

				} else {
					System.out.println(currentRoom.getShortDescription()); //Prints descriptions and exits of the new room
				}
			}

		} else if (nextRoom.isLocked() == true) {
			System.out.println("The door is locked, you can't go in there without a key");
		}
		return finish;

	}

	/**
	 * The getCorrectCode method returns the hidden code that is found in all
	 * rooms, the order of the code is determined by the order of the arraylist
	 * @return returns a string with the correct key code
	 */
	public String getCorrectCode() {
		StringBuilder correctCode = new StringBuilder();
		for (Room r : roomNumber) {
			if (r.isNumberRoom()) {
				correctCode.append(r.getNumber());
			}
		}
		return correctCode.toString();
	}

	/**
	 * The quit method is a case of the user input and is used when the user types
	 * "quit" as a command
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
	 * @param command is a parameter that needs a command object as an input
	 */
	private void searchRoom(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Search what?");
		} else if (!currentRoom.inv.isEmpty()) {  //If there exist any items in inv for currentRoom, prints this.       
			System.out.println("You search the room and find something interesting.");
			String items = currentRoom.inv.getAllItems();
			System.out.println("You find the following items.");
			System.out.println(items);

			subtractTime(5);
		} else {
			System.out.println("You search the room, but find nothing."); //If there isnt any items in inv for currentRoom, prints this.

			subtractTime(5);
		}
	}

	/**
	 * The pickUp method is a case of the user input and is used when the user
	 * types "pickup" as a command
	 * @param command is a parameter that needs a command object as an input
	 */
	private void pickUp(Command command) {

		if (command.hasSecondWord() == false) { //If 'pickup' and something that doesnt exist in game is typed, prints this.
			System.out.println("Pick up what?");
		} else {
			try {
				Item item = currentRoom.inv.getItem(command.getSecondWord());
				if (item.isPickup() == true
								&& player.getInventory().itemWeight() + item.getWeight() <= player.getWeightCapacity()
								&& player.getInventory().size() + 1 <= player.getCapacity()) {
					player.getInventory().putItem(command.getSecondWord(), item);
					currentRoom.inv.removeItem(command.getSecondWord());

					System.out.println("You picked up " + item.getName());
					if (null != item.getType())
						switch (item.getType()) {
						case WEAPON:
							player.changePlayerMove(item);
							if (item.getName().equalsIgnoreCase("stone")) {
								System.out.println("Your melee attack increases by 1");
							} else if (item.getName().equalsIgnoreCase("fork")) {
								System.out.println("Your melee attack increases by 2");
							} else if (item.getName().equalsIgnoreCase("knife")) {
								System.out.println("Your melee attack increases by 5");
							} else if (item.getName().equalsIgnoreCase("Pistol")) {
								System.out.println("You gain the ability to use shoot against prison guards");
								System.out.println("Your ranged attack damage is 25");
							}	break;
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
						default:
							break;
					}
				} else if (player.getInventory().itemWeight() + item.getWeight() > player.getWeightCapacity()) {
					System.out.println("OOPS!! It's too heavy for you to pickup.");
					System.out.println("Your weight is: " + player.getInventory().itemWeight() + "/" + player.getWeightCapacity());
					System.out.println("The item you want to pickup weighs: " + item.getWeight());

				} else if (player.getInventory().size() + 1 > player.getCapacity()) {
					System.out.println("OOPS!! Your inventory is full: " + player.getInventory().size() + "/" + player.getCapacity() + " items");
					System.out.println("The capacity of the item you want to pickup is: " + item.getCapacity());
				} else if (item.getType() == ItemType.MISC && item.getName().equalsIgnoreCase("stick")) {
						System.out.println("The stick is stuck in the wall");
						System.out.println("go find something more usefull instead");
					} else if (item.getType() == ItemType.MISC && item.getName().equalsIgnoreCase("papers")) {
						System.out.println("You don't have time to go through that stack of papers");
						System.out.println("Move ON!");
					} else if (item.getType() == ItemType.MISC && item.getName().equalsIgnoreCase("boxes")) {
						System.out.println("You don't have time to find the box of evidence related to your case");
						System.out.println("Move ON!");
					} else if (item.getType() == ItemType.MISC && item.getName().equalsIgnoreCase("plate")) {
						System.out.println("Seriously! you want to eat now?");
						System.out.println("Hurry up instead and escape while you still got a chance to");
					}
				

			} catch (IllegalArgumentException ex) {
				System.out.println("There is no such item.");
			}
		}
	}

	/**
	 * The drop method is a case of the user input and is used when the user types
	 * "drop" as a command
	 * @param command is a parameter that needs a command object as an input
	 */
	private void drop(Command command) {
		if (command.hasSecondWord() == false) {
			System.out.println("Drop what?");
		} else {
			try {
				Item item = player.getInventory().getItem(command.getSecondWord());
				if (item.getType() == ItemType.WEAPON) {
					player.droppedWeapon(item);
				}
				currentRoom.inv.putItem(command.getSecondWord(), item);
				player.getInventory().removeItem(command.getSecondWord());
				System.out.println("You drop " + item.getName());
			} catch (IllegalArgumentException ex) {
				System.out.println("There is no such item.");
			}
		}
	}

	/**
	 * The use method is a case of the user input and is used when the user types
	 * "use" as a command
	 * @param command is a parameter that needs a command object as an input
	 */
	private void use(Command command) {
		try {
			if (command.hasSecondWord() == false) {
				System.out.println("Use what?");
			} else {

				Item item = player.getInventory().getItem(command.getSecondWord());

				if (item.isUseable() == true) { //There are only 4 items that are useable. Either key, flashlight, blueprints or boltcutter
					switch(item.getType()){
						case KEY:
							useKey(command);
							break;
						case FLASHLIGHT:
							useFlashlight(item);
							break;
						case SPECIALITEM:
							if(item.getName().equalsIgnoreCase("blueprints")){
								useBlueprints(command);
							} else if(item.getName().equalsIgnoreCase("boltcutter")){
								useBoltcutter(command);
							}
							break;
						case MISC:
							System.out.println("Shouldn't be useable");
							break;
						case WEAPON:
							System.out.println("Don't need to use your weapon");
							break;
						default:
							break;
								
					}
						
					
					
					
					/*if (item.isKey() == true) {
						useKey(command, item);
					} else if (item.isFlashlight() == true) {
						useFlashlight(item);
					} else if (item.isSpecial() == true && item.getName().equalsIgnoreCase("blueprints")) {
						useBlueprints(command);
					} else if (item.isSpecial() == true && item.getName().equalsIgnoreCase("boltcutter")) {
						useBoltcutter(command);
					} else {
						System.out.println("There's a bug in the items useable boolean " + item.getName());
					}
					*/
				} else {
					System.out.println("You can't use that item for anything");
				}
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("You don't have that item in your inventory");
		}
	}

	/**
	 * The useKey method is a case when the user types "use" and is used when the
	 * user types "use key" as a command
	 * @param command is a parameter that needs a command object as an input
	 * @param key the key is a item you must have in yor inventory to use the
	 * command "use key" the key is used as an input to this method
	 */
	private void useKey(Command command) {

		if (command.hasThirdWord() == false) {

			System.out.println("Use " + command.getSecondWord() + " where?"); //Prints this if 'use key' isn't used at a setExit.

		} else if (currentRoom.getExit(command.getThirdWord()) != null) {

			Room nextRoom = currentRoom.getExit(command.getThirdWord());
			
			if(nextRoom.isLocked()){
			nextRoom.unlock();

			System.out.println("You successfully unlock the door"); //Prints this if key is used correct.

			player.getInventory().removeItem(command.getSecondWord());
			} else {
				System.out.println("The door is already unlocked"); //Prints this if you try to 'use key' any other place than a locked door.
			}
		}
	}

	/**
	 * The useFlashlight method is a case when the user types "use" and is used
	 * when the user types "use flashlight"
	 * @param command is a parameter that needs a command object as an input
	 * @param flashlight is a item you must have in your inventory to use the
	 * command "use flashlight"
	 */
	private void useFlashlight(Item item) {
		Flashlight flashlight = (Flashlight) item; //Uses up charges on players flashlight, and prints line below telling you how many charges you have left.
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			System.out.println("You used the flashlight and the battery drained, you think you will have " + flashlight.getCharges() + " use(s) left");
			if (currentRoom.isNumberRoom()) {
				System.out.println("You search the room and find a mysterious number that was hidden");
				System.out.println("The number is " + currentRoom.getNumber());
				if (roomNumber.contains(currentRoom) == false) { //add a room to the arraylist roomNumber, that tracks the rooms with numbers in them
					roomNumber.add(currentRoom);
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
	 * @param command the parameter command is what the method requires when it is
	 * called
	 */
	private void useBlueprints(Command command) {
		if (command.hasSecondWord() == false) {
			System.out.println("Use what?");
		} else {

			cell.setExit("Hiddenroom", hiddenroom); //Prints this when you 'use blueprints'
			System.out.println("You take a look at the blueprints of the prison and find a secret area behind your cell");
			player.getInventory().removeItem(command.getSecondWord());
		}
	}

	/**
	 * The useBoltcutter method is a case when the user types "use". This method
	 * is a case of the "use" input from the user
	 * @param command the parameter command is what the method requires when it is
	 * called
	 */
	private void useBoltcutter(Command command) {

		if (command.hasSecondWord() == false) {
			System.out.println("Use What?");
		} else if (currentRoom == yard) { //Prints this if you 'use boltcutter' at correct place.
			System.out.println("You use the boltcutter to cut open the net and escape to the parkinglot,");
			System.out.println("find a car and get out of here");
			yard.setExit("Parkinglot", parkinglot);
			player.getInventory().removeItem(command.getSecondWord());
		} else {
			System.out.println("You got no use for the boltcutter here");
		}
	}

	/**
	 * The showInventory method will print the items that are currently in the
	 * players inventory
	 */
	private void showInventory() { //Shows players current inventory containing; items, weight and capacity.
		System.out.println("Your inventory contains the following:");
		System.out.println(player.getInventory().getAllItems());
		System.out.println("Your total weight is: " + player.getInventory().itemWeight() + "/" + player.getWeightCapacity());
		System.out.println("Your total capacity is: " + player.getInventory().size() + "/" + player.getCapacity());
	}
}