//Jack Hall - CST-105 - I wrote this code for Programming Exercise 2

import java.util.Scanner;

public class FiveDigitInteger {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a 5-digit positive integer: ");
		int input = in.nextInt();
		int sum = 0;

		System.out.print("The sum of the digits ");
		
		while (input > 0) {
			int add = input % 10;
			sum = sum + add;
			input = input / 10;
			System.out.print(add);
			if(input > 0) {
				System.out.print(" + ");
			}
			
		}
		System.out.print(" = " + sum);
	}

}
