
/**
 *
 * @author Niklas
 */
/**
 * This statement import the Hashmap class from the util library.
 */
import java.util.HashMap;
import java.util.Set;

public class Inventory {

	/**
	 * New hashmap is initialized
	 */
	private HashMap<String, Item> inventory;

	/**
	 * New hashmap with the name "inventory" is create in the contructor
	 */
	public Inventory() {
		inventory = new HashMap<>();

	}

	public boolean isEmpty() {
		return inventory.isEmpty();
	}

	/**
	 * This method returns the name of an item
	 *
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

	public int itemWeight() {
		int weight = 0;
		for (Item item : inventory.values()) {
			weight += item.getWeight();
		}
		return weight;
	}

	public int size() {
		int size = 0;
		size = inventory.size();
		return size;
	}

	public boolean containItem(String name) {
		return this.inventory.containsKey(name);
	}

	/**
	 * This method allow you to put an item that you are carrying into an
	 * inventory
	 *
	 * @param name The parameter name is the reference name to the object
	 * @param item The parameter item is the object of the class Item
	 */
	public void putItem(String name, Item item) {
		inventory.put(name, item);

	}

	public void removeItem(String name) {
		inventory.remove(name);
	}
}
