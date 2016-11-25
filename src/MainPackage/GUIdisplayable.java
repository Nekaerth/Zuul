/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Items.Item;
import javafx.collections.ObservableList;

/**
 *
 * @author Niklas
 */
public interface GUIdisplayable {
    
    public boolean goRoom(String direction);
    
    public String getCurrentRoom();
    
    public ObservableList<Item> getCurrentRoomInventory();
    
    public void use(Item item);
    
    public void pickUp(Item item);
    
    public void drop(Item item);
    
    public ObservableList<Item> getPlayerInventory();
    
    public int getTime();
    
    public String getHelpDescription();
    
    public void constructWorld(String fileToRead);
    
    public boolean isBossPresent();
    
}
