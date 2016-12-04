/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Items.Item;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Niklas
 */
public interface GUIdisplayable {

	public boolean goRoom(String direction);

	public ArrayList<NPC> getAllNpc();

	public ObservableList<Item> getCurrentRoomInventory();

	public boolean use(Item item);

	public boolean pickUp(Item item);

	public void drop(Item item);

	public int getTime();

	public String getHelpDescription();

	public void constructWorld(String fileToRead);

	public void saveHighScore(String name, int highScore);

	public ObservableList<String> getHighScoreList();

	public int getHighScore();

	public Player getPlayer();

	public boolean isBossPresent();

	public ArrayList<Boss> getBosses();

	public void compareMoves(Boss boss, Move bossMove, Move playerMove);
}
