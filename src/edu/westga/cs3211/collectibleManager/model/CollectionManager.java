package edu.westga.cs3211.collectibleManager.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectionManager {

	private static String user;
	private static Collection userCollection;

	/**
	 * Gets the name of the user
	 * 
	 * @return the user
	 */
	public static String getUser() {
		return user;
	}

	/**
	 * Authorizes user login
	 * 
	 * @param inputUsername inserted username
	 * @param inputPassword inserted password
	 * @return weather the user login was allowed or not
	 * @throws SQLException
	 */
	public static boolean authorize(String inputUsername, String inputPassword) throws SQLException {

		if (inputUsername == null || inputPassword == null) {
			return false;
		}

		String getUsers = "SELECT * FROM users";

		try (Connection connection = DataBaseManager.connectToDataBase()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(getUsers);

			while (result.next()) {
				user = result.getString("username");

				if (inputUsername.equals(user) && inputPassword.equals(result.getString("password"))) {
					userCollection = new Collection();

					return true;
				}
			}
		}
		return false;
	}

	/**
	 * gets teh users collection
	 * 
	 * @return the users collection
	 * @throws SQLException
	 */
	public static Collection getCollection() throws SQLException {
		
		if (userCollection.getCollection().size() != 0) {
			userCollection.clear();
		}
		
		String getCollectibles = "SELECT * FROM collectibles";
		
		try (Connection connection = DataBaseManager.connectToDataBase()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(getCollectibles);
			
			while (result.next()) {
				if(user.equals(result.getString("username"))){
					Collectible newCollectible = new Collectible(result.getString("name"), result.getString("condition"));
					userCollection.addCollectible(newCollectible);
				}
			}
		}
		return userCollection;
	}
	
	/**
	 * adds a collectible to the users collection
	 * 
	 * @param collectible the collectible to be added
	 * @throws SQLException
	 */
	public static void addCollectible(Collectible collectible) throws SQLException{
		if (userCollection.getCollection().size() != 0) {
			userCollection.clear();
		}
		
		String insert = "INSERT INTO Collectibles(userName, name, condition) values (?,?,?)";
		
		try(Connection connection = DataBaseManager.connectToDataBase()){
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, user);
			statement.setString(2, collectible.getName());
			statement.setString(3, collectible.getCondition());
			statement.executeUpdate();
		}
	}
}
