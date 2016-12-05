package Items;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danieln Johansen
 */
public enum WeaponType {
	MELEE("melee"), RANGED("ranged");

	private String stringWeaponType;

	WeaponType(String stringWeaponType) {
		this.stringWeaponType = stringWeaponType;
	}

	@Override
	public String toString() {
		return stringWeaponType;
	}
}
