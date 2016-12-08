/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
