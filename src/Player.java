
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

	public Player(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, int time) {
		super(hitpoint, attacks, inventory);
		this.time = time;
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
	
	public void setPlayerAttacks() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.STAB, 10));
		attacks.add(new Attack(Moves.DUCK, 0));
		attacks.add(new Attack(Moves.JUMP, 0));
		attacks.add(new Attack(Moves.SIDESTEP, 0));
	}
}
