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

	public Room getCurrentRoom();
	
	public ArrayList<NPC> getAllNpc();

	public ObservableList<Item> getCurrentRoomInventory();

	public boolean use(Item item);

	public boolean pickUp(Item item);

	public void drop(Item item);

	public ObservableList<Item> getPlayerInventory();

	public int getTime();

	public String getHelpDescription();

	public void constructWorld(String fileToRead);

	public boolean isBossPresent();

	public void saveHighScore(String name, int highScore);

	public int getHighScore();

	public int getItemCapacity();

	public int getCurrentItemAmount();

	public int getWeightCapacity();

	public int getCurrentWeight();
	
}
