
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

	private int time;
	public Inventory inventory;
	private ArrayList<String> attacks;

	public Player(int hitpoint, int damage, int time, ArrayList<String> attacks) {
		this.hitpoint = hitpoint;
		this.damage = damage;
		this.time = time;
		this.inventory = new Inventory();
		this.attacks = attacks;
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

	public void addTime(int time) {
		this.time += time;
	}

	public void subtractTime(int time) {
		this.time -= time;
	}
}
