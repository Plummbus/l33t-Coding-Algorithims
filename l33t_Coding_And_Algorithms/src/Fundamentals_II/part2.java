package Fundamentals_II;

import java.util.Arrays;
import java.util.Scanner;

/***
 * @author Franz Jacob Hernandez
 * @since 09-16-2022
 * 
 * Ch 2 Fundamentals Part II, pages 30 & page 31 in the coursebook. More modulo and recursion practice, no data structures yet. 
 * 
 */

public class part2 {

	public static void main(String[] args) {
		
		twelveBarBlues();
		
		System.out.println(fibonacci(0));	//should be 0
		System.out.println(fibonacci(1));	//should be 1
		System.out.println(fibonacci(2));	//should be 1
		System.out.println(fibonacci(3));	//should be 2
		System.out.println(fibonacci(4));	//should be 3
		System.out.println(fibonacci(5));	//should be 5
		System.out.println(fibonacci(6));	//should be 8
		
		System.out.println(sumToOne(928));	//should be 1
		System.out.println(sumToOne(1055603));	//should be 2
		
		clockHandAngles(3600);
		clockHandAngles(3980);
		
		isPrime(0);
		isPrime(1);
		isPrime(2);
		isPrime(3);
		isPrime(5);
		isPrime(6);
		isPrime(7);
		isPrime(21);
		isPrime(47);
		
		sweatshirtPricing();
	}
	
	//if X is an integer, print X then "chick" then "boom" then "chick".
	//repeat this process from 1 - 12.
	public static void twelveBarBlues() {
		for (int i = 1; i <= 12; i++) {
			String message = String.format("%d chick boom chick", i);
			System.out.println(message);
		}
	}
	
	//create a method that prints Fibonacci numbers.
	//it takes an integer as an argument, indicating what index of the Fibonacci sequence to stop at
	public static int fibonacci(int num) {
		//fibonacci should have 2 base cases:
		// 1) index 0 = 0
		// 2) index 1 = 1
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}
	
	//given an integer, sum the digits in that integer together until there is only 1 digit left.
	//then return that solo digit.
	//	ex. 928 -> 9 + 2 + 8 = 19 -> 1 + 9 = 10 -> 1 + 0 = 1, so 928 returns 1
	public static int sumToOne(int num) {
		/*
		 * TODO:
		 *  1) *check how many digits long the integer is (string-based, logarithmic, or multiplication approach)
		 *  2) separate out the digits (array split or modulo)
		 *  3) add digits together
		 *  4) check if condition is right. If not, repeat process
		 *  
		 *  *might not be neccessary to get length if we can just use modulo to pop of digits from the integer, but maybe still needed since we have to loop process multiple times
		 */
		int numCheck = num;	//create different variable in case I need to use an unmodified num value later
		boolean isSolo = false;
		
		while (!isSolo) {	//so numCheck is only 1 digit long
			
			int[] digitStorage = new int[String.valueOf(numCheck).length()];	//converting numCheck into a string to check length of string and create an array of that size to store the digits before addition
			int separator = numCheck;
			int i = 0;
			
			while (separator > 0) {
				digitStorage[i] = separator % 10;
				separator = separator / 10;
				i++;
			}
			
			//System.out.println(Arrays.toString(digitStorage));
			
			numCheck = 0; //resetting numCheck to 0 so we can add just the digits from digitStorage
			for (int x = 0; x < digitStorage.length; x++) {
				numCheck += digitStorage[x];
			}
			
			if (numCheck < 10) {
				isSolo = true;
			}
			
		}
		
		return numCheck;
	}
	
	//given an integer of seconds, print what the time equivalent would be in degrees on a clock
	//12:00:00 would be the starting position of all the hands.
	// ex 01:00:00 would be:
	// hour: 30 degrees. minutes: 0 degrees. seconds: 0 degrees.
	public static void clockHandAngles(int totalSeconds) {
		/*
		 * TODO:
		 *  1) convert seconds into appropriate hours, minutes, and seconds buckets
		 *  2) convert amount of each into the appropriate ammount of rotation degrees
		 */
		
		//60 seconds -> minute
		//60 minutes -> hour
		//3600 seconds -> hour
		
		int tempTime = totalSeconds;
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		hours = tempTime / 3600;
		tempTime = tempTime % 3600;
		
		minutes = tempTime / 360;
		tempTime = tempTime % 360;
		
		seconds = tempTime;	//should be whatever is left over
		
		//below was for testing
		/*
		String message = String.format("hours: %d"
				+ "\nminutes: %d"
				+ "\nseconds: %d", hours, minutes, seconds);
		System.out.println(message);
		*/
		
		//12 hours per rotation -> 30 degrees for 1 hour
		//both minute and seconds have 60 notches per rotation -> 6 degrees per minute/second
		
		hours *= 30;
		minutes *= 6;
		seconds *= 6;
		
		String message = String.format("hours: %d degrees"
				+ "\nminutes: %d degrees"
				+ "\nseconds: %d degrees", hours, minutes, seconds);
		System.out.println(message);
	}
	
	//print true or false if a given integer is prime
	public static void isPrime(int num) {
		//number is only prime if divisible by 1 and itself.
		//can check if prime if number is divisble by the base-most even and odd integers
		//granted that number is not already 2 or 3, since those are prime
		//need to have 2 and 3 base cases first so return gets hit before we check other numbers
		
		boolean prime = false;
		
		if (num == 1 || num == 0) {
			prime = false;
		} else if (num == 2 || num == 3) {
			prime = true;
		} else if (num % 2 == 0 || num % 3 == 0) {
			prime = false;
		} else {
			prime = true;	
		}
		
		String message = String.format("Is %d a prime number: %b", num, prime);
		System.out.println(message);
	}
	
	//given an integer COUNT, calculate the cost of ordering that many sweatshirts
	//sweatshirts costs $20. buying 2 gets a 9% discount, buying 3 gets a 19% discount, and buying 4+ gets a 35% discount.
	//the seller uses only cash, so round to the nearest dollar.
	public static void sweatshirtPricing() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a non-zero number: ");
		int count = sc.nextInt();
		
		double discount = 0;
		String discountPercentage = "";
		int price = 20;
		int total = 0;
		
		switch (count) {
		case 1:
			discount = 1;
			discountPercentage = "0%";
			break;
		case 2:
			discount = 0.91;
			discountPercentage = "9%";
			break;
		case 3:
			discount = 0.81;
			discountPercentage = "19%";
			break;
		default:				//default acting as 4+
			discount = 0.65;
			discountPercentage = "35%";
			break;
		}
		
		total = (int) Math.round((price * count) * discount);
		String message = String.format("Total number of sweatshirts: %d"
				+ "\nPrice per sweatshirt: $20"
				+ "\nDiscount: %s"
				+ "\nCost before Discount: $%d"
				+ "\nTotal Cost: $%d", count, discountPercentage, price * count, total);
		System.out.println(message);
	}

}
