
import java.util.HashMap;

public class CommandWords {

	private HashMap<String, CommandWord> validCommands;
/**
 * The constructor for commandwords that sorts the different commands into valid commands and unknown commands
 */
	public CommandWords() {
		validCommands = new HashMap<>(); //Ny HashMap oprettes der indeholder string som key og commandword som value
		for (CommandWord command : CommandWord.values()) { // Alle variable i enum commandword gennemløbes
			if (command != CommandWord.UNKNOWN) { // Hvis det ikke er variablen unknown
				validCommands.put(command.toString(), command); //Læg commanden i hashmappen validcommands
			}
		}
	}
	/**
	 * Based on the user input, the method will return a CommandWord object
	 * if the input is recognized as a valid command.
	 * @param commandWord which is a string
	 * @return Returns a CommandWord object, which is UNKNOWN if the input is not recognized as a known command.
	 */
	public CommandWord getCommandWord(String commandWord) {
		CommandWord command = validCommands.get(commandWord); //får value i hashmappen baseret på den string metoden kaldes med
		if (command != null) { // hvis commanden kan identificeres
			return command; //return enum commanden
		} else {
			return CommandWord.UNKNOWN; //return enum variablen unknown som indeholder en string "?"
		}
	}

	/**
	 * checks if the input is a known command or not
	 * @param aString
	 * @return returns true if it is known and false if it isn't
	 */
	public boolean isCommand(String aString) {
		return validCommands.containsKey(aString);
	}

	/**
	 * The method will print out all the valid commands
	 */
	public void showAll() {
		for (String command : validCommands.keySet()) {
			System.out.print(command + "  ");
		}
		System.out.println();
	}
}
