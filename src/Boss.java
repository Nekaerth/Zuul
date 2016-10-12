
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lasse
 */
public class Boss extends Person {

	private final String name;
	private HashMap<String, String> attacks = new HashMap<>();
	private int damage;

	public Boss(String name, int hitpoint, int damage) {
		this.name = name;
		this.hitpoint = hitpoint;
		this.damage = damage;
		this.attacks = attacks;
	}

	public String getName() {
		return this.name;
	}

	public void setPrisonGuard1Attacks() {
		attacks.put("Lash", "Jump");
		attacks.put("Charge", "Side Step");
		attacks.put("Punch", "Stab");
	}

	public void setPrisonGuard2Attacks() {
		attacks.put("Lash", "Jump");
		attacks.put("Charge", "Side Step");
		attacks.put("Punch", "Stab");
		attacks.put("Shoot", "duck");
	}
}
