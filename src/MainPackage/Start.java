package MainPackage;
import WorldLoader.WorldLoader;
import java.util.ArrayList;

/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Start {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		WorldLoader wl = new WorldLoader();
		wl.loadWorld();
		ArrayList<Room> rooms = wl.connectWorld();
		Game game = new Game(rooms);
		game.play();
	}

}
