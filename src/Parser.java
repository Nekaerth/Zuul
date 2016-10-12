
import java.util.Scanner;

public class Parser {

	private CommandWords commands;
	private Scanner reader;

	public Parser() {
		commands = new CommandWords(); //Opretter de commands der findes i spillet, commandsene findes fra enum'en commandWord
		reader = new Scanner(System.in); // en scanner oprettes, der læser i consollen
	}

	public Command getCommand() {
		String inputLine;
		String word1 = null;
		String word2 = null;
                String word3 = null;

		System.out.print("> ");

		inputLine = reader.nextLine(); //Scanner læser input fra consollen

		Scanner tokenizer = new Scanner(inputLine); //Laver ny scanner for at opdele i to strings 
		if (tokenizer.hasNext()) {
			word1 = tokenizer.next();
                        if (tokenizer.hasNext()) {
				word2 = tokenizer.next();
                                if (tokenizer.hasNext()) {
                                    word3 = tokenizer.next();
                                }
			}
		}

		return new Command(commands.getCommandWord(word1), word2, word3); //giver commandword ud fra word 1 og opretter en ny command ud fra commandWord objektet og stringen
	}

	public void showCommands() {
		commands.showAll();
	}

	public int getCode() {

		int inputCode;
		while (reader.hasNext()) {
			if (reader.hasNextInt()) {
				inputCode = reader.nextInt();
				return inputCode;
			} else {
				System.out.println("" + reader.next() + " is not a number");
			}
		}
		return -1;
	}
}
