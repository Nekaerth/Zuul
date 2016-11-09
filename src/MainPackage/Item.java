package MainPackage;


/**
 * An interface that can be used for items in the game. It contains methods that are required for the game to run.
 *
 * @author Semesterprojektgruppe 13 (Autumn 2016)
 */
public interface Item {

	public ItemType getType();

	public String getName();

	public boolean isPickup();

	public boolean isUseable();

	public int getWeight();

	public int getCapacity();

}
