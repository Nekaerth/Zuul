
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lasse
 */
public class Person {

	private int hitpoint;
	private ArrayList<Attack> attacks;
	private Inventory inventory;

	public Person(int hitpoint, ArrayList<Attack> attacks, Inventory inventory) {
		this.hitpoint = hitpoint;
		this.attacks = attacks;
		this.inventory = inventory;
	}

	public int getHitpoint() {
		return hitpoint;
	}

	public void setHitpoint(int hitpoint) {
		this.hitpoint = hitpoint;
	}
	
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(int Inventory) {
		this.inventory = inventory;
	}
}
