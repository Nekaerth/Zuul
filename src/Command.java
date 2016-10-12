
public class Command {

	private CommandWord commandWord;
	//private CommandWord commandWord2;
	private String secondWord;
        private String thirdWord;

	public Command(CommandWord commandWord, String secondWord) {
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
        
        public String getThridWord() {
            return thirdWord;
        }

	public boolean isUnknown() {
		return (commandWord == CommandWord.UNKNOWN);
	}

	public boolean hasSecondWord() {
		return (secondWord != null);
	}
}
