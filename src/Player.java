
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
public class Player extends Person {

	private int damage;
	private int time;
	private Inventory inventory;

	public Player(int hitpoint, int damage, int time) {
		this.hitpoint = hitpoint;
		this.damage = damage;
		this.time = time;
		this.inventory = new Inventory();
		this.attacks = new ArrayList<Attack>();
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
