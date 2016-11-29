/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Niklas
 */
public enum BossType {
	BOSSTYPE1("bosstype1"), BOSSTYPE2("bosstype2");

	private String stringBossType;

	BossType(String stringBossType) {
		this.stringBossType = stringBossType;
	}

	@Override
	public String toString() {
		return stringBossType;
	}

}
