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

public class part3 {

	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(biggerSize(new int[] {-1, 0, 5, -4, 6, 10})));		//should be [-1, 0, 100, -4, 100, 100]
		System.out.println(Arrays.toString(previousLengths(new String[] { "word", "castle", "noodles", "tv" })));		//should be [4, 6, 7, 2]
		System.out.println("The highest value is: " + printLowReturnHigh(new int[] {-4, 7, 0, -10, 6, 9, 2}));		//should print -10 and 9
		System.out.println(Arrays.toString(sevenArray(new int[] { 1, 2, 3, 4 })));		//should print [9, 10, 11]
		System.out.println("First odd integer: " + printOneReturnAnother(new int[] { 1, 2, 3, 4 }));		//should print 3 (2nd to last) and 1 (first odd)
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 2, 3, 4, 5, 6 })));		//should print [6, 5, 4, 3, 2, 1]
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 2, 3, 4, 5 })));		//should print [5, 4, 3, 2, 1], testing odd lengthed array
		System.out.println(Arrays.toString(doubleVision(new int[] { 1, 2, 3 })));		//should print [2, 4, 6]
		System.out.println(Arrays.toString(negativesOnly(new int[] { -1, 2, 3, 0, -5, 6 })));		//should print [-1, -2, -3, 0, -5, -6]
		System.out.println(Arrays.toString(countPositives(new int[] { -1, 1, 1, 1, -1, 1 })));		//should print [-1, 1, 1, 1, -1, 4]
		hungry(new String[] { "lava", "food", "milkshake", "food" });		//should print "yummy!" twice
		hungry(new String[] { "lava", "chicken", "milkshake", "spanner" });		//should print "I'm hungry"
		evenAndOdd(new int[] { 1, 2, 5, 3, 5, 6, 2, 4, 5});		//should print "that's odd!" followed by "even more so!"
		System.out.println(Arrays.toString(swapSomeIndicies(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })));		//should print [9, 2, 7, 4, 5, 6, 3, 8, 1]
		System.out.println(Arrays.toString(incrementOdds(new int[] { 1, 2, 3, 4, 5, 6 })));		//should print [2, 2, 4, 4, 6, 6]
		System.out.println(Arrays.toString(multiplyArray(new int[] { 1, 2, 3, 4, 5 }, 3)));		//should print [3, 6, 9, 12, 15]
	}
	
	//given an array, change all positive integers into the integer 100
	public static int[] biggerSize(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				arr[i] = 100;
			}
		}
		
		return arr;
	}
	
	//given an array of Strings, return an int[] with each index containing the length of the string at that index
	public static int[] previousLengths(String[] arr) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i].length();
		}
		
		return intArr;
	}
	
	//given an integer array, print the lowest value and return the highest value
	public static int printLowReturnHigh(int[] arr) {
		int min = 0;
		int max = 0;
		for (int num : arr) {
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		
		System.out.println("The lowest value is: " + min);
		return max;
	}
	
	//given an integer array, return a new one that does NOT have the first index and adds 7 to every index.
	//do NOT modify the original array
	public static int[] sevenArray(int[] arr) {
		int[] newArr = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {	//starting at 1 to skip over first index
			newArr[i - 1] = arr[i] + 7;
		}
		return newArr;
	}
	
	//give an integer array, print the 2nd-to-last index and return the first odd value.
	public static int printOneReturnAnother(int[] arr) {
		System.out.println("Second to last index: " + arr[arr.length - 2]);
		
		boolean targetFound = false;
		int i = 0;
		while (!targetFound) {
			if (arr[i] % 2 != 0) {
				targetFound = true;
			} else {
				i++;
			}
		}
		
		return arr[i];
	}
	
	//given an integer array, reverse the values and return the same array.
	public static int[] reverseArray(int[] arr) {
		int midpoint = arr.length / 2;
		
		for (int i = 0; i <= midpoint; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		
		return arr;
	}
	
	//given an integer array, return a new array where all the values have been doubled
	public static int[] doubleVision(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i] * 2;
		}
		
		return newArr;
	}
	
	//given an integer array, return a new array with all values negative from old array(not just * -1 to all values)
	public static int[] negativesOnly(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				newArr[i] = arr[i];
			} else {
				newArr[i] = arr[i] * -1;
			}
		}
		
		return newArr;
	}
	
	//given array of integers, count the number of positive integers in array and replace last index with that count.
	//then return that array.
	public static int[] countPositives(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num > 0) {
				count++;
			}
		}
		
		arr[arr.length - 1] = count;
		return arr;
	}
	
	//given a String array, print "yummy" each time an index is of value "food".
	//If "food" is never found, print "I'm hungry".
	public static void hungry(String[] arr) {
		String target = "food";
		String success = "yummy!";
		String failure = "I'm hungry";
		boolean foodFound = false;
		for (String val : arr) {
			if (target.equalsIgnoreCase(val)) {
				System.out.println(success);
				foodFound = true;
			}
		}
		
		if (!foodFound) {
			System.out.println(failure);
		}
	}
	
	//given an integer array, everytime it has 3 odd values in a row, print "that's odd!.
	//everytime is has 3 evens in a row, print "even more so!".
	public static void evenAndOdd(int[] arr) {
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i] % 2 != 0) {
				if (i + 1 < arr.length && i + 2 < arr.length) {	//checking that next target value is not out-of-bounds. too many nested if-statements though, this could probably be written better
					if (arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {	//all conditions met for odd values
						System.out.println("that's odd!");
					}
				}
			} else {
				if (i + 1 < arr.length && i + 2 < arr.length) {
					if (arr[i + 1] % 2 == 0 && arr[i + 2] % 2 == 0) {
						System.out.println("even more so!");
					}
				}
			}
		}
	}
	
	//given an integer array, swap the first and last indices, and swap the 3rd and 3rd-to-last indices.
	public static int[] swapSomeIndicies(int[] arr) {
		//don't need a loop since we are only always swapping these same 4 indices, regardless of array length.
		int temp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
		
		int temp2 = arr[2];
		arr[2] = arr[arr.length - 3];
		arr[arr.length - 3] = temp2;
		
		return arr;
	}
	
	//given an integer array, increment the odd values and return the array.
	public static int[] incrementOdds(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {				
				arr[i]++;
			}
		}
		
		return arr;
	}
	
	//given an integer arr and an integer, multiply each value in array by the integer and return that array
	public static int[] multiplyArray(int[] arr, int mult) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= mult;
		}
		
		return arr;
	}
	
}
