
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
   
   public Inventory () {
       /**
        * New hashmap with the name "inventory" is create in the contructor
        */
     inventory =  new HashMap<>();
     
   }

    /*
     
     
     
    public int showAllItems () {
        for(String inv : inventory.keySet()) {
            System.out.print(inv + "  ");
        }
       System.out.println(" ");
       return -1;
   }
   */
   public boolean isEmpty(){
       return inventory.isEmpty();
   }
   
   /**
    * This method returns the name of an item
    * @param name The parameter name is the reference name to the item requested.
     * @return An Item object
    */
   public Item getItem (String name) {
       return inventory.get(name);
       
   }
/**
 * This method will return a list of all items in the inventory.
 * @return Returns the list of items in the inventory
 */
   public String getAllItems () {
    String returnString = "Items:";
        Set<String> keys = inventory.keySet();
        for (String item : keys) {
            returnString += " " + item;
        }
        return returnString;   
}
   /**
    * This method allow you to put an item that you are carrying into an inventory
    * @param name The parameter name  is the reference name to the object
    * @param item The parameter item is the object of the class Item 
    */
   public void putItem (String name, Item item) {
       
      inventory.put(name, item);
       
   }
}
