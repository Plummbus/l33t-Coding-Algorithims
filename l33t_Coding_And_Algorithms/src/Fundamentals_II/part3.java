package Fundamentals_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/***
 * @author Franz Jacob Hernandez
 * @since 09-16-2022
 * 
 * Ch 2 Fundamentals Part II, pages 32 & page 33 in the coursebook. More modulo and recursion practice, no data structures yet. 
 * 
 */


public class part3 {

	public static void main(String[] args) {
		
		System.out.println(extractDigit(1824, 0));
		System.out.println(extractDigit(-1824, 3));
		System.out.println(extractDigit(1824, 10));
		
		mostSignificantDigit(-91232.978126000000123);	//should return 9
		mostSignificantDigit(0.000000196000000123);		//should return 1
		
	}
	
	//given 2 integers, return the numeral value of the second integer from within the first integer
	// ex (1824, 0) returns the numeral value of the integer in the ones place within 1824 -> 4.
	//ones place will be 0, tens places will be 1, hundreds place will be 2, etc.
	//if the value that you are searching for does not exist within the first integer, return 0.
	public static int extractDigit(int num, int digitNum) {
		
		//extract all the digits, count up how many, and put them into an array of that size
		//flip the array around since integers will enter in backwards
		//if digitNum is greater than count, return 0.
		//if not, return that digit - 1 from the array for the value
		if (num < 0) {
			num *= - 1;	//flipping signs for negatives
		}
		
		int temp = num;
		List<Integer> intList = new ArrayList<Integer>();	//using lists and arraylist since i'm lazy
		while (temp > 0) {
			intList.add(temp % 10);
			temp = temp / 10;
		}
		if (digitNum > intList.size() - 1) {
			return 0;	//because they're trying to look for a place value that is outside the range of the current integer
		} else {
			return intList.get(digitNum);
		}
	}
	
	//given a double, print the most significant digit of that double(left-most digit).
	//account for negative values as well.
	public static void mostSignificantDigit(double num) {
		int modifier = 10;
		int sigDig = 0;
		
		if (num < 0) {
			num *= -1;	//flip signs if negative
		}
		
		if (num >= 1) {
			while (num >= 10) {
				num = num / 10;
			}
		} else {
			while (num <= 1) {//keep multiplying num by 10 until it's at least greater than or equal to 1
				num = num * modifier;
			}
		}
		
		sigDig = (int) num;	//casting from double to int truncates
		System.out.println(sigDig);
			
	}

}
