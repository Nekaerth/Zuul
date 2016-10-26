
/**
 * These statements import the Hashmap and set class from the util library.
 */
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Inventory {

	/**
	 * New hashmap is initialized
	 */
	private HashMap<String, Item> inventory;

	/**
	 * New hashmap with the name "inventory" is created in the contructor
	 */
	public Inventory() {
		inventory = new HashMap<>();

	}

	/**
	 * This method returns whether or not the inventory is empty
	 * @return A boolean, true if empty and false
	 */
	public boolean isEmpty() {
		return inventory.isEmpty();
	}

	/**
	 * This method returns the name of an item
	 * @param name The parameter name is the reference name to the item requested.
	 * @return An Item object
	 */
	public Item getItem(String name) {
		if (inventory.get(name) != null) {
			return inventory.get(name);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method will return a list of all items in the inventory.
	 *
	 * @return Returns the list of items in the inventory
	 */
	public String getAllItems() {
		String returnString = "Items:";
		Set<String> keys = inventory.keySet();
		for (String item : keys) {
			returnString += " " + item;
		}
		return returnString;
	}

	/**
	 * This method will calculate the total weight of items in a inventory
	 * @return an integer that is the total weight
	 */
	public int itemWeight() {
		int weight = 0;
		for (Item item : inventory.values()) {
			weight += item.getWeight();
		}
		return weight;
	}

	/**
	 * This method returns the amount of items in the inventory
	 * @return an integer
	 */
	public int size() {
		int size = 0;
		size = inventory.size();
		return size;
	}

	/**
	 * This method checks if the inventory contains
	 * an item with the name of the parameter
	 * @param name which is a String
	 * @return a boolean that is true if it contains the item
	 */
	public boolean containItem(String name) {
		return this.inventory.containsKey(name);
	}

	/**
	 * This method allow you to put an item that you are carrying into an
	 * inventory
	 * @param name The parameter name is the reference name to the object
	 * @param item The parameter item is the object of the class Item
	 */
	public void putItem(String name, Item item) {
		inventory.put(name, item);

	}

	/**
	 * This method removes an item from an inventory
	 * @param name string, the name of the item to be removed
	 */
	public void removeItem(String name) {
		inventory.remove(name);
	}
}
