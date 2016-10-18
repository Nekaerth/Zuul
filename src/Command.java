
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Command {

	private CommandWord commandWord;
	//private CommandWord commandWord2;
	private String secondWord;
	private String thirdWord;

	public Command(CommandWord commandWord, String secondWord, String thirdWord) {
		this.commandWord = commandWord;
		//this.commandWord2 = commandWord2;
		this.secondWord = secondWord;
		this.thirdWord = thirdWord;

	}

	public CommandWord getCommandWord() {
		return commandWord;
		//return commandWord2;
	}

	public String getSecondWord() {
		return secondWord;
	}

	public String getThirdWord() {
		return thirdWord;
	}

	public boolean isUnknown() {
		return (commandWord == CommandWord.UNKNOWN);
	}

	public boolean hasSecondWord() {
		return (secondWord != null);
	}

	public boolean hasThirdWord() {
		return (thirdWord != null);
	}
}
