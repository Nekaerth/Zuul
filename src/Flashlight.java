/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danieln Johansen
 */
public class Flashlight extends Item {
	private int charges;
	
	public Flashlight(boolean pickUp, String name, boolean useable, int charges) {
		super(pickUp, name, useable);
		this.charges = charges;
		
	}
	
}
