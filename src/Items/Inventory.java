package Items;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Inventory {

	/**
	 * New hashmap is initialized.
	 */
	ObservableList<Item> inventory;

	/**
	 * New hashmap with the name "inventory" is created in the contructor.
	 */
	public Inventory() {
		inventory = FXCollections.observableArrayList();

	}

	/**
	 *
	 * @return HashMap with all items.
	 */
	public ObservableList<Item> getAllItems() {
		return inventory;
	}

	/**
	 * This method returns whether or not the inventory is empty.
	 *
	 * @return A boolean, true if empty and false.
	 */
	public boolean isEmpty() {
		return inventory.isEmpty();
	}

	/**
	 * This method returns the name of an item.
	 *
	 * @param name The parameter name is the reference name to the item requested.
	 * @return the index where the item was found
	 */
//	public int getItem(String name) {
//            for (Item i : inventory) {
//                if (i.getName().equalsIgnoreCase(name)) {
//		return inventory.indexOf(i);
//                }
//            }
//            return -1;            
//	}
	/**
	 * This method will return a list of all items in the inventory.
	 *
	 * @return Returns the list of items in the inventory.
	 */
	public String getStringOfAllItems() {
		String returnString = "Items:";
		for (Item item : inventory) {
			returnString += " " + item.getName();
		}
		return returnString;
	}

	/**
	 * This method will calculate the total weight of items in a inventory.
	 *
	 * @return an integer that is the total weight.
	 */
	public int getItemWeight() {
		int weight = 0;
		for (Item item : inventory) {
			weight += item.getWeight();
		}
		return weight;
	}

	/**
	 * This method returns the amount of items in the inventory.
	 *
	 * @return an integer.
	 */
	public int size() {
		int size = 0;
		size = inventory.size();
		return size;
	}

	/**
	 * This method checks if the inventory contains an item with the name of the
	 * parameter.
	 *
	 * @param name which is a String.
	 * @return a boolean that is true if it contains the item.
	 */
//	public boolean containItem(String name) {
//		return this.inventory.containsKey(name);
//	}
	/**
	 * This method allow you to put an item that you are carrying into an
	 * inventory.
	 *
	 * @param name The parameter name is the reference name to the object.
	 * @param item The parameter item is the object of the class Item.
	 */
	public void putItem(Item item) {
		inventory.add(item);

	}

	/**
	 * This method removes an item from an inventory.
	 *
	 * @param name string, the name of the item to be removed.
	 */
	public void removeItem(Item item) {
		inventory.remove(item);
	}

	/**
	 * Puts all items of the given inventory into this inventory.
	 *
	 * @param inventory the inventory which items should be put into this
	 * inventory.
	 */
	public void putInventory(Inventory inventory) {
		ObservableList<Item> inventoryItems = inventory.getAllItems();
		this.inventory.addAll(inventoryItems);
	}

	/**
	 * Transfer the given item specified by the name given in a String, from the
	 * given inventory to this inventory
	 *
	 * @param inventory an inventory from either a room or a person
	 * @param item
	 *
	 */
	public void transferItem(Inventory inventory, Item item) {
		this.putItem(item);
		inventory.removeItem(item);
	}

	public int getItemCapacity() {
		int capacity = 0;
		for (Item item : inventory) {
			capacity += item.getCapacity();
		}
		return capacity;
	}

}
