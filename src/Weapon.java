
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Weapon implements Item {

	private boolean key, weapon, misc, pickup, useable;
	private int weight, capacity, damage;
	private String name, weaponType;

	public Weapon(boolean pickup, String name, boolean useable, int weight, int capacity, int damage, String weaponType) {
		this.pickup = pickup;
		this.name = name;
		this.weight = weight;
		this.capacity = capacity;
		this.useable = useable;
		this.damage = damage;
		this.weaponType = weaponType;
	}

	@Override
	public boolean isWeapon() {
		return true;
	}

	@Override
	public boolean isKey() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isMisc() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isFlashlight() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isPickup() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isUseable() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getWeight() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getCapacity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public String weaponType() {
		return weaponType;
	}

	public int getDamage() {
		return damage;
	}

}
