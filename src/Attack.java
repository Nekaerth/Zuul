/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lasse
 */
public class Attack {
	
	private final String name;
	private int bossDamage;
	Attack playerCounterAttack;
	
	//Use this constructor to create boss attack
	public Attack(String name, int bossDamage) {
		this.name = name;
		this.bossDamage = bossDamage;
	}
	
	//Use this contructor to create player attack
	public Attack(String name, Attack playerCounterAttack) {
		this.name = name;
		this.playerCounterAttack = playerCounterAttack;
	}
	
}
