// Jack Hall - CST-105 - This code was written by me for class.

import java.util.Scanner;

public class PigLatinGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Specify vowels
		char a = 'A';
		char e = 'E';
		char i = 'I';
		char o = 'O';
		char u = 'U';

		// declare and initialize important variables
		int start = 0;
		int firstVowel = 0;
		int wordLength = 0;

		// create scanner object
		Scanner input = new Scanner(System.in);

		// obtain input
		System.out.println("Enter sentence for translation to pig latin: ");
		String sentence = input.nextLine();

		// determine spaces in string
		int whiteSpace = sentence.indexOf(' ');

		while (whiteSpace != -1) {
			
			// separate lead word from the remainder of sentence
			String leadWord = sentence.substring(0, whiteSpace);
			String restOfSentence = sentence.substring(whiteSpace + 1);
			
			// reassign the remainder of the sentence to sentence and get new position of white space in new sentence.
			sentence = restOfSentence;
			whiteSpace = sentence.indexOf(' ');
			
			
			// loop that obtains position of first vowel encountered and then determines length of word.
			for (int count = 0; count < leadWord.length(); count++) {
				char vowel = Character.toUpperCase(leadWord.charAt(count));

				if (vowel == a || vowel == e || vowel == i || vowel == o || vowel == u) {

					firstVowel = count;
					wordLength = leadWord.length();
					break;

				}
			}

			
			// use position of first vowel obtained in for-loop to divide word appropriately
			String startString = leadWord.substring(firstVowel, wordLength);
			String endString = leadWord.substring(start, firstVowel) + "ay";
			
			//display results in formatted, tabular form.
			System.out.print(leadWord + "         ");
			System.out.printf("%8s\n", startString.toUpperCase() + endString.toUpperCase());

		}

	}

}
