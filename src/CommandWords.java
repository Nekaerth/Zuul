
import java.util.HashMap;

public class CommandWords {

	private HashMap<String, CommandWord> validCommands;

	public CommandWords() {
		validCommands = new HashMap<>(); //Ny HashMap oprettes der indeholder string som key og commandword som value
		for (CommandWord command : CommandWord.values()) { // Alle variable i enum commandword gennemløbes
			if (command != CommandWord.UNKNOWN) { // Hvis det ikke er variablen unknown
				validCommands.put(command.toString(), command); //Læg commanden i hashmappen validcommands
			}
		}
	}

	CommandWord getCommandWord(String commandWord) {
		CommandWord command = validCommands.get(commandWord); //får value i hashmappen baseret på den string metoden kaldes med
		if (command != null) { // hvis commanden kan identificeres
			return command; //return enum commanden
		} else {
			return CommandWord.UNKNOWN; //return enum variablen unknown som indeholder en string "?"
		}
	}

	public boolean isCommand(String aString) {
		return validCommands.containsKey(aString);
	}

	public void showAll() {
		for (String command : validCommands.keySet()) {
			System.out.print(command + "  ");
		}
		System.out.println();
	}
}
