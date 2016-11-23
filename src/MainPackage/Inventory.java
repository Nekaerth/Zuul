package MainPackage;


/**
 * These statements import the Hashmap and set class from the util library.
 */
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public class Inventory {

	/**
	 * New hashmap is initialized.
	 */
	private final HashMap<String, Item> inventory;

	/**
	 * New hashmap with the name "inventory" is created in the contructor.
	 */
	public Inventory() {
		inventory = new HashMap<>();

	}

	/**
	 *
	 * @return HashMap with all items.
	 */
	public HashMap<String, Item> getAllItems() {
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
	 * @return An Item object.
	 */
	public Item getItem(String name) {
		return inventory.get(name);
	}

	/**
	 * This method will return a list of all items in the inventory.
	 *
	 * @return Returns the list of items in the inventory.
	 */
	public String getStringOfAllItems() {
		String returnString = "Items:";
		Set<String> keys = inventory.keySet();
		for (String item : keys) {
			returnString += " " + item;
		}
		return returnString;
	}

	/**
	 * This method will calculate the total weight of items in a inventory.
	 *
	 * @return an integer that is the total weight.
	 */
	public int itemWeight() {
		int weight = 0;
		for (Item item : inventory.values()) {
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
	 * This method checks if the inventory contains an item with the name of the
	 * parameter.
	 *
	 * @param name which is a String.
	 * @return a boolean that is true if it contains the item.
	 */
	public boolean containItem(String name) {
		return this.inventory.containsKey(name);
	}

	/**
	 * This method allow you to put an item that you are carrying into an
	 * inventory.
	 *
	 * @param name The parameter name is the reference name to the object.
	 * @param item The parameter item is the object of the class Item.
	 */
	public void putItem(String name, Item item) {
		inventory.put(name, item);

	}

	/**
	 * This method removes an item from an inventory.
	 *
	 * @param name string, the name of the item to be removed.
	 */
	public void removeItem(String name) {
		inventory.remove(name);
	}

	/**
	 * Puts all items of the given inventory into this inventory.
	 *
	 * @param inventory the inventory which items should be put into this
	 * inventory.
	 */
	public void putInventory(Inventory inventory) {
		HashMap<String, Item> inventoryItems = inventory.getAllItems();
		this.inventory.putAll(inventoryItems);
	}
}
