package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Game;

public class GameDao {
	
	public void createBoardGame (String name, int minNumberPlayers, 
			int maxNumberPlayers, int playTime, double difficultyRating, String mechanism) {
		try (Connection connection = DBConnection.getConnection()) {
			String create = "INSERT INTO games (name, min_number_players, max_number_players, play_time, difficulty_rating, mechanism) VALUES (?,?,?,?,?,?)"; 
	
			try(PreparedStatement statement = connection.prepareStatement(create)) {
				statement.setString(1, name);
				statement.setInt(2, minNumberPlayers);
				statement.setInt(3, maxNumberPlayers);
				statement.setInt(4, playTime);
				statement.setDouble(5, difficultyRating);
				statement.setString(6, mechanism);
				statement.execute(); 
			}
				
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		} 
	}
	
	public List<Game> listAllGames() throws SQLException {
		try (Connection connection = DBConnection.getConnection()) {
		String select = "SELECT * FROM games"; 
		
		try(PreparedStatement statement = connection.prepareStatement(select)) {
			try(ResultSet rs = statement.executeQuery()) {
				List<Game> games = new ArrayList<>(); {
					while (rs.next()) {
						int gameId = rs.getInt("id"); 
						String name = rs.getString("name"); 
						int minNumberPlayers = rs.getInt("min_number_players"); 
						int maxNumberPlayers = rs.getInt("max_number_players");
						int playTime = rs.getInt("play_time"); 
						double difficultyRating = rs.getDouble("difficulty_rating"); 
						String mechanism = rs.getString("mechanism"); 
						
						Game game = new Game(gameId, name, minNumberPlayers, maxNumberPlayers, playTime, difficultyRating, mechanism); 
						games.add(game); 
				}
		return games; 
		}
			
	} catch (SQLException e) {
		throw new RuntimeException(e); 
	} 
		}
}
	}

	public void modifyGameTime(int gameId, int playTime) {
		try (Connection connection = DBConnection.getConnection()) {
			String update = "UPDATE games SET play_time=? WHERE id =?"; 
			
			try(PreparedStatement statement = connection.prepareStatement(update)) {
				statement.setInt(1, playTime);
				statement.setInt(2, gameId);
				
				statement.executeUpdate(); 
			}
			}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}

	public void deleteBoardGame(int gameId) {
		try (Connection connection = DBConnection.getConnection()) {
			String delete = "DELETE FROM games WHERE id =?"; 
			
			try(PreparedStatement statement = connection.prepareStatement(delete)) {
				statement.setInt(1, gameId);
				
				statement.executeUpdate(); 
			}
			}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}
		
	}		
		
}

	
		
		
		
		
		
		
		
		
		
	
