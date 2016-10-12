
import java.util.ArrayList;
import java.util.HashMap;

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

	public Boss(String name, int hitpoint, int damage, HashMap<String, String> attacks) {
		this.name = name;
		this.hitpoint = hitpoint;
		this.damage = damage;
		this.attacks = attacks;
	}

	public String getName() {
		return this.name;
	}

	public void getRandomAttack() {
		//Skal returnere et tilfældigt angreb
	}
}
