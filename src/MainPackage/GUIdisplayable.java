/*
 * The interface GUIdisplayable is used to determine the methods, returntypes
 * and arguments of the method that the facade class must contain.
 * The facade class is the link between the back-end and the front-end system.
 */
package MainPackage;

import HighscoreLoader.Score;
import Items.Item;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public interface GUIdisplayable {

	public boolean goRoom(Direction direction);

	public ArrayList<NPC> getAllNpc();

	public ObservableList<Item> getCurrentRoomInventory();

	public boolean use(Item item);

	public boolean pickUp(Item item);

	public void drop(Item item);

	public String getHelpDescription();

	public void constructWorld(String fileToRead);

	public void saveHighScore(String name, int highScore);

	public ObservableList<Score> getHighScoreList();

	public int calculateHighScore();

	public Player getPlayer();

	public ArrayList<Boss> getBosses();

	public boolean isCodeCorrect(String userCode);

	public ObservableList<String> getListOfFiles();
}
