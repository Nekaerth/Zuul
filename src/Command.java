package zuul;

public class Command {

    private CommandWord commandWord;
    //private CommandWord commandWord2;
    private String secondWord;

    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        //this.commandWord2 = commandWord2;
        this.secondWord = secondWord;
    }

    public CommandWord getCommandWord() {
        return commandWord;
        //return commandWord2;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
