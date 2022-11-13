/**
 * 
 */
package model;

/**
 * The Collector class
 * 
 * @author Garrett Brenner
 * @version 1.0
 */
public class Collector {

	private String userName;
	private Collection mainCollection;

	/*
	 * The default constructor for the collector class.
	 */
	public Collector() {
		this.userName = "";
		this.mainCollection = new Collection();
	}

	/*
	 * The single parameter constrctor for the collector class.
	 * 
	 * @precondition userName != null AND !username.isEmpty()
	 * 
	 * @postcondition this.userName = username
	 * 
	 * @param userName the ame of the user
	 */
	public Collector(String userName) {
		if (userName.isEmpty() || userName == null) {
			throw new IllegalArgumentException("Username can not be empty or null");
		}
		this.userName = userName;
		this.mainCollection = new Collection();
	}

	/**
	 * geths the users name
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * gets the users main collection
	 * 
	 * @return the mainCollection
	 */
	public Collection getMainCollection() {
		return this.mainCollection;
	}

}
