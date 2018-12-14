
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
		sentence = sentence + " ";

		// determine spaces in string
		int whiteSpace = sentence.indexOf(' ');

		// declare and initialize sentence length for use as while-loop condition
		int sentenceLength = sentence.length();

		do {

			// separate lead word from the remainder of sentence
			String leadWord = sentence.substring(0, whiteSpace);
			String restOfSentence = sentence.substring(whiteSpace + 1);

			// reassign the remainder of the sentence to sentence and get new position of
			// white space in new sentence.
			sentence = restOfSentence;
			whiteSpace = sentence.indexOf(' ');

			// loop that obtains position of first vowel encountered and then determines
			// length of word.
			for (int count = 0; count < leadWord.length(); count++) {
				char vowel = Character.toUpperCase(leadWord.charAt(count));

				if (vowel == a || vowel == e || vowel == i || vowel == o || vowel == u) {

					firstVowel = count;
					wordLength = leadWord.length();
					break;

				}
			}

			// convert to pig Latin section: first if handles words starting with vowels
			// else block handles all other words
			if (firstVowel == 0) {
				System.out.print(leadWord);
				System.out.printf("%13s\n", leadWord.toUpperCase() + "WAY");
			} else {
				// use position of first vowel obtained in for-loop to divide word appropriately
				String startString = leadWord.substring(firstVowel, wordLength);
				String endString = leadWord.substring(start, firstVowel) + "ay";

				// handling for if user enters a . to end sentence - this will remove it, but it
				// shifts formatted printf output by 1
				if (startString.indexOf(".") != -1) {
					startString = startString.substring(start, startString.indexOf("."));
				}

				// display results in formatted, tabular form.
				System.out.print(leadWord);
				System.out.printf("%12s\n", startString.toUpperCase() + endString.toUpperCase());

				// reassign sentence.length
				sentenceLength = sentence.length();
			}
		} while (sentenceLength > 0);

	}

}
