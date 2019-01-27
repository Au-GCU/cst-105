
/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 * <p>
 * This code was written by me for class - week 7.
 * @since 01-10-2019
 */
import java.util.ArrayList;

public class PlayerManager {

	private String fullName;
	private String teamName;
	private int seedNumber;
	private ArrayList<Player> playerList = new ArrayList<>();

	/**
	 * @category constructors
	 * 
	 */
	public PlayerManager() {
		this(null, null, 0);
		// no-arg constructor implementation
	}

	public PlayerManager(String fullName, String teamName, int seedNumber) {
		this.fullName = fullName;
		this.teamName = teamName;
		this.seedNumber = seedNumber;
	}

	/**
	 * @category methods
	 */
	// mutator methods
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setSeedNumber(int seedNumber) {
		this.seedNumber = seedNumber;
	}

	// accessor methods
	public String getFullName() {
		return this.fullName;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public int getSeedNumber() {
		return this.seedNumber;
	}

	// method to get information on individual players with index number as
	// parameter
	public Player getPlayer(int i) {
		Player player = this.playerList.get(i);
		return player;
	}

	/**
	 * createPlayers method that creates 8 new Player objects and stores them in the
	 * ArrayList playerList
	 */
	public void createPlayers(String playerType) {
		if (playerType == "offensive") {
			this.playerList.add(new OffensivePlayer("Mitchell Trubisky", "North Carolina", "QB", "Senior", 10, 222, 75,
					24, 2, 280, 400, 22, 8, 3885));
			this.playerList.add(new OffensivePlayer("Darius Leonard", "South Carolina State", "OLB", "Junior", 53, 234,
					74, 23, 3, 254, 422, 22, 8, 3885));
			this.playerList.add(new OffensivePlayer("Marlon Mack", "South Florida", "RB", "Sophomore", 25, 210, 72, 22,
					1, 230, 401, 22, 8, 3885));
		} else if (playerType == "defensive") {
			this.playerList.add(new DefensivePlayer("Allen Robinson", "Penn State", "WR", "Senior", 12, 211, 75, 25, 3,
					163, 7, 4, 2));
			this.playerList.add(new DefensivePlayer("Adrian Amos", "Penn State", "SS", "Freshman", 38, 214, 72, 21, 4,
					168, 6, 3, 3));
			this.playerList.add(new DefensivePlayer("Melvin Ingram", "South Carolina", "DE", "Senior", 54, 247, 74, 29,
					5, 155, 9, 2, 4));
		} else if (playerType == "all") {
			this.playerList.add(new OffensivePlayer("Mitchell Trubisky", "North Carolina", "QB", "Senior", 10, 222, 75,
					24, 2, 280, 400, 22, 8, 3885));
			this.playerList.add(new OffensivePlayer("Darius Leonard", "South Carolina State", "OLB", "Junior", 53, 234,
					74, 23, 3, 254, 422, 22, 8, 3885));
			this.playerList.add(new OffensivePlayer("Marlon Mack", "South Florida", "RB", "Sophomore", 25, 210, 72, 22,
					1, 230, 401, 22, 8, 3885));
			this.playerList.add(new DefensivePlayer("Allen Robinson", "Penn State", "WR", "Senior", 12, 211, 75, 25, 9,
					163, 7, 4, 2));
			this.playerList.add(new DefensivePlayer("Adrian Amos", "Penn State", "SS", "Freshman", 38, 214, 72, 21, 4,
					168, 6, 3, 3));
			this.playerList.add(new DefensivePlayer("Melvin Ingram", "South Carolina", "DE", "Senior", 54, 247, 74, 29,
					3, 155, 9, 2, 4));
		} else {
			System.out.println("Invalid entry");
		}

	}

	/**
	 * displayPlayers loops through player index numbers and performs .get method
	 */
	public void displayPlayers() {
		for (int i = 0; i < playerList.size(); i++)
			System.out.println(this.playerList.get(i));
	}
	public int getPlayerListCount() {
		int playerListSize = playerList.size();
		return playerListSize;
	}

	// override the toString method and use @override annotation to force compiler
	// to ensure overridden method
	@Override
	public String toString() {
		return "PlayerManager [fullName=" + fullName + ", teamName=" + teamName + ", seedNumber=" + seedNumber
				+ ", number of players=" + playerList.size() + "]";
	}

}
