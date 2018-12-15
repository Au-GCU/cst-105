
// Jack Hall - CST-105 - This code was written by me for class.
import java.io.*;
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

		////////////////////////////////////////////////////////////////////////////////////////////
		// relative path for fileName only worked when compiling/running in console.              //
		// full path was required to make it work in IDE. I am still determining why.             //
		// String fileName = "C:\\Users\\jackv\\eclipse-workspace\\MyFirstProject\\bin\\abc.txt"; //
		////////////////////////////////////////////////////////////////////////////////////////////
		
		// I assume you are compiling this in console and running, so I will use the relative path
		String fileName = "input.txt";
		
		File file = new File(fileName);
		
		String sentence = null;

		try {
			// FileReader reads text files
			FileReader fileReader = new FileReader(file);

			// wrapping FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((sentence = bufferedReader.readLine()) != null) {

				// add space to end so that whiteSpace != -1 until end of sentence.
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

						// handling for if user enters a . to end sentence - this will remove it from
						// both the original word and the translated word.
						if (startString.indexOf(".") != -1) {
							startString = startString.substring(start, startString.indexOf("."));
							leadWord = leadWord.substring(start, leadWord.length() -1);
						}

						// display results in formatted, tabular form.
						System.out.print(leadWord);
						System.out.printf("%12s\n", startString.toUpperCase() + endString.toUpperCase());

						// reassign sentence.length
						sentenceLength = sentence.length();
					}
				} while (sentenceLength > 0);

			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}

	}

}
