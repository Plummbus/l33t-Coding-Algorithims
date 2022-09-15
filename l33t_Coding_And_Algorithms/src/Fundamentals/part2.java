package Fundamentals;

import java.util.Arrays;

/***
 * @author Franz Jacob Hernandez
 * @since 09-14-2022
 * 
 * Basic exercises from the Chapter 1 Fundamentals - Part 1 of the Coding Dojo Algorithm Challenges book. Most exercises are printing strings to the console
 * using for/while loops. The book is written in Javascript, but I'll be writing everything in Java.
 * 
 */

public class part2 {

	public static void main(String[] args) {
		countdownArray(5);		//should be 6
		System.out.println(printAndReturn(new int[] { 10, 20 }));	//this is in a print statement to test return value
		firstPlusLength(new int[] { 1, 2, 3, 4 });		//should be 5
		greaterThanSecond(new int[] { 1, 2, 3, 4, 5 });		//should be 3, 4, 5
		thisAndThat(6, 6);
		fitTheFirst(new int[] {1, 2, 3});	//should print "Too small!"
		fitTheFirst(new int[] {1});			//should print "Just right!"
		fitTheFirst(new int[] {3, 2});		//should print "Too big!"
		System.out.println(fToC(32));	//should be 0.0
		System.out.println(cToF(0.0)); 	//should be 32
	}
	
	//create an array with length equal to the integer passed. The array should have countdown to zero starting with the number given.
	//0th element is the argument, last element in array is 0. Print the array and its length (should be argument + 1);
	public static void countdownArray(int num) {
		int[] arr = new int [num + 1];	//need +1 since we have to include 0
		for (int i = 0; i < arr.length; i++) {
			arr[i] = num;
			num--;
		}
		System.out.println("Array length: " + arr.length);
		System.out.println(Arrays.toString(arr));
	}

	//given an array with 2 integers, print the first and return the second.
	public static int printAndReturn(int[] arr) {
		System.out.println(arr[0]);
		return arr[1];
	}
	
	//given an array, print the sum of the first index plus the array length
	public static void firstPlusLength(int[] arr) {
		int sum = arr[0] + arr.length;
		System.out.println("First index plus array length: " + sum);
	}
	
	//given an array, print all the values that are greater than the 2nd index value
	public static void greaterThanSecond(int[] arr) {
		
		int target = arr[1];
		System.out.println("Values greater than: " + target);
		for(int number : arr) {
			if (number > target) {
				System.out.println(number);
			}
		}
	}
	
	//given 2 integers as arguments, make an array of length equal to the first argument and with every index of value equal to the second argument.
	//if both arguments are the same number, also print "Jinx!"
	public static void thisAndThat(int a, int b) {
		if (a == b) {
			System.out.println("Jinx!!!");
		}
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = b;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//give an array, if the value of the first index is greater than the array length, print "Too big!".
	//if it is smaller than the array length, print "Too small!".
	//if it is equal to the length of the array, print "Just right!."
	public static void fitTheFirst(int[] arr) {
		if (arr[0] > arr.length) {
			System.out.println("Too big!");
		} else if (arr[0] < arr.length) {
			System.out.println("Too small!");
		} else {
			System.out.println("Just right!");
		}
	}
	
	//given an temperature in F (int), return the conversion to C (double)
	public static double fToC(int temp) {
		double conversion = ((double) temp - 32) * (5/9);
		return conversion; 
	}
	
	//given an temperature in C (double), return the conversion to F (int)
	public static int cToF(double temp) {
		int conversion = (int) (9/5 * temp) + 32;
		return conversion;
	}
}
