package edu.westga.cs3211.collectibleManager.model;

import java.util.ArrayList;

/**
 * The Collection class.
 * 
 * @author Garrett Brenner
 * @version 1.0
 */
public class Collection {

	private ArrayList<Collectible> collection;
	
	/*
	 * the default constructor fro the Collection class
	 */
	public Collection() {
		this.collection = new ArrayList<Collectible>();
	}
	
	
	/*
	 * Gets the collection
	 */
	public ArrayList<Collectible> getCollection(){
		return this.collection;
	}
	
	/*
	 * Adds a Collectible to the collection
	 * 
	 * @precondition collectible != null
	 * @postcondition collection.size() = collection.Size + 1
	 * 
	 * @return weather collectibe has been added
	 */
	public boolean addCollectible(Collectible collectible) {
		return this.collection.add(collectible);
	}
	
	/*
	 * removes a collectible from the collection
	 * 
	 * @precondition collectible != null
	 * @postcondition collection.size() = collection.Size - 1 AND !this.collection.contains(collectible)
	 * 
	 * @return weather collectibe has been removed
	 */
	public boolean removeCollectible(Collectible collectible) {
		return this.collection.remove(collectible);
	}
}
