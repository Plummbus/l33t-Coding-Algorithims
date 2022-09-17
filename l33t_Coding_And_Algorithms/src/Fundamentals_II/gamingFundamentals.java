package Fundamentals_II;

import java.util.Random;

/***
 * @author Franz Jacob Hernandez
 * @since 09-16-2022
 * 
 * Ch 2 Fundamentals Part II, page 33 in the coursebook. These were from two larger, multi-part problems so I split it up into it's own file. 
 * The non-nested class methods are from one, the nested class methods are from the other.
 * 
 */

public class gamingFundamentals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(rollOne());
		playFives(10);
		playStatistics();
		playStatistics2();
		playStatistics3(100);
		playStatistics4(100);
		twentySided();
		
		claire.reset();
		claire.printClaire();
		claire.moveBy(5, 7);
		claire.printClaire();
		claire.moveBy(-10, 4);
		claire.printClaire();
	}
	
	
	//return an int between 1 and 6 (inclusive)
	public static int rollOne() {
		Random rand = new Random();
		return rand.nextInt(6) + 1; //nextInt(x) is exclusive
	}
	
	//call rollOne() NUM amount of times and print the return values to the console
	//if ever the return value is a 5, also print "That's good luck!"
	public static void playFives(int num) {
		for (int i = 0; i < num; i++) {
			int result = rollOne();
			
			String message = String.format("Dice result: %d", result);
			
			if (result == 5) {
				message += " That's good luck!";
			}
			System.out.println(message);
		}
	}
	
	//method should call rollOne() 8 times, but not print the results
	//after those 8 calls, print the lowest and highest values rolled
	public static int playStatistics() {
		int min = 6;	//initializing variables, can't be 0 or will mess up results, so picked the inverse of what they'll be evaluating
		int max = 1;
		int sum = 0;
		
		for (int i = 0; i < 8; i ++) {
			int result = rollOne();
			
			if (result < min) {
				min = result;
			}
			
			if (result > max) {
				max = result;
			}
			
			sum += result;
		}
		
		String message = String.format("After 8 dice rolls..."
				+ "\nMin: %d"
				+ "\nMax: %d", min, max);
		System.out.println(message);
		return sum;
	}
	
	//same concept of playStatistics(), but also print the sum of all the rolls at the end
	public static void playStatistics2() {
	//I just modified the originl method so I woudln't have to rewrite/copy a large section of code
	//made it so the original method returned an int(the sume) so I can call that within this method block
		int sum = playStatistics();
		System.out.println("The sum of the rolls is: " + sum);
	}
	
	//same concept as playStatistics2, but now set how many rolls you do with NUM
	public static void playStatistics3(int num) {
		int min = 6;	
		int max = 1;
		int sum = 0;
		
		for (int i = 0; i < num; i ++) {
			int result = rollOne();
			
			if (result < min) {
				min = result;
			}
			
			if (result > max) {
				max = result;
			}
			
			sum += result;
		}
		
		String message = String.format("After %d dice rolls..."
				+ "\nMin: %d"
				+ "\nMax: %d"
				+ "\nSum: %d", num, min, max, sum);
		System.out.println(message);
	}
	
	//same concept as playStatistics3, but instead of the sum show the average
	public static void playStatistics4(int num) {
		int min = 6;	
		int max = 1;
		int sum = 0;
		
		for (int i = 0; i < num; i ++) {
			int result = rollOne();
			
			if (result < min) {
				min = result;
			}
			
			if (result > max) {
				max = result;
			}
			
			sum += result;
		}
		
		int avg = sum / num;
		
		String message = String.format("After %d dice rolls..."
				+ "\nMin: %d"
				+ "\nMax: %d"
				+ "\nAvg: %d", num, min, max, avg);
		System.out.println(message);
	}
	
	//roll a twenty-sided die until the method gets 2 values in a row.
	//then print the statistics for number of rolls, min, max, avg, and sum of rolls thus far
	public static void twentySided() {
		
		boolean twoInARow = false;
		Random rand = new Random();
		int previousRoll = 0;
		int max = 1;
		int min = 20;
		int count = 0;
		int sum = 0;
		int avg = 0;
		
		while (!twoInARow) {			
			int result = rand.nextInt(20) + 1;
			
			if (result == previousRoll) {	//changing boolean flag
				twoInARow = true;
			}
			
			System.out.println(result);
			previousRoll = result;
			sum += result;
			count++;
			
			if (result > max) {
				max = result;
			}
			
			if (result < min) {
				min = result;
			}

		}
		
		avg = sum / count;
		
		String message = String.format("Last die value: %d"
				+ "\nNumber of rolls: %d"
				+ "\nMin: %d"
				+ "\nMax: %d"
				+ "\nSum: %d"
				+ "\nAvg: %d", 
				previousRoll, count, min, max, sum, avg);
		System.out.println(message);
	}
	
	//create 5 functions to map the movement of a wanderer
	class claire {
		
		private static int xCoord;
		private static int yCoord;
		
		public claire() {
			xCoord = 0;
			yCoord = 0;
		}
		
		//reset the coordinates of the claire instance to origin (0, 0)
		public static void reset() {
			xCoord = 0;
			yCoord = 0;
		}
		
		/**
		 * call this function to make claire move x/y amounts in x/y directions
		 * @param xOffset - distance along x axis
		 * @param yOffset - distance along y axis
		 */
		public static void moveBy(int xOffset, int yOffset) {
			//doing addition instead of just assigning here since claire might not be at origin when this is called.
			xCoord += xOffset;
			yCoord += yOffset; 
		}
		
		/**
		 * getter for xCoord
		 * @return xCoord
		 */
		public static int xLocation() {
			return xCoord;
		}
		
		/**
		 * getter for yCoord
		 * @return yCoord
		 */
		public static int yLocation() {
			return yCoord;
		}
		
		//return distance of line from origin to claire's coordinates
		//sqrt(x^2 + y^2
		public static double distFromHome()
		{
			double distance = Math.hypot(xCoord, yCoord);
			return distance;
		}
		
		public static void printClaire() {
			String message = String.format("Claire's xPosition: %d"
					+ "\nClaire's yPosition: %d"
					+ "\nCurrent distance from origin: %.3f", xCoord, yCoord, distFromHome());
			System.out.println(message);
		}
		
		
	}
}
