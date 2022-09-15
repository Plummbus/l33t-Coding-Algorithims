package Fundamentals;

import java.util.Arrays;

/***
 * @author Franz Jacob Hernandez
 * @since 09-15-2022
 * 
 * The cs fundamentals test for Coding Dojo.
 * 
 */

public class basic13 {

	
	public static void main(String[] args) {
		print1To255();
		printOdds1To255();
		printIntsAndSumTo255();
		printArrayVals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		printMaxOfArray(new int[] { 5, 3, 9, -3, 2, 10, 20, 1});
		printAverageOfArray(new int[] {1, 2, 3, 4, 5});
		returnOddsArray1To255();
		System.out.println(Arrays.toString(squareArrayValues(new int[] { 2, 4, 6, 8, 10 })));
		returnArrayCountGreaterThanY(new int[] { 2, 5, 7, 3, 1, 9 }, 6);
		System.out.println(Arrays.toString(zeroOutArrayNegativeVals(new int[] { -2, -4, 6, 8, -10 })));
		printMaxMinAverageArrayVals(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(Arrays.toString(shiftArrayValsLeft(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(replaceStringVals(new String[] { "Coding", "water", "basket", "coding" })));
	}

	//print all integers from 1 to 255
	public static void print1To255() {
		for (int i = 1; i < 256; i++) {
			System.out.println(i);
		}
	}
	
	//print all ODD integers from 1 to 255
	public static void printOdds1To255() {
		for (int i = 1; i < 256; i+=2) {
			System.out.println(i);
		}
	}
	
	//print all integers from 1 to 255, and print the sum so far with each integer
	public static void printIntsAndSumTo255() {
		int sum = 0;
		for (int i = 1; i < 256; i++) {
			sum += i;
			String message = String.format("Integer: %d; Sum so far: %d", i, sum);
			System.out.println(message);
		}
	}
	
	//iterate through an integer array, printing each value
	public static void printArrayVals(int[] arr) {
		for (int num : arr) {
			System.out.println(num);
		}
	}
	
	//given an integer array, print the max value
	public static void printMaxOfArray(int[] arr) {
		int max = 0;
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		
		System.out.println("Max value: " + max);
	}
	
	//given an integer array, print the average of the values of the array
	public static void printAverageOfArray(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		
		System.out.println("Average: " + sum / arr.length);
	}
	
	//create and return an array with all the ODD integers from 1 to 255
	public static void returnOddsArray1To255() {
		int size = (1 + 256) / 2;
		int[] arr = new int[size];
		int index = 0;
		for (int i = 1; i < 256; i+=2) {
			arr[index] = i;
			index++;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//square each value in a given array, returning the same area with modified values
	public static int[] squareArrayValues(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= arr[i];
		}
		
		return arr;
	}
	
	//given an array and value Y, count and print the number of array values greater than Y
	public static void returnArrayCountGreaterThanY(int[] arr, int y) {
		int count = 0;
		for (int num : arr) {
			if (num > y) {
				count++;
			}
		}
		
		System.out.println("Number of integers greater than " + y + ": " + count);
	}
	
	//return the given array, after setting any negative values to zero
	public static int[] zeroOutArrayNegativeVals(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				arr[i] = 0;
			}
		}
		
		return arr;
	}
	
	//given an array, print the max, min, and average values of that array
	public static void printMaxMinAverageArrayVals(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		int size = arr.length;
		int sum = 0;
		int average = 0;
		
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			sum += num;
		}
		
		average = sum / size;
		
		String message = String.format("Max: %d"
				+ "\nMin: %d"
				+ "\nAvg: %d", max, min, average);
		System.out.println(message);
	}
	
	//given an array, move all values forward (to the left) by one index,
	//dropping the first value and leaving a 0 value at the end of the array.
	public static int[] shiftArrayValsLeft(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length) {		//making sure we dont get an OutOfBounds exception
				arr[i] = arr[i + 1];
			} else {
				arr[i] = 0;
			}
		}
		
		return arr;
	}
	
	//give an array of strings, replace any "coding" strings with "dojo"
	public static String[] replaceStringVals(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equalsIgnoreCase("coding")) {
				arr[i] = "dojo";
			}
		}
		
		return arr;
	}
}






