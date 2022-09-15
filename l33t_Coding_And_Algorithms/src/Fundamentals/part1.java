package Fundamentals;

import java.util.Scanner;

/***
 * @author Franz Jacob Hernandez
 * @since 09-14-2022
 * 
 * Basic exercises from the Chapter 1 Fundamentals - Part 1 of the Coding Dojo Algorithm Challenges book. Most exercises are printing strings to the console
 * using for/while loops. The book is written in Javascript, but I'll be writing everything in Java.
 * 
 */
public class part1 {

	
	public static void main(String[] args) {
		
		printFromNumberToNumber();
		beCheerful();
		multipleOfThreeKinda();
		printIntWhile();
		birthday(11, 5); //fail
		birthday(4, 6); //fail
		birthday(6, 11); //success
		leapYear(4);	//success
		leapYear(180);	//success
		leapYear(200);	//fail
		leapYear(433);	//fail
		leapYear(800);	//success
		printAndCount();
		multiplesOfSix();
		dojoCounting();
		oddAddition(); //should be 0
		countdownByFour();
		flexibleCountdown(20, 7, 5); //should print 20, 15, 10
		slightyLessFlexibleCountdown(3, 5, 17, 9); //should printer 6, 12, 15

	}
	
	//prints integers from -52 to 1066 using a FOR loop
	public static void printFromNumberToNumber() {
		for (int i = -52; i < 1067; i++) {
			System.out.println(i);
		}
	}
	
	//prints a string 98 times, can use whatever loop you want.
	public static void beCheerful() {
		int i = 98;
		while (i > 0) {
			System.out.println("good morning!");
			i--;
		}	
	}
	
	//prints multiples of 3 from -300 to 0, skipping -6 and -3.
	public static void multipleOfThreeKinda() {
		int i = -300;
		while (i < 1) {
			if (i != -3 && i != -6) {
				if (i % 3 == 0) {
					System.out.println(i);
				}
			}
		i++;
		}
	}
	
	//using a while loop, print integers from 2000 to 5280
	public static void printIntWhile() {
		int i = 2000;
		while (i < 5281) {
			System.out.println(i);
			i++;
		}
	}
	
	//if 2 given integers in either order represent your birthday and birth-month,
	//log "How did you know?", else log "Just another day...".
	//Birthday: 11(month), 6(day)
	public static void birthday(int a, int b) {
		int bdayValue = 17;
		String success = "How did you know?";
		String failure = "Just another day...";
		
		if (a + b == bdayValue) {
			System.out.println(success);
		} else {
			System.out.println(failure);
		}
	}
	
	//given a year, determine if it is a leap year.
	//leap year if divisible by 4
	//not a leap year if divisible by 100, unless also divisible by 400.
	public static void leapYear(int year) {
		String success = year + " is a leap year";
		String failure = year + " is NOT a leap year";
		
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 == 0) {
				System.out.println(success);
			} else if(year % 100 == 0 && year % 400 != 0) {
				System.out.println(failure);
			} else {
				System.out.println(success);
			}
		} else {
			System.out.println(failure);
		}
	}
	
	//print all integer multiples of 5 from 512 to 4096,
	//then print the count of how many there were
	public static void printAndCount() {
		int count = 0;
		for (int i = 512; i < 4097; i++) {
			if (i % 5 == 0) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println("Multiples of 5 from 512 to 4096: " + count);
	}
	
	//print multiples of 6 from 6 to 60,000, using a WHILE loop
	public static void multiplesOfSix() {
		int i = 6;
		while (i < 60001) {
			if (i % 6 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
	
	//print integers from 1 to 100.
	//if divisible by 5, instead print "Coding".
	//if divisible by 10, also print " Dojo".
	public static void dojoCounting() {
		for (int i = 0; i < 101; i++) {
			if (i % 5 == 0) {
				if (i % 10 == 0) {
					System.out.println("Coding Dojo");
				} else {
					System.out.println("Coding");
				}
			} else {
				System.out.println(i);
			}
		}
	}
	
	//print the sum of all odd integers from -300,000 to 300,000
	public static void oddAddition() {
		int sum = 0;
		int i = -300000;
		while (i < 300001) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("Sum: " + sum);
	}
	
	//starting at 2016, print integer multiples of four counting down to 0 (exclude 0).
	//do NOT using a FOR loop
	public static void countdownByFour() {
		int i = 2016;
		while (i > 0) {
			if (i % 4 == 0) {
				System.out.println(i);
			}
			i--;
		}
	}
	
	//given high, low, and multiple parameters, print a countdown of integers with the range of high and low, only printing multiples of the multiple given.
	public static void flexibleCountdown(int high, int low, int mult) {
		if (high < low) {	//basic error checking, making sure value ranges are correct
			int temp = high;
			high = low;
			low = temp;
		}
		
		for (int i = high; i >= low; i--) {
			if (i % mult == 0) {
				System.out.println(i);
			}
		}
	}
	
	//print multiples of param1, starting at param2 and extending to param3, skip any multiples that are equal to param4.
	//use a WHILE loop
	public static void slightyLessFlexibleCountdown(int param1, int param2, int param3, int param4) {
		int value = param2;
		while (value < param3 + 1) {
			if (value % param1 == 0 && value != param4) {
				System.out.println(value);
			}
			value++;
		}
		
	}
}
