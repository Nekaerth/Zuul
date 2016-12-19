package Items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Inventory {

	ObservableList<Item> inventory;

	/**
	 * New ObservableList with the name "inventory" is created in the contructor.
	 */
	public Inventory() {
		inventory = FXCollections.observableArrayList();

	}

	/**
	 * Returns an observable list of all the items in the inventory
	 *
	 * @return ObservableList with all items.
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
	 * This method will calculate the total weight of items in a inventory.
	 *
	 * @return an integer that is the total weight.
	 */
	public int getTotalItemWeight() {
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
		return inventory.size();
	}

	/**
	 * Adds a given item to the inventory
	 *
	 * @param item The parameter item is the item to add.
	 */
	public void putItem(Item item) {
		inventory.add(item);
	}

	/**
	 * The given item is removed from the inventory.
	 *
	 * @param item The item to remove
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
	 * Transfer the given item from the given inventory to this inventory
	 *
	 * @param inventory an inventory from either a room or a person
	 * @param item the item to transfer from one inventory to another
	 *
	 */
	public void transferItem(Inventory inventory, Item item) {
		this.putItem(item);
		inventory.removeItem(item);
	}

	/**
	 * Returns the total capacity of all the items in the inventory
	 *
	 * @return int The total capacity of all items in the inventory
	 */
	public int getTotalItemCapacity() {
		int capacity = 0;
		for (Item item : inventory) {
			capacity += item.getCapacity();
		}
		return capacity;
	}
}
