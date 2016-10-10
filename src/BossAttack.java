/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lasse
 */
public class BossAttack {

	private final String name;
	private PlayerAttack counterAttack;

	public BossAttack(String name, PlayerAttack counterAttack) {
		this.name = name;
		this.counterAttack = counterAttack;
	}
}
