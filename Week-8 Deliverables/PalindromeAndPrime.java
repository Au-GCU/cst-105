/**
 * 
 * @author Jack Hall
 * @professor Amr Elchouemi
 * @course CST-105
 * @since 1-15-19 I completed this work for CST-105 class.
 */
public class PalindromeAndPrime {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;
		for (int i = 0; i < 100000; i++) {

			if (isPrime(i) && isPalindrome(i)) {
				System.out.printf("%12d", i);
				count++;
				if (count % 4 == 0 && i != 0)
					System.out.println();

			}
		}

	}

	/**
	 * Method to determine if a number is prime. Divides each number by each number
	 * before it, stopping when i <= n/2. If a divisor producing a remainder of 0 is
	 * found, returns false. Otherwise, if no divisor produces a remainder of 0,
	 * number is prime and method returns true.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {

		// ignore numbers before the first prime number
		if (n < 2)
			return false;

		for (int i = 2; i <= n / 2; i++) {

			if (n % i == 0)
				return false;
		}

		return true;
	}

	/**
	 * Method to determine if a number is palindrome. Calls reverse method to
	 * determined if number == to the reverse of number.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPalindrome(int number) {
		return (number == reverse(number));
	}

	/**
	 * Method to reverse the number digit by digit. Iterates through numbers and
	 * places the final digit of number as the first digit of reversed, and so on
	 * and so forth.
	 * 
	 * @param number
	 * @return
	 */
	public static int reverse(int number) {
		int reversed = 0;
		while (number > 0) {
			reversed = reversed * 10;
			reversed += number % 10;
			number = number / 10;
		}
		return reversed;
	}

}
