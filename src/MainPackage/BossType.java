/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public enum BossType {
	BOSSTYPE1("bosstype1"), BOSSTYPE2("bosstype2");

	private String stringBossType;

	/**
	 * The contructor of the Enum BoosType. It is automatically called when a Enum
	 * is used
	 *
	 * @param stringBossType
	 */
	BossType(String stringBossType) {
		this.stringBossType = stringBossType;
	}

	/**
	 * Returns a string representation of an BossType. The representation is a
	 * String version of the enum BossType
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return stringBossType;
	}
}
