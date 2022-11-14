package edu.westga.cs3211.collectibleManager.model;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * class to manage data base connection
 */
public class DataBaseManager {

	private static final String DATABASE = "collectiblesDataBase.db";

	/**
	 * connects java to the database
	 * 
	 * @return the connection to the database
	 */
	public static Connection connectToDataBase() {

		String dbFile = System.getProperty("user.dir") + "\\sqlite\\" + DATABASE;

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/" + dbFile);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return connection;
	}
}
