/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 *            <p>
 *            This code was written by me for class - week 7.
 * @since 12-26-2018
 */
public class TestPlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instantiate player object without parameters [testing constructor 1]
		Player player1 = new Player();
		// utilize overwritten toString method
		System.out.println(player1.toString());

		// initialize some instance variables with setter methods
		player1.setFullname("John Doe");
		player1.setCollegeName("GCU");
		player1.setAge(23);
		player1.setPassingAttempts(600);
		player1.setPassingCompletions(450);

		// mutate some of these values with a mutator
		player1.setPlayer("James Doe", "NYU", "QB");

		// get some of these values with getter methods

		System.out.println("The player's name is " + player1.getPlayerName());
		System.out.println("The player's college is " + player1.getCollege());
		System.out.println("The player's position is " + player1.getPosition());

		// get output from one of the calculated methods
		System.out.println("The player's completion percentage is " + player1.getPercentageCompletions() + "%");

		System.out.println();
		System.out.println();
		System.out.println();

		// instantiate player object with parameters [testing constructor 2]
		Player player2 = new Player("Dwayne Johnson", "GCU", "RB", "Sophomore", 02, 225, 77, 23, 600, 425);

		// utilize overwritten toString method
		System.out.println(player2.toString());

		// reset some of the variables with setter methods
		player2.setCollegeYear("junior");
		player2.setAge(25);
		player2.setPosition("WR");

		// get some of the values with getter methods
		System.out.println("The player's name is " + player2.getPlayerName());
		System.out.println("The player's college year is " + player2.getCollegeYear());
		System.out.println("The player's age is " + player2.getAge());

		// get output from another calculated method
		System.out.println("The player's Body Mass Index is " + player2.getBodyMassIndex());
	}

}
