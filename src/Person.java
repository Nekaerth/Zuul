
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
	
	public void subtractHitpoint(int damage) {
		this.hitpoint -= damage;
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

	public String getAttackString() {
		String list = "";
		for (Attack attack : attacks) {
			list += attack.getName() + ", ";
		}
		return list.substring(0, list.length() - 2);
	}

	public Attack getAttack(String attackString) {
		for (Attack attack : attacks) {
			if (attackString.equals(attack.getName())) {
				return attack;
			}
		}
		return null;
	}
}
