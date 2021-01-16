package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.GameDao;
import entity.Game;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in); 
	private GameDao gameDao = new GameDao(); 

	
	public void start() {
		boolean done = false; 
		
		while(!done) {
			printMenu(); 
			
			try {
				switch(scanIntValue("Enter a menu item: ")){
				case -1:
				done = true;
				break; 
				
				case 1:
					listBoardGames();
					break; 
				
				case 2:
					addBoardGame(); 
					break; 
				
				case 3:
					modifyBoardGameTime(); 
					break; 
				
				case 4: 
					deleteBoardGame(); 
					break; 
				
				default:
					System.out.println("Enter a value from 1 to 4!");
				break; 
				}		
			}
			
			catch(Exception e) {
				System.out.println("Error!" + e.toString());
				done = true; 		
			}	
		}
		System.out.println("Goodbye!");
	}

	private void deleteBoardGame() {
		System.out.println("You're deleting a Board Game!");
		int gameId = scanIntValue("Enter the Board Game ID:"); 
		
		gameDao.deleteBoardGame(gameId);
		System.out.println("You deleted a Board Game, hope you got some money for it.");
		
		
	}

	private void modifyBoardGameTime() {
		System.out.println("You're changing a Board Game's playtime");
		int gameId = scanIntValue("Enter the Board Game ID:"); 
		int playTime = scanIntValue("Enter the new play time:"); 
		
		gameDao.modifyGameTime(gameId, playTime);
		System.out.println("Board Game play time changed to: " + playTime);
		
	}

	private void addBoardGame() {
		System.out.println("You're adding a Board Game");
		String name = scanStringValue("Enter Board Game Name:");
		int minPlayers = scanIntValue("Minimum number of players:"); 
		int maxPlayers = scanIntValue("Maximum number of players:");
		int playTime = scanIntValue("Playtime(in minutes):");
		double difficultyRating =scanDoubleValue("Difficulty Rating:"); 
		String mechanism = scanStringValue("Mechanism:"); 
		
		gameDao.createBoardGame(name, minPlayers, maxPlayers, playTime, difficultyRating, mechanism); 
		
		System.out.println("You created a Board Game with name " + name + "\n minimum number of players: " + minPlayers
				+ "\n maximum number of players: " + maxPlayers + "\n Playtime of: " + playTime + "\n Difficulty Rating of: "
				+ difficultyRating + "\n and the mechanism is: " + mechanism);
		
	}

	private void listBoardGames() throws SQLException {
		System.out.println("Here are all the Board Games:");
		List<Game> games = gameDao.listAllGames();
		
		System.out.println();
		
		for(Game game : games) {
			System.out.println("   " + game.getGameId() + ": " + game.getName() + ": the playtime is "+ game.getPlayTime() + 
					" minutes, the max number of players is " + game.getMaxNumberPlayers()+ ", the difficulty rating is " + game.getDifficultyRating() + 
					", and it is a " + game.getMechanism() + " game.");
		}
		
		
	}

	private String scanStringValue(String message) {
			System.out.print(message);
			return scanner.nextLine(); 
		}
	
	private int scanIntValue(String message) {
			System.out.print(message);
			String value = scanner.nextLine(); 
		return Integer.parseInt(value); 
		}
		
	private double scanDoubleValue(String message) {
		System.out.print(message);
		String value = scanner.nextLine(); 
	return Double.parseDouble(value); 
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1) List all Board Games");
		System.out.println("2) Add a Board Game");
		System.out.println("3) Modify a Board Game's Playtime");
		System.out.println("4) Delete a Board Game");
		System.out.println("-1) to quit");
	}
	

}
