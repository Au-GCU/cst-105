
// Jack Hall - CST-105 - This code was written by me for class.

import java.util.Scanner;

public class RandomNumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		// Generate random number
		int randomNumber = (int) (Math.random() * 10000);

		// Set up guess index/counter

		int attempts = 1;

		// initialize values to prevent compile error because we don't assign them
		// "real" values until the selection statements
		int guess = 0;
		int lowGuess = 0;
		int highGuess = 10000;

		// Initial prompt
		System.out.print("Enter a guess between 1 and 10000: ");

		// Conditional logic
		while (guess != randomNumber) {

			/* Change prompt if other than initial prompt. This section also controls the
			   range of numbers in each prompt. */
			if (attempts > 1) {
				if (lowGuess == 0) {
					System.out.print("Enter a guess between " + (lowGuess + 1) + " and " + (highGuess - 1) + " : ");
				} else if (highGuess == 10000) {
					System.out.print("Enter a guess between " + (lowGuess + 1) + " and " + (highGuess) + " : ");
				} else if (lowGuess != 0 && highGuess != 10000) {
					System.out.print("Enter a guess between " + (lowGuess + 1) + " and " + (highGuess - 1) + " : ");
				} else {
					// nothing should be allowed to get to this point
				}
			}
			// Accept user input for guess
			guess = input.nextInt();

			// Checks to make sure user supplied value is within correct range
			if ((guess >= 1) && (guess <= 10000)) {

				// Logic around actual guesses
				if (guess == randomNumber) {
					System.out.println("You WIN. It took you " + attempts + " guesses.");
				} else if (guess > randomNumber) {
					System.out.println("LOWER");
				} else if (guess < randomNumber) {
					System.out.println("HIGHER");
				}

				// handle entries outside of the requested range
			} else {
				System.out.println("Invalid entry.");
			}

			// add to attempt counter (increment) after each attempt
			attempts++;

			// keep track of low and high guesses for use in subsequent prompts
			if (guess < randomNumber)
				lowGuess = guess;
			else
				highGuess = guess;

		}

	}

}
