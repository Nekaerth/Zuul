
import java.util.Scanner;

/**
 * The Parser class is used to get input from the user, and turning these inputs
 * into objects of Command or String's.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Parser {

	private CommandWords commands;
	private Scanner reader;

	/**
	 * The constructor of the parser
	 */
	public Parser() {
		commands = new CommandWords(); //Opretter de commands der findes i spillet, commandsene findes fra enum'en commandWord
		reader = new Scanner(System.in); // en scanner oprettes, der læser i consollen
	}

	/**
	 * This method asks the user for input, and returns an object of Command
	 *
	 * @return an object of Command
	 */
	public Command getCommand() {
		String inputLine;
		String word1 = null;
		String word2 = null;
		String word3 = null;

		System.out.print("> ");

		inputLine = reader.nextLine(); //Scanner læser input fra consollen

		for (String command : commands.getValidCommands()) {
			int commandLength = command.length();
			int inputLength = inputLine.length();
			if (inputLength >= commandLength && command.equalsIgnoreCase(inputLine.substring(0, commandLength))) {
				word1 = command;
				String[] inputRest;
				if (inputLength > commandLength && inputLine.substring(commandLength, commandLength + 1).equals(" ")) {
					inputRest = inputLine.substring(commandLength + 1).split(" ");
					if (inputRest.length >= 1) {
						word2 = inputRest[0];
					}
					if (inputRest.length >= 2) {
						word3 = inputRest[1];
					}
				}
				break;
			}
		}

		if (word2 != null) { //hvis ord 2 er andet end ikke noget:
			word2 = capitalized(word2); //kalder på capitalized af word 2
		}
		if (word3 != null) { //hvis ord 3 er andet end ikke noget:
			word3 = capitalized(word3); //kalder på capitalized af word3
		}
		if (word1 != null) { //hvis ord 1 er andet end ikke noget:
			word1 = word1.toLowerCase(); //vi sætter word1 til lowercase
		}
		return new Command(commands.getCommandWord(word1), word2, word3); //giver commandword ud fra word 1 og opretter en ny command ud fra commandWord objektet og stringen
	}

	public void showCommands() {
		commands.showAll();
	}

	/**
	 * This method will ask for an input through a scanner object and the input is
	 * required to be a set of numbers that will be saved to a string
	 *
	 * @return a string of numbers
	 */
	public String getCode() {
		System.out.println("> ");
		String inputCode;
		while (reader.hasNext()) {
			if (reader.hasNextInt()) {
				inputCode = reader.nextLine();
				return inputCode;
			} else {
				System.out.println("" + reader.next() + " is not a number");
			}
		}
		return null;
	}

	/**
	 * This method capitalizes the first letter in every word in the string that
	 * is sent as a parameter
	 *
	 * @param a string to be capitalized
	 * @return a string that has been capitalized
	 */
	private String capitalized(String inputString) {
		char ch;       // En af karakterne i strengen (str)
		char prevCh;   // Karakteren der befinder sig før ch i strengen
		prevCh = '.';  // Prime the loop with any non-letter character. 
		String returnString = ""; // Vi sætter strengen til andet end null
		for (int i = 0; i < inputString.length(); i++) { // Laver et for-loop der tjekker alle karaktererne igennem i ordene
			ch = inputString.charAt(i);
			if (Character.isLetter(ch) && !Character.isLetter(prevCh)) { // Hvis karakteren man har fat i nu er et bogstav, og hvis den forrige karakter ikke er et bogstav:
				returnString += Character.toUpperCase(ch); // Så skal den sætte det til et stortbogstav
			} else {
				returnString += Character.toLowerCase(ch); // Eller så skal den sætte det til et lille bogstav
			}
			prevCh = ch;	// prevCh for next iteration is ch.
		}
		return returnString;
	}
}
