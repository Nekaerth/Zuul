public class Item {

	boolean pickUp, useable, blueprintsUsed;
	String name;	
	int charges = 1;

	public Item(boolean pickUp, String name, boolean useable) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
		
	}
	public Item(boolean pickUp, String name, boolean useable, int charges) {
		this.name = name;
		this.pickUp = pickUp;
		this.useable = useable;
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
        
        
        
}
