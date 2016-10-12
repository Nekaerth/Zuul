
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
	private ArrayList<Attack> attacks = new ArrayList<>();

	public Player(int hitpoint, int time) {
		this.hitpoint = hitpoint;
		this.time = time;
		this.inventory = new Inventory();
		attacks.add(new Attack("Stab", 10));
		attacks.add(new Attack("Duck", 0));
		attacks.add(new Attack("Jump", 0));
		attacks.add(new Attack("Side step", 0));
	}

	public void setStabDamage(int damage) {
		attacks.get(0).setDamage(damage);
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
