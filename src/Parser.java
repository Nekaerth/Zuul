
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
    
    //Denne metode vil tjekke vores ord (word1, word2 og word3) igennem, og sætte dem som uppercase/lowercase
    //hvis karakteren man har fat i er et bogstav, og hvis den forrige karakter ikke er et bogstav,
    //skal den sætte det til stortbogstav, eller et lille bogstav.
    private String capitalized(String str) { 
        char ch;       // En af karakterne i strengen (str)
        char prevCh;   // Karakteren der befinder sig før ch i strengen
        int i;         // Positionen i str, from 0 til str.length ()-1
        prevCh = '.';  // Prime the loop with any non-letter character. 
        String returnString = ""; // Vi sætter strengen til andet end null
        for (i = 0; i < str.length(); i++) { // Laver et for-loop der tjekker alle karaktererne igennem i ordene
            ch = str.charAt(i);
            if (Character.isLetter(ch) && !Character.isLetter(prevCh)) { // Hvis karakteren man har fat i nu er et bogstav, og hvis den forrige karakter ikke er et bogstav:
                returnString += Character.toUpperCase(ch); // Så skal den sætte det til et stortbogstav
            } else {
                returnString += Character.toLowerCase(ch); // Eller så skal den sætte det til et lille bogstav
            }
            prevCh = ch;  // prevCh for next iteration is ch.
        }
        return returnString;
    }
}
