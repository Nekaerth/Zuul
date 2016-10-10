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
	
	public Boss(String name, int hitpoint) {
		this.name = name;
		this.hitpoint = hitpoint;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void getRandomAttack() {
		//Skal returnere et tilfældigt angreb
	}
}
