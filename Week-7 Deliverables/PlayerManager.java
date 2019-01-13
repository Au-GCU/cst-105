
/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 * <p>
 * This code was written by me for class - week 7.
 * @since 12-26-2018
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
	
	// method to get information on individual players with index number as parameter
	public Player getPlayer(int i) {
		Player player = this.playerList.get(i);
		return player;
	}


	/**
	 * createPlayers method that creates 8 new Player objects and stores them in the
	 * ArrayList playerList
	 */
	public void createPlayers() {
		this.playerList.add(new Player("Mitchell Trubisky","North Carolina","QB", "Senior", 10, 222, 75, 24, 289, 434));
		this.playerList.add(new Player("Darius Leonard","South Carolina State","OLB", "Junior", 53, 234, 74, 23, 254, 422));
		this.playerList.add(new Player("Marlon Mack","South Florida","RB", "Sophomore", 25, 210, 72, 22, 230, 401));
		this.playerList.add(new Player("Allen Robinson","Penn State","WR", "Senior", 12, 211, 75, 25, 201, 380));
		this.playerList.add(new Player("Adrian Amos","Penn State","SS", "Freshman", 38, 214, 72, 21, 290, 449));
		this.playerList.add(new Player("Melvin Ingram","South Carolina","DE", "Senior", 54, 247, 74, 29, 189, 310));
	}

	/**
	 * displayPlayers loops through player index numbers and performs .get method
	 */
	public void displayPlayers() {
		for (int i = 0; i < playerList.size(); i++)
			System.out.println(this.playerList.get(i));
	}

	// override the toString method and use @override annotation to force compiler
	// to ensure overridden method
	@Override
	public String toString() {
		return "PlayerManager [fullName=" + fullName + ", teamName=" + teamName + ", seedNumber=" + seedNumber
				+ ", number of players=" + playerList.size() + "]";
	}

}
