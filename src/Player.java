
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
        private int capacity;
        private int weightCapacity;

	public Player(int hitpoint, ArrayList<Attack> attacks, Inventory inventory, int time, int capacity, int weightCapacity) {
		super(hitpoint, attacks, inventory);
		this.time = time;
                this.capacity = capacity;
                this.weightCapacity = weightCapacity;
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
        public int getCapacity() {
                return this.capacity;
        }
        public int getWeightCapacity() {
                return this.weightCapacity;
        }
	
	public void setPlayerAttacks() {
		ArrayList<Attack> attacks = getAttacks();
		attacks.add(new Attack(Moves.STAB, 10));
		attacks.add(new Attack(Moves.DUCK, 0));
		attacks.add(new Attack(Moves.JUMP, 0));
		attacks.add(new Attack(Moves.SIDESTEP, 0));
	}
}
