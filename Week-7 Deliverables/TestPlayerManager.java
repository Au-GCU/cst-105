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

		// display all players toString using this.playerList.get(i) in a for loop
		jack.displayPlayers();

		// do I hard code the values for the players? Randomly generate? 
		// main question is still whether I make the playerList ArrayList public/private
		// and/or static.
		// 
		
		

	}

}
