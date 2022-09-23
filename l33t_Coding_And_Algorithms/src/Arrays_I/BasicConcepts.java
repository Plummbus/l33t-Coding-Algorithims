package Arrays_I;

import java.util.Arrays;

public class BasicConcepts {

	public static void main(String[] args) {
		int[] testArr = new int[] {1, 2, 3, 4, 5};
		int[] newTestArr = pushFront(testArr, 0);
		System.out.println(Arrays.toString(newTestArr));
		System.out.println(newTestArr.length);
		newTestArr = insertAt(newTestArr, 10, 3);
		
		System.out.println(Arrays.toString(newTestArr));
		
		int[] swapArray = new int[] {2, 4, 6, 8, 10};
		swapPairs(swapArray);
		System.out.println(Arrays.toString(swapArray));
	
		int[] dupArray = new int[] {0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 6, 6};
		int[] distArray = removeDuplicates(dupArray);
		System.out.println(Arrays.toString(distArray));
		
		int[] unsortedArray = new int[] {78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
		sortArray(unsortedArray);
		System.out.println(Arrays.toString(unsortedArray));
		
		int[] reverseArray = new int[] {10, 11, 12, 13, 14};
		reverse(reverseArray);
		System.out.println(Arrays.toString(reverseArray));
		
	}
	

	
	/**
	 * Given an array and a value, inserts that value to the front of the array.
	 * @param arr - an int array
	 * @param val - int value user wants in arr[0]
	 * @return newArr - the new array with the value passed as the first index followed by the rest of the passed array.
	 * 
	 */
	public static int[] pushFront(int[] arr, int val) {
		int[] newArr = new int[arr.length + 1];
		newArr[0] = val;
		for (int i = 0; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}
		
		return newArr;
	}
	
	/**
	 * Given an integer array, an integer value, and an integer index, returns a new array
	 * with the value at the specified index, with the rest of the array indicies filled in with the values
	 * in order from the passed array. Values will be shifted indicies in new array if the passed value displaces them.
	 * @param arr - an integer array
	 * @param value - an integer value
	 * @param index - the index where the value is to be placed
	 * @return newArr - the old array with the value at the specified index, possibly with some values shifted over
	 */
	public static int[] insertAt(int[] arr, int value, int index) {
		if (index > 0 || index < arr.length - 1) {
			int[] newArr = new int[arr.length + 1];
			for (int i = 0; i <= arr.length; i++) {	//need less than or equal to since we're looking for arr[i - 1] post passed index integer.
				if (i == index) {
					newArr[i] = value;
				} else  if (i < index) {
					newArr[i] = arr[i];
				} else {
					newArr[i] = arr[i - 1];
				}
			}
			return newArr;
		} else {
			return null;
		}
	}
	
	/**
	 * Swaps the position of successive pairs in an integer array. If the length of the array is odd, the last element in the array does not get moved.
	 * @param array - an integer array
	 */
	public static void swapPairs(int[] array) {
		for (int i = 0; i < array.length; i+=2) {
			if (i + 1 < array.length) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
	}
	
	/**
	 * Takes a sorted array and returns a new array without duplicates.
	 * @param array - an integer array
	 * @return
	 */
	public static int[] removeDuplicates(int[] array) {
		//this would be the easy way:
		//return Arrays.stream(array).distinct().toArray();

		//less easy way and without built-in methods
		//1) go through and count how many distinct
		int current = array[0];
		String temp = "";
		boolean isFound = false;
		
		for (int i = 0; i < array.length; i++) {
			if (current != array[i]) {
				temp += array[i] + ",";
				current = array[i];
			}
		}
		
		String[] stringArray = temp.split(",");
		int[] finalArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			finalArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		return finalArray;
	}
	
	/**
	 * Given an array of integers, this method takes the lowest
	 * @param array - an integer array
	 */
	public static void sortArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array.length; x++) {
				int temp = 0;
				if (array[i] < array[x]) {
					temp = array[x];
					array[x] = array[i];
					array[i] = temp;
				}
			}
		}
	}
	
	/**
	 * Reverses the order of values of an integer array, in-place.
	 * @param array - an integer array
	 */
	public static void reverse(int[] array) {
		
		int temp = 0;
		
		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}
	
}
