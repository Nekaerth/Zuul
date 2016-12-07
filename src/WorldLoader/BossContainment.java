/**
 * The BossContainment class is used to set and return values of the atributes 
 * related to a boss
 * 
 * @author Termprojectgroup 13 (autum 2016)
 */
package WorldLoader;

import MainPackage.BossType;

public class BossContainment {

	private String roomId, name;
	private int hitpoints;
	private BossType bossType;

	/**
         * The getRoomId is used to get the roomId where a boss is located
	 * @return the roomId where a boss is located
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
         * The setRoomId is ued to set the roomId for where a boss is located
	 * @param roomId the roomId where a boss is
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
         * The getName method is used to return the name of the boss
	 * @return the name of the boss
	 */
	public String getName() {
		return name;
	}

	/**
         * The setName method is used to set the name of of boss
	 * @param name a String with the name of the boss
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
         * The getHitpoints is used to return the amount of hitPoints the boss has 
	 * @return the amount of hitpoints
	 */
	public int getHitpoints() {
		return hitpoints;
	}

	/**
         * The setHitpoints method is used to set the amount of hitpoints a boss has
	 * @param hitpoints the hitpoints to set
	 */
	public void setHitpoints(String hitpoints) {
		this.hitpoints = Integer.parseInt(hitpoints);
	}

	/**
         * The getBossType is used to return the bossType of a boss
	 * @return the bossType of a boss
	 */
	public BossType getBossType() {
		return bossType;
	}

	/**
         * The setBossType is used to set the type of a boss
	 * @param bossType is a String that must be equal to a value in the enum
         * BossType to set the bossType
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
