
/**
 * The enum is a special type of class.
 * It contains variables that can't be changed
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public enum CommandWord {

	GO("go"), QUIT("quit"), HELP("help"), SEARCH("search"), UNKNOWN("?"), PICKUP("pick up"), DROP("drop"), USE("use"), INVENTORY("inventory"), TIME("time");
	// this is a list of all the constants that is declared in the enum CommandWord

	private String commandString;

	/**
	 * Constructor for enums. The constructor is automatically run the first time
	 * you encounter an enum
	 *
	 * @param a string commandString
	 */
	CommandWord(String commandString) {
		this.commandString = commandString;
	}

	/**
	 * toString returns the enum value as a string
	 *
	 * @return a string, that is the enum value.
	 */
	@Override
	public String toString() {
		return commandString;
	}
}
