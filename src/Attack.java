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

	private Moves move = null;
	private Moves counterMove = null;
	private int damage;

	public Attack(Moves move, int damage) {
		this.move = move;
		this.damage = damage;
	}

	public Attack(Moves move, Moves counterMove, int damage) {
		this.move = move;
		this.counterMove = counterMove;
		this.damage = damage;
	}

	public String getName() {
		return this.move.toString();
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
