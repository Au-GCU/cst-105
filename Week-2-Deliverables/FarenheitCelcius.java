//Jack Hall - CST-105 - This code was written by me.

import java.util.Scanner;
public class FarenheitCelcius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a degree in Fahrenheit: ");
		double fahrenheit1 = input.nextDouble();
		
		// Convert Fahrenheit to Celsius
		double celsius1 = (5.0 / 9) * (fahrenheit1 - 32);
		System.out.println("Fahrenheit " + fahrenheit1 + " is " + celsius1 + " in Celsius");
		
		System.out.print("Enter a degree in Celcius ");
		double celcius2 = input.nextDouble();
		
		// Convert Celsius to Fahrenheit
		double fahrenheit2 = celcius2 * (9.0 / 5) + 32;
		System.out.println("Celcius " + celcius2 + " is " + fahrenheit2 + " in Fahrenheit");
	}

}
