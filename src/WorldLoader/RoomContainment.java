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
	private String description;
	private boolean locked;
	private boolean escapeRoom;
	private boolean numberRoom;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		switch (locked.toLowerCase()) {
			case "true":
				this.locked = true;
				break;
			case "false":
				this.locked = false;
				break;
			default:
				System.out.println("Error in locked boolean in creating worlds");
		}
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
		switch (escapeRoom.toLowerCase()) {
			case "true":
				this.escapeRoom = true;
				break;
			case "false":
				this.escapeRoom = false;
				break;
			default:
				System.out.println("Error in escapeRoom boolean in creating worlds");
		}
	}

	/**
	 * @return the numberRoom
	 */
	public boolean getNumberRoom() {
		return numberRoom;
	}

	/**
	 * @param numberRoom the numberRoom to set
	 */
	public void setNumberRoom(String numberRoom) {
		switch (numberRoom.toLowerCase()) {
			case "true":
				this.numberRoom = true;
				break;
			case "false":
				this.numberRoom = false;
				break;
			default:
				System.out.println("Error in numberRoom boolean in creating worlds");
		}
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
            switch (hidden.toLowerCase()) {
			case "true":
				this.hidden = true;
				break;
			case "false":
				this.hidden = false;
				break;
			default:
				System.out.println("Error in hidden boolean in creating worlds");
		}
        }
	/**
	 *Empties the RoomContainment values, so it's ready to save a new room
	 */
	public void flush() {
		this.description = null;
		this.escapeRoom = false;
		this.id = null;
		this.linkedID = null;
		this.locked = false;
		this.name = null;
		this.numberRoom = false;
                this.hidden = false;
	}
}