/**
 * 
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 * 
 *            This code was written by me for class - week 7.
 * @since 12-26-2018
 */
public class TestPlayerManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instantiate PlayerManager with the constructor that accepts args
		PlayerManager jack = new PlayerManager("Jack", "Lopes", 0);
		
		// method creates 8 players using a for loop and ArrayList.add
		jack.createPlayers();

		System.out.println(jack.toString());
		
		System.out.println();

		// display all players toString using this.playerList.get(i) in a for loop
		jack.displayPlayers();

		// change some values for the PlayerManager object using setters
		
		jack.setFullName("John Doe");
		jack.setTeamName("Eagles");
		jack.setSeedNumber(12);
		
		System.out.println();
		
		// call individual values using getters and display on console
		System.out.println("The Team Manager is " + jack.getFullName());
		System.out.println(jack.getFullName() + "'s team is the " + jack.getTeamName());
		System.out.println("Their seed number for the draft is " + jack.getSeedNumber());

		// get information on a specific players using getPlayer method
		System.out.println("\nThe stats for player 4 are as follows\n" + jack.getPlayer(4));
		System.out.println("\nThe stats for player 2 are as follows\n" + jack.getPlayer(2));
	}

}
