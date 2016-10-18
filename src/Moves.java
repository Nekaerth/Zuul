
/**
 *
 * @author Semesterprojektgruppe 13 (Efterår 2016)
 */
public enum Moves {

	PUNCH("Punch"), STAB("Stab"), DUCK("Duck"), JUMP("Jump"), SIDESTEP("Side step"), LASH("Lash"), CHARGE("Charge"), SHOOT("Shoot"), DANCE("Dance"), LAUGH("Laugh");

	private String moveString;

	Moves(String moveString) {
		this.moveString = moveString;
	}

	@Override
	public String toString() {
		return moveString;
	}
}
