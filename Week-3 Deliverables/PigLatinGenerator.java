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

		// create scanner object
		Scanner input = new Scanner(System.in);

		// obtain input
		System.out.println("Enter sentence for translation to pig latin: ");
		String sentence = input.nextLine();

		// determine length to get end of sentence
		int sentenceEnd = sentence.length();
		System.out.println(sentenceEnd);
		
		// split apart works in String
		int whiteSpace = sentence.indexOf(' ');
		System.out.println(whiteSpace);

		while (whiteSpace != -1) {
			String normalWord = sentence.substring(0, whiteSpace);
			String restOfSentence = sentence.substring(whiteSpace);
			sentence = restOfSentence;
			whiteSpace = sentence.indexOf(' ');
			
			
			
			System.out.println("normalWord is " + normalWord);
			System.out.println("restOfSentence is " + normalWord);
			System.out.println("sentence is  " + normalWord);
			System.out.println(whiteSpace);
			
			break;
			
			/*for (int count = 0; count < sentence.length(); count++) {
				char vowel = Character.toUpperCase(normalWord.charAt(count));

				if (vowel == a || vowel == e || vowel == i || vowel == o || vowel == u) {

					firstVowel = count;
					break;

				}
			}

			if (start != firstVowel) {
				System.out.print(normalWord + "     ");
				String startString = normalWord.substring(firstVowel, sentenceEnd);
				String endString = normalWord.substring(start, firstVowel) + "ay";
				System.out.println(startString.toUpperCase() + endString.toUpperCase());
			}*/

		}

	}

}
