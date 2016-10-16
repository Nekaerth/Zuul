/**
 * The enum is a special type of class
 * it contains variables that can't be changed
 */
public enum CommandWord {
	
	GO("go"), QUIT("quit"), HELP("help"), SEARCH("search"), UNKNOWN("?"), PICKUP("pickup"), DROP("drop"), USE("use"), INVENTORY("inventory");
        // this is a list of all the constants that is declared in the enum CommandWord
        
	private String commandString;

	CommandWord(String commandString) {
		this.commandString = commandString;
	}

	@Override
	public String toString() {
		return commandString;
	}
}
