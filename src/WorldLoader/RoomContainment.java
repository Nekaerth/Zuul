/**
 * The RoomContainment class is used to set and return information 
 * about a rooms attributes.
 * 
 * @author Termproject Group 13 (Autumn 2016)
 */
package WorldLoader;

class RoomContainment {

	private String id;
	private String name;
	private boolean locked;
	private boolean escapeableRoom;
	private boolean containsHiddenNumber;
	private boolean hidden;
	private String[] linkedID;

	/**
         * The get getId method is used to get the id of a room
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
         * The setId method is used to set at the id for a specific room
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
         * The getName method is used to get the name of a room.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
         * The setName method is used to set the name of a specific room
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
         * The getLocked method is used to get the currect state of the locked boolean
         * for a specific room
	 * @return the boolean locked
	 */
	public boolean getLocked() {
		return locked;
	}

	/**
         * The setLocked method is used to set a the state of the locked boolean for a specific room
	 * @param locked is the String that will set the value of the boolean
	 */
	public void setLocked(String locked) {
            this.locked = locked.equalsIgnoreCase("true");
        }

	/**
         * The isEscapeableRoom method is used to get the current state 
 of the escapeRoom boolean for a specific room
	 * @return the boolean escapeRoom
	 */
	public boolean isEscapeableRoom() {
		return escapeableRoom;
	}

	/**
         * The setEscapeableRoom method is used to set the state of the boolean 
 escapeRoom for a specific room
	 * @param escapeRoom is the String that will set the value of the boolean
	 */
	public void setEscapeableRoom(String escapeRoom) {
            this.escapeableRoom = escapeRoom.equalsIgnoreCase("true");
	}

	/**
         * The getContainsHiddenNumber method is used the get the state of the boolean
         * containsHidden for a specific room
	 * @return the boolean containsHiddenNumber
	 */
	public boolean getContainsHiddenNumber() {
		return containsHiddenNumber;
	}

	/**
         * The setContainsHiddenNumber method is used to set the state of the 
         * containsHiddenNumber boolean for a specific room
	 * @param containsHiddenNumber is the String that will set the value of the boolean
	 */
	public void setContainsHiddenNumber(String containsHiddenNumber) {
            this.containsHiddenNumber = containsHiddenNumber.equalsIgnoreCase("true");
	}

	/**
         * The getLinkedID method is used to get an Array of Strings over the links 
         * for a specific room
	 * @return the Array of Strings in linkedID
	 */
	public String[] getLinkedID() {
		return linkedID;
	}

	/**
         * The setLinkedID method is used to set the Array of Strings in linkedID
         * for a specific room
	 * @param linkedID the linkedID to set
	 */
	public void setLinkedID(String[] linkedID) {
		this.linkedID = linkedID;
	}

        /**
         * The isHidden method is used to get the current state of the hidden boolean
         * for a specific room
         * @return will return the state of hidden
         */
	public boolean isHidden() {
		return hidden;
	}

        /**
         * The setHidden method is used to set the state of hidden for a specific room
         * @param hidden is the String that will set the value of the boolean
         */
	public void setHidden(String hidden) {
            this.hidden = hidden.equalsIgnoreCase("true");		
	}
}
