package edu.westga.cs3211.collectibleManager.model;

/**
 * The collectible class
 * 
 * @author Garrett Brenner
 * @version 1.0
 */

public class Collectible {

	private String name;
	private String condition;

	/**
	 * Default constructor for the collectible class.
	 */
	public Collectible() {
		this.name = "";
		this.condition = "";
	}

	/**
	 * two param constructor for the Collectible class.
	 * 
	 * @precondition name != null AND !name.isEmpty() AND condition != null AND
	 *               !condition.isEmpty()
	 * @postcondition this.name = name AND this.condition = condition
	 * 
	 * @param name      The name of the collectible
	 * @param condition the condition of the collectible
	 */
	public Collectible(String name, String condition) {
		if (name.isEmpty() || name == null) {
			throw new IllegalArgumentException("Name can not be empty.");
		}
		if (condition.isEmpty() || condition == null) {
			throw new IllegalArgumentException("Condition can not be empty.");
		}

		this.name = name;
		this.condition = condition;
	}

	/**
	 * returns the name of the collectible
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * gets the condition of te collectible
	 * @return the condition
	 */
	public String getCondition() {
		return this.condition;
	}
}
