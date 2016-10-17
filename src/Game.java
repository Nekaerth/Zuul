/**
 * The game class cosists off X instance variable and X instance methods
 * The arraylist is import from the java utility library
 */
import java.util.ArrayList;

public class Game {

	private final Parser parser;
	private Room currentRoom;
	private Player player;
	private Room cell, cellhall, dininghall, yard, office, storage, parkinglot, hiddenroom, bossroom; // initializes the rooms available

	/**
	 *The construter for the game class consists off calling a method
         *The createRooms() method and creating a new object of the parser class.
	 */
	public Game() //Constructor
	{
		createRooms(); // calls the createRooms() method
		parser = new Parser(); // creates a new object of the parser class
	}

	/**
	 * This method creates all the rooms which are available 
         * and an object of the player class
	 */
	private void createRooms() //Kaldes fra constructor
	{
		

		player = new Player(100, new ArrayList<>(), new Inventory(), 1200); // creates a new object of the player class

		cell = new Room("in your own cell.", false); //constructor for room kaldes, med en string som argument
		cellhall = new Room("in the cellhall. Be carefull, the guards are on the lookout.", false);
		dininghall = new Room("in the dininghall. You find yourself stepping on a piece of ham. Yuck!", true);
		yard = new Room("in the yard. Fresh air, ahh.", false);
		office = new Room("in the office. They have alot of paperwork going on here.", true);
		storage = new Room("in the storage. Grab what you can and get on the run fast. They are monetoring this room!", false);
		parkinglot = new Room("outside at the parkinglot. There is a parked car, it could be your getaway.", false);
		hiddenroom = new Room("in a secret room", true);
		bossroom = new Room("in the bossroom", false);

		cell.setExit("Cellhall", cellhall); // metode i room der hedder set exit kaldes, der tager en string og et room objekt som argument
		cell.setExit("Hiddenroom", hiddenroom);
		cell.inv = setCellInventory(); // calls the method setCellInventory()
                //to declare what items that are in the cell when the game begins

		hiddenroom.setExit("Bossroom", bossroom);
		hiddenroom.setExit("Cell", cell);
		hiddenroom.inv = setHiddenroomInventory();

		bossroom.setExit("Hiddenroom", hiddenroom);

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

		yard.setExit("Parkinglot", parkinglot);
		yard.setExit("Cellhall", cellhall);
		yard.inv = setYardInventory();

		storage.setExit("Office", office);
		storage.inv = setStorageInventory();
		storage.LockRoom();

		parkinglot.setEscapeRoom();

		bossroom.setExit("Hiddenroom", hiddenroom);
		bossroom.inv = setBossroomInventory();

		currentRoom = cell; // currentRoom is the variable that keeps track of what room you are in
                // the variable is set to cell to declare the room you begin the game in
	}

        /**
         * This method will set the cell inventory when the game starts
         * @return will return the cell inventory
         */
	private Inventory setCellInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Stone", new Item(true, "Stone", true));
		return inv;
	}
         /**
         * This method will set the storage inventory when the game starts
         * @return will return the storage inventory
         */
	private Inventory setStorageInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Boltcutter", new Item(false, "Boltcutter", false));
		inv.putItem("Pistol", new Item(false, "Pistol", false));
		return inv;
	}
         /**
         * This method will set the dining hall inventory when the game starts
         * @return will return the dining hall inventory
         */
	private Inventory setDininghallInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Key", new Item(true, "Key", true));
		return inv;
	}
         /**
         * This method will set the yard inventory when the game starts
         * @return will return the yard inventory
         */
	private Inventory setYardInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Knife", new Item(false, "Knife", false));
		return inv;
	}
         /**
         * This method will set the office inventory when the game starts
         * @return will return the office inventory
         */
	private Inventory setOfficeInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Blueprints", new Item(true, "Blueprints", true));
		return inv;
	}
        /**
         * This method will set the hidden rooms inventory when the game starts
         * @return will return the hidden rooms inventory
         */
	private Inventory setHiddenroomInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Flashlight", new Item(true, "Flashlight", true, 5));
		return inv;
	}
        /**
         * This method will set the boss rooms inventory when the game starts
         * @return will return the boss rooms inventory
         */
	private Inventory setBossroomInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Key", new Item(false, "Key", false));
		return inv;
	}
        /**
         * The play method is used to run the game it starts by calling the 
         * printWelcome() method, then a boolean is initialized and as long as
         * the boolean is false a loop will run where inputs from the user is processed
         */
	public void play() {
		printWelcome(); //calls the method printWelcome()

		boolean finished = false; // initializes boolean finished as false
		while (!finished) { // a loop that run as long as the boolean finished stay false
			Command command = parser.getCommand(); //Får command baseret på brugerens input,
                        //og modtager det som et objekt command
			finished = processCommand(command); //processer commanden
		}
		System.out.println("Thank you for playing.  Good bye."); //Hvis der quittes
	}
         /**
          * The method printWelcome will print the text, 
          * and what to type if you need help, in the console
          */
	private void printWelcome() {
		System.out.println();
		System.out.println("You wake up and realize there's a prisonriot going on. Now's your chance to escape!");
		System.out.println("Hurry! you have limmited time to escape, before the warden gets everything under control again.");
		System.out.println("Type '" + CommandWord.HELP + "' if you need help."); //commandWord.HELP er en variabel i commandword
		System.out.println();
		System.out.println(currentRoom.getLongDescription()); // Giver beskrivelse af rummet + exit muligheder
	}
        
	/**
	 * The method processCommand will process the user input 
         * and reactes to the specific input
         * @param command is a parameter that needs a command object as an input 
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord(); //Får command ordet og gemmer det i objektet commandword ud fra objektet command

		if (commandWord == CommandWord.UNKNOWN) { //Hvis det er unknown
			System.out.println("I don't know what you mean...");
			System.out.println(currentRoom.getExitString());
			return false; //Vil ikke quitte programmet
		}

		if (null != commandWord) {
			switch (commandWord) {
				case HELP:
					// Hvis der er skrevet help
					printHelp();
					break;
				case GO:
					// hvis der er skrevet go
					goRoom(command); //gå til et andet rum hvis commanden er gyldig
					break;
				case QUIT:
					// hvis der er skrevet quit
					wantToQuit = quit(command); //returner true hvis der bare er skrevet quit, hvis der er skrevet mere returner det flase    
					break;
				case SEARCH:
					// hvis der er skrevet search
					searchRoom(command);
					break;
				case PICKUP:
					pickUp(command);
					break;
				case DROP:
					drop(command);
					break;
				case USE:
					use(command);
					break;
				case INVENTORY:
					showInventory();
					break;
				default:
					break;
			}

		}
		System.out.println(currentRoom.getExitString());
		return wantToQuit; //return boolean, som under go og help commanden ikke ændres fra false
	}

	/**
	 * The method printHelp is a case of the user input
         * and will print what the objective of the game is 
         * and what commands that are available if the user types "help"
	 */
	private void printHelp() {
		System.out.println("You're a prisoner inside a prison, and there have just been a riot.");
		System.out.println("Your goal is to break out.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * The method goRoom is a case of the user input
         * and are used when the user types "go" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) { //Tjekker om der er en retning
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord(); //Gemmer det som en string

		Room nextRoom = currentRoom.getExit(direction); //Finder det næste room i hashmappen i Room og angiver denne som nextRoom

		if (nextRoom == null) { //Hvis der ikke er noget room den vej / Hashmappen ikke indeholder nogen value for keyen
			System.out.println("There is no door!");
		} else if (nextRoom.isLocked() == false) {
			if (nextRoom.getEscapeRoom()) {
				//Koden der køres når man er i parkinglot
				System.out.println("There is a codelock locking the door, to get to the parkinglot you need to enter a 3 digit code: ");
				int inputCode = parser.getCode();

				if (inputCode != -1 && inputCode == 111) {

					System.out.println("Congratulations, you have escaped!");
					System.out.println("Type \"quit\" to quit the game");
					currentRoom = nextRoom;

				} else if (inputCode != -1 && inputCode != 111) {
					System.out.println("Wrong code!");
					System.out.println(currentRoom.getLongDescription());

				}
			} else if (nextRoom.getEscapeRoom() == false) {
				currentRoom = nextRoom; //Skifter rum hvis der er et andet rum ud fra den command brugeren gav
				System.out.println(currentRoom.getShortDescription()); //Udskriv beskrivelse og exits af det nye rum
			}
		} else if (nextRoom.isLocked() == true) {
			System.out.println("The door is locked, you can't go in there without a key");

		}

	}

	/**
	 * The quit method is a case of the user input
         * and is used when the user types "quit" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) { //hvis der er skrevet mere end quit
			System.out.println("Quit what?");
			return false;
		} else {
			return true; //hvis der bare er skrevet quit, så quit spillet fuldstændigt.
		}
	}

	/**
	 * The searchRoom method is a case of the user input
         * and is used when the user types "search" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private void searchRoom(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Search what?");
		} else if (!currentRoom.inv.isEmpty()) {  //Hvis der findes items i inv for currentRoom, så printes følgende.        
			System.out.println("You search the room and find something interesting.");
			String items = currentRoom.inv.getAllItems();
			System.out.println("You find the following items.");
			System.out.println(items);
		} else {
			System.out.println("You search the room, but find nothing.");
		}
	}

	/**
	 * The pickUp method is a case of the user input
         * and is used when the user types "pickup" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private void pickUp(Command command) {
		if (command.hasSecondWord() == false) {
			System.out.println("Pick up what?");
		} else {
			try {
				Item item = currentRoom.inv.getItem(command.getSecondWord());
				if (item.getPickUp() == true) {
					player.getInventory().putItem(command.getSecondWord(), item);
					currentRoom.inv.removeItem(command.getSecondWord());
					System.out.println("You pick up " + item.getName());
				}
			} catch (IllegalArgumentException ex) {
				System.out.println("There is no such item.");
			}
		}
	}

	/**
	 * The drop method is a case of the user input
         * and is used when the user types "drop" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private void drop(Command command) {
		if (command.hasSecondWord() == false) {
			System.out.println("Drop what?");
		} else {
			try {
				Item item = player.getInventory().getItem(command.getSecondWord());
				currentRoom.inv.putItem(command.getSecondWord(), item);
				player.getInventory().removeItem(command.getSecondWord());
				System.out.println("You drop " + item.getName());
			} catch (IllegalArgumentException ex) {
				System.out.println("There is no such item.");
			}
		}
	}

	/**
	 * The use method is a case of the user input
         * and is used when the user types "use" as a command
         * @param command is a parameter that needs a command object as an input 
	 */
	private void use(Command command) {
		try {
			if (command.hasSecondWord() == false) {
				System.out.println("Use what?");
			} else {
				Item item = player.getInventory().getItem(command.getSecondWord());

				if (item.getUseable() == true) {
					if (item.getName().equalsIgnoreCase("key")) {
						useKey(command, item);
					} else if (item.getName().equalsIgnoreCase("flashlight")) {
						useFlashlight(command, item);

					} else {
						System.out.println("There's a bug in the items useable boolean " + item.getName());
					}

				} else {
					System.out.println("You can't use that item for anything");
				}
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("You don't have that item in your inventory");
		}

	}
        /**
         * The useKey method is a case when the user types "use" 
         * and is used when the user types "use key" as a command
         * @param command is a parameter that needs a command object as an input 
         * @param key the key is a item you must have in yor inventory
         * to use the command "use key" the key is used as an input to this method
         */
	private void useKey(Command command, Item key) {
		if (command.hasThirdWord() == false) {
			System.out.println("Use " + command.getSecondWord() + " where?");
		} else if (currentRoom.getExit(command.getThirdWord()) != null) {
			Room nextRoom = currentRoom.getExit(command.getThirdWord());
			nextRoom.unlock();
			System.out.println("You successfully unlock the door");
			key.subtractCharge(1);
			if (key.getCharges() <= 0) {
				player.getInventory().removeItem(command.getSecondWord());
			}
		}
	}
        /**
         * The useFlashlight method is a case when the user types "use"
         * and is used when the user types "use flashlight"
         * @param command is a parameter that needs a command object as an input 
         * @param flashlight is a item you must have in your inventory to use the command "use flashlight"
         */
	private void useFlashlight(Command command, Item flashlight) {
		if (flashlight.getCharges() > 0) {
			flashlight.subtractCharge(1);
			System.out.println("You used the flashlight and the battery drained, you think you will have " + flashlight.getCharges() + " use(s) left");
			if (currentRoom.isNumberRoom()) {
				System.out.println("You search the room and find a mysterious number that was hidden");
				System.out.println("The number is " + currentRoom.getNumber());
			} else {
				System.out.println("To your disappointment you find nothing new");
			}

		} else if (flashlight.getCharges() <= 0) {
			System.out.println("You don't have anymore charges in your flashlight");
			System.out.println("if you haven't found anything with it, you will be in trouble");
		}
	}

	/**
	 * The showInventory method will print the items that are currently in the players inventory
	 */
	private void showInventory() {
		System.out.println("Your inventory contains the following:");
		System.out.println(player.getInventory().getAllItems());
	}
}
