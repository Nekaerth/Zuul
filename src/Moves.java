/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lasse
 */
public enum Moves {

	PUNCH("Punch"), STAB("Stab"), DUCK("Duck"), JUMP("Jump"), SIDESTEP("Side step"), LASH("Lash"), CHARGE("Charge"), SHOOT("Shoot"), DANCE("Dance");

	private String moveString;

	Moves(String moveString) {
		this.moveString = moveString;
	}

	@Override
	public String toString() {
		return moveString;
	}
}
