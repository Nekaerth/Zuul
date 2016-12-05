/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

/**
 *
 * @author Danieln Johansen
 */
class RoomContainment {

	private String id;
	private String name;
	private boolean locked;
	private boolean escapeRoom;
	private boolean containsHiddenNumber;
	private boolean hidden;
	private String[] linkedID;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the locked
	 */
	public boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(String locked) {
            this.locked = locked.equalsIgnoreCase("true");
        }

	/**
	 * @return the escapeRoom
	 */
	public boolean getEscapeRoom() {
		return escapeRoom;
	}

	/**
	 * @param escapeRoom the escapeRoom to set
	 */
	public void setEscapeRoom(String escapeRoom) {
            this.escapeRoom = escapeRoom.equalsIgnoreCase("true");
	}

	/**
	 * @return the numberRoom
	 */
	public boolean getContainsHiddenNumber() {
		return containsHiddenNumber;
	}

	/**
	 * @param numberRoom the numberRoom to set
	 */
	public void setContainsHiddenNumber(String containsHiddenNumber) {
            this.containsHiddenNumber = containsHiddenNumber.equalsIgnoreCase("true");
	}

	/**
	 * @return the linkedID
	 */
	public String[] getLinkedID() {
		return linkedID;
	}

	/**
	 * @param linkedID the linkedID to set
	 */
	public void setLinkedID(String[] linkedID) {
		this.linkedID = linkedID;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
            this.hidden = hidden.equalsIgnoreCase("true");		
	}
}
