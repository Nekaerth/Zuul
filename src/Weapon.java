
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public class Weapon implements Item {
	private boolean pickup, useable;
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
		return false;
	}

	@Override
	public boolean isMisc() {
		return false;
	}

	@Override
	public boolean isFlashlight() {
		return false;
		
	}

	@Override
	public boolean isSpecial(){
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isPickup() {
		return this.pickup;
	}
	
	@Override
	public boolean isUseable(){
		return this.useable;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}
	
	public String weaponType(){
		return weaponType;
	}

	public int getDamage() {
		return damage;
	}

}
