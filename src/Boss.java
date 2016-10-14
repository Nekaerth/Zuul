
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
public class Boss extends Person {

	private final String name;

	public Boss(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, String name) {
		super(hitpoint, attacks, inventory);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrisonGuard1Attacks() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.LASH, Moves.JUMP, 10));
		attacks.add(new Attack(Moves.CHARGE, Moves.SIDESTEP, 10));
		attacks.add(new Attack(Moves.PUNCH, Moves.STAB, 10));
	}

	public void setPrisonGuard2Attacks() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.LASH, Moves.JUMP, 10));
		attacks.add(new Attack(Moves.CHARGE, Moves.SIDESTEP, 10));
		attacks.add(new Attack(Moves.PUNCH, Moves.STAB, 10));
		attacks.add(new Attack(Moves.SHOOT, Moves.DUCK, 10));
	}
}
