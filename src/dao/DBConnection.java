package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/board_game_database"; 
	private static final String USER_NAME = "root"; 
	private static final String PASSWORD = "TomKipVal8?"; 
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
		
	}

}
