package Fundamentals_II;

/***
 * @author Franz Jacob Hernandez
 * @since 09-15-2022
 * 
 * Ch 2 Fundamentals Part II. Continuing concepts from Part I, just increased complexity. This is page 28 & page 29 in the coursebook
 * 
 */

public class part1 {

	public static void main(String[] args) {
		System.out.println(sigma(1));	//should be 1
		System.out.println(sigma(3));	//should be 6
		System.out.println(sigma(5));	//should be 15
		
		System.out.println(factorial(1));	//should be 1
		System.out.println(factorial(4));	//should be 24
		System.out.println(factorial(5));	//should be 120
		
		starArt.drawLeftStars(5);
		starArt.drawLeftStars(70);
		
		starArt.drawRightStars(10);
		starArt.drawRightStars(30);
		
		starArt.drawCenteredStars(35);
		starArt.drawCenteredStars(20);
		
		starArt.drawCharLeft(12, 'a');
		starArt.drawCharRight(26, '&');
		starArt.drawCharCenter(55, 'X');
		
		threesAndFives();
		betterThreesAndFives(1, 15);	//should be 45
		
		generateCoinChange(94);
		
		System.out.println(messyMath(4));		//should be 7
		System.out.println(messyMath(8));		//should be 40
		System.out.println(messyMath(15));		//should be -1
		

	}
	
	//given an integer, return the sum of all numbers up to that number (inclusive)
	public static int sigma(int num) {
		if (num > 0) {
			return num + sigma(num - 1);
		} else {
			return 0;
		}
	}
	
	//given a number, return the factorial of that number
	public static int factorial(int num) {
		if (num >= 2) {
			return num * factorial(num - 1);
		} else {
			return 1;
		}
	}
	
	//add values from 100 to 4,000,000 (inclusive) if that value is evenly divisble by 3 or 5 but not by both.
	//Display the final sum.
	public static void threesAndFives() {
		int sum = 0;
		
		for (int i = 100; i <= 4000000; i++) {
			if ((i % 3 == 0 && i % 5 != 0) || (i % 3 != 0 && i % 5 == 0)) {
				sum += i;
			}
		}
		
		System.out.println("Sum of method from 100 to 4M: " + sum);
	}
	
	//recreate threesAndFives() but let the user input the range values.
	public static void betterThreesAndFives(int start, int end) {
		int sum = 0;
		
		for (int i = start; i <= end; i++) {
			if ((i % 3 == 0 && i % 5 != 0) || (i % 3 != 0 && i % 5 == 0)) {
				sum += i;
			}
		}
		
		String message = String.format("Sum of method from %d to %d: %d", start, end, sum);
		System.out.println(message);
	}
	
	//enter an amount of cents up to 99 (inclusive) and print out the amount of American coins someone would receive as change.
	//make sure to use smallest quantity of coins possible.
	public static void generateCoinChange(int change) {
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int penny = 1;
		
		int remainingAmount = change;
		
		int quartersCount = 0;
		int dimesCount = 0;
		int nickelsCount = 0;
		int penniesCount = 0;
		
		quartersCount = remainingAmount / quarter;		//should round integer down. If quarter is too large, will just be 0;
		remainingAmount = remainingAmount % quarter;	//get remainder of change. If quarter too large, will just be whatever remainingAmount was.
		
		dimesCount = remainingAmount / dime;
		remainingAmount = remainingAmount % dime;		//another similar way would be to do remainingAmount = remainingAmount - (dimesCount * dime);
		
		nickelsCount = remainingAmount / nickel;
		remainingAmount = remainingAmount % nickel;
		
		penniesCount = remainingAmount;					//whatver will be left will be less than or equal to 4;
		
		String message = String.format("%d cents can be represented by:"
				+ "\n%9s %s"
				+ "\n%9s %s"
				+ "\n%9s %s"
				+ "\n%9s %s",
				change, "quarters:", quartersCount, "dimes:", dimesCount, "nickels:", nickelsCount, "pennies:", penniesCount);
		
		System.out.println(message);
		
	}
	
	/*
	 * return the sum of all integers from 0 to NUM, except for the following special cases:
	 * 1) if the current number is evenly divisible by 3, don't add the current number to the sum.
	 * 2) if the current number is evenly divisible by 7, add it TWICE to the sum. Let this rule override #1.
	 * 3) if the current number is 1/3 the NUM, return -1.
	 * 
	 * ex. 	num = 4 returns 7
	 * 		num = 8 returns 40
	 * 		num = 15 returns -1
	 */
	public static int messyMath(int num) {
		int sum = 0;
		for (int i = 0; i <= num; i++) {
			if (i % 3 == 0) {
				sum += 0;
			} else if (i % 7 == 0) {
				sum += (i * 2);
			} else if ((i * 10) == ((num * 10) / 3)) {	//multiply integers by 10 to get around rounding issue with dividing integers -> 22 / 3  7.3 which gets round to 7, but 220 / 3 = 73 which != 7 * 10
				return -1;
			} else {
				sum += i;
			}
		}
		
		return sum;
	}
	
	//all prints will be 75 characters long.
	//all "*" will be printed consecutively, followed up white spaces.
	//assume arguments won't have errors
	public class starArt {
		
		//given an integer, print that many "*", fill up the rest of the space with white spaces.
		//"*" will be printed left-justified
		public static void drawLeftStars(int num) {
			String message = "";
			
			for (int i = 0; i < 75; i ++) {
				if (i < num) {
					message += "*";
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for left-justified stars: " + message.length());
		}
		
		//given an integer, print that many "*", fill up the rest of the space with white spaces.
		//"*" will be printed right-justified
		public static void drawRightStars(int num) {
			String message = "";
			
			for (int i = 75; i > 0; i--) {
				if (i < num) {
					message += "*";
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for right-justified stars: " + message.length());
		}
		
		//given an integer, print that many "*", fill up the rest of the space with white spaces.
		//"*" will be printed center-justified
		public static void drawCenteredStars(int num) {
			String message = "";
			int whitespaces = (75 - num) / 2;
			
			for (int i = 0; i < 75; i++) {
				if (i < whitespaces) {
					message += "\s";
				} else if (i >= whitespaces && i < whitespaces + num) {
					message += "*";
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for centered-justified stars: " + message.length());
		}
		
		/*
		 * Re-create the past 3 methods, but allow the user to input their own character instead of "*".
		 * Assume the new character is also of length 1.
		 */
		
		public static void drawCharLeft(int num, char a) {
			String message = "";
			
			for (int i = 0; i < 75; i ++) {
				if (i < num) {
					message += a;
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for left-justified stars: " + message.length());
		}
		
		public static void drawCharRight(int num, char a) {
			String message = "";
			
			for (int i = 75; i > 0; i--) {
				if (i < num) {
					message += a;
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for right-justified stars: " + message.length());
		}

		public static void drawCharCenter(int num, char a) {
			String message = "";
			int whitespaces = (75 - num) / 2;
			
			for (int i = 0; i < 75; i++) {
				if (i < whitespaces) {
					message += "\s";
				} else if (i >= whitespaces && i < whitespaces + num) {
					message += a;
				} else {
					message += "\s";
				}
			}
			
			System.out.println(message
					+ "\nString length for centered-justified stars: " + message.length());
		}
	}

}
