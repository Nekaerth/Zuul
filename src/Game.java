package zuul;

public class Game {

	private final Parser parser;
	private Room currentRoom;

	public Game() //Constructor
	{
		createRooms();
		parser = new Parser();
	}

	private void createRooms() //Kaldes fra constructor
	{
		Room cell, cellhall, dininghall, yard, office, storage, parkinglot, hiddenroom, bossroom; //Fem rum oprettes

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
		//cell.inv.putItem("stone", new Item(true, "stone", false));
		cell.inv = setCellInventory();

		hiddenroom.setExit("Bossroom", bossroom);
		hiddenroom.setExit("Cell", cell);
		hiddenroom.inv.putItem("flashlight", new Item(true, "flashlight", true));

		bossroom.setExit("Hiddenroom", hiddenroom);

		dininghall.setExit("Cellhall", cellhall);

		cellhall.setExit("Dininghall", dininghall);
		cellhall.setExit("Yard", yard);
		cellhall.setExit("Office", office);

		office.setExit("Storage", storage);
		office.setExit("Cellhall", cellhall);

		yard.setExit("Parkinglot", parkinglot);
		yard.setExit("Cellhall", cellhall);

		storage.setExit("Office", office);

		parkinglot.setEscapeRoom();

		currentRoom = cell; //currentRoom er den variabel der holder styr på hvilket rum man er i.
	}

	private Inventory setCellInventory() {
		Inventory inv = new Inventory();
		inv.putItem("Stone", new Item(true, "Stone", true));
		return inv;
	}

	public void play() {
		printWelcome(); //Kalder metoden

		boolean finished = false;
		while (!finished) { //Et loop der kører så længe spillet ikke er færdigt
			Command command = parser.getCommand(); //Får command baseret på brugerens input, og modtager det som et objekt command
			finished = processCommand(command); //processer commanden
		}
		System.out.println("Thank you for playing.  Good bye."); //Hvis der quittes
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("You wake up and realize there's a prisonriot going on. Now's your chance to escape!");
		System.out.println("Hurry! you have limmited time to escape, before the warden gets everything under control again.");
		System.out.println("Type '" + CommandWord.HELP + "' if you need help."); //commandWord.HELP er en variabel i commandword
		System.out.println();
		System.out.println(currentRoom.getLongDescription()); // Giver beskrivelse af rummet + exit muligheder
	}

	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord(); //Får command ordet og gemmer det i objektet commandword ud fra objektet command

		if (commandWord == CommandWord.UNKNOWN) { //Hvis det er unknown
			System.out.println("I don't know what you mean...");
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
				default:
					break;
			}
		}
		return wantToQuit; //return boolean, som under go og help commanden ikke ændres fra false
	}

	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at the university.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	private void goRoom(Command command) {
		if (!command.hasSecondWord()) { //Tjekker om der er en retning
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord(); //Gemmer det som en string

		Room nextRoom = currentRoom.getExit(direction); //Finder det næste room i hashmappen i Room og angiver denne som nextRoom

		if (nextRoom == null) { //Hvis der ikke er noget room den vej / Hashmappen ikke indeholder nogen value for keyen
			System.out.println("There is no door!");
		} else {
			if (nextRoom.getEscapeRoom()) {
				//Koden der køres når man er i parkinglot
				System.out.println("There is a codelock locking the door, to get to the parkinglot you need to enter a 3 digit code: ");
				int inputCode = parser.getCode();

				if (inputCode != -1 && inputCode == 111) {

					System.out.println("Congratulations, you have escaped!");
					System.out.println("Type \"quit\" to quit the game");
					currentRoom = nextRoom;
					return;

				} else if (inputCode != -1 && inputCode != 111) {
					System.out.println("Wrong code!");
					return;
				}
			}

			currentRoom = nextRoom; //Skifter rum hvis der er et andet rum ud fra den command brugeren gav
			System.out.println(currentRoom.getLongDescription()); //Udskriv beskrivelse og exits af det nye rum
		}
	}

	private boolean quit(Command command) {
		if (command.hasSecondWord()) { //hvis der er skrevet mere end quit
			System.out.println("Quit what?");
			return false;
		} else {
			return true; //hvis der bare er skrevet quit, så quit spillet fuldstændigt.
		}
	}

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

}