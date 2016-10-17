public class Item {

	boolean pickUp;
	String name;
	boolean useable;
	private final int weight;
	int charges = 1;

	public Item(boolean pickUp, String name, boolean useable, int weight) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
		this.weight = weight;
	}
	public Item(boolean pickUp, String name, boolean useable,int weight, int charges) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
		this.weight = weight;
		this.charges = charges;
	}

	public boolean getPickUp() {
		return pickUp;
	}

	public String getName() {
		return name;
	}

	public boolean getUseable() {
		return useable;
	}
	public int getCharges() {
		return this.charges;
	}
	
	public void subtractCharge(int subCharge){
		this.charges -= subCharge;
	}
	public int getWeight() {
		return this.weight;
	}
}
