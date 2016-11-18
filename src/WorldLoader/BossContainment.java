/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import MainPackage.BossType;

/**
 *
 * @author Danieln Johansen
 */
public class BossContainment {
	
	private String roomId, name;
	private int hitpoints;
	private BossType bossType;

	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hitpoints
	 */
	public int getHitpoints() {
		return hitpoints;
	}

	/**
	 * @param hitpoints the hitpoints to set
	 */
	public void setHitpoints(String hitpoints) {
		this.hitpoints = Integer.parseInt(hitpoints);
	}
	
	public void flush(){
		roomId = null;
		name = null;
		hitpoints = 0;
	}

	/**
	 * @return the bossType
	 */
	public BossType getBossType() {
		return bossType;
	}

	/**
	 * @param bossType the bossType to set
	 */
	public void setBossType(String bossType) {
		  bossType = bossType.toLowerCase();
        for (BossType i : BossType.values()) {
            if (bossType.equalsIgnoreCase(i.toString())) {
                this.bossType = i;
            }
        }
	}
	
	
	
}
