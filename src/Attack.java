
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public enum Attack {

	PUNCH("Punch"), STAB("Stab"), DUCK("Duck"), JUMP("Jump"), SIDESTEP("Side step"), LASH("Lash"), CHARGE("Charge"), SHOOT("Shoot"), LAUGH("Laugh");

	private String attackString;

	Attack(String attackString) {
		this.attackString = attackString;
	}

	@Override
	public String toString() {
		return attackString;
	}
}
