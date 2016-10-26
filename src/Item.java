
/**
 * An interface that can be used for items in the game. It contains methods that are required for the game to run.
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public interface Item {

	public boolean isWeapon();

	public boolean isKey();

	public boolean isMisc();

	public boolean isFlashlight();

	public boolean isSpecial();

	public String getName();

	public boolean isPickup();

	public boolean isUseable();

	public int getWeight();

	public int getCapacity();

}
