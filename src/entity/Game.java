package entity;


	public class Game {
		
		private int gameId; 
		private String name; 
		private int minNumberPlayers;
		private int maxNumberPlayers; 
		private int playTime; 
		private double difficultyRating; 
		private String mechanism; 
		
		public Game (int gameId, String name, int minNumberPlayers, int maxNumberPlayers, int playTime, 
				double difficultyRating, String mechanism ) {
			this.setGameId(gameId); 
			this.setName(name); 
			this.setMinNumberPlayers(minNumberPlayers);
			this.setMaxNumberPlayers(maxNumberPlayers);
			this.setPlayTime(playTime); 
			this.setDifficultyRating(difficultyRating); 
			this.setMechanism(mechanism); 
		}

		public int getGameId() {
			return gameId;
		}

		public void setGameId(int gameId) {
			this.gameId = gameId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getMinNumberPlayers() {
			return minNumberPlayers;
		}

		public void setMinNumberPlayers(int minNumberPlayers) {
			this.minNumberPlayers = minNumberPlayers;
		}
		
		public int getMaxNumberPlayers() {
			return maxNumberPlayers;
		}

		public void setMaxNumberPlayers(int maxNumberPlayers) {
			this.maxNumberPlayers = maxNumberPlayers;
		}
		public int getPlayTime() {
			return playTime;
		}

		public void setPlayTime(int playTime) {
			this.playTime = playTime;
		}

		public double getDifficultyRating() {
			return difficultyRating;
		}

		public void setDifficultyRating(double difficultyRating) {
			this.difficultyRating = difficultyRating;
		}

		public String getMechanism() {
			return mechanism;
		}

		public void setMechanism(String mechanism) {
			this.mechanism = mechanism;
		}
		

	}



