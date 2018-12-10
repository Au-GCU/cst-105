import java.util.Scanner;

public class RandomNumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		// Generate random number
		int randomNumber = (int) (Math.random() * 10000);

		// Set up guess index/counter

		int attempts = 0;

		// initialize guess and lastGuess as 0 to prevent compile error
		int guess = 0;
		int lastGuess = 0;
		
		// Initial prompt
		System.out.print("Enter a guess between 1 and 10000: ");
		
		
		// Conditional logic
		while (guess != randomNumber) {

			// Change prompt if other than initial prompt
			if (attempts > 0)
				System.out.print("Enter a guess between " + lastGuess + " and " + guess + " : ");
			
			// Accept user input for guess
			guess = input.nextInt();

			if ((guess >= 1) && (guess <= 10000)) {
				
				if (guess == randomNumber) {
					System.out.println("You WIN. It took you " + attempts + " tries.");
				} else if (guess > randomNumber) {
					System.out.println("LOWER");
				} else if (guess < randomNumber) {
					System.out.println("HIGHER");
				}
			} else {
				System.out.println("Invalid entry.");
			}
			attempts++;
			guess = lastGuess;
		}

	}

}
