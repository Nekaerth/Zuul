
public enum CommandWord {

	/**
	 *
	 */
	GO("go"), QUIT("quit"), HELP("help"), SEARCH("search"), UNKNOWN("?"), PICKUP("pickup");

	private String commandString;

	CommandWord(String commandString) {
		this.commandString = commandString;
	}

	public String toString() {
		return commandString;
	}
}
