
public enum CommandWord {

	/**
	 *
	 */
	GO("go"), QUIT("quit"), HELP("help"), SEARCH("search"), UNKNOWN("?"), PICKUP("pickup"), DROP("drop"), USE("use"), INVENTORY("inventory");

	private String commandString;

	CommandWord(String commandString) {
		this.commandString = commandString;
	}

	@Override
	public String toString() {
		return commandString;
	}
}
