package Fundamentals_II;

import java.util.Random;
import java.util.Scanner;


/***
 * @author Franz Jacob Hernandez
 * @since 09-16-2022
 * 
 * Ch 2 Fundamentals Part II, page 34 in the coursebook. This is one long program, a little different from the short exercises in previous pages. The program is a bunch of
 * helper methods for creating a calendar display in the console. The last method in the chain is puts them all (most) to use.
 * 
 */

public class desertedIsland {

	public static void main(String[] args) {
		
		System.out.println(weekdayName(2));
		weekdayName2(8);
		weekdayName2(14);
		weekdayName2(365);
		someDays();
		
		System.out.println(monthName(5));
		
		System.out.println(monthToDays(2));
		System.out.println(monthToDays(6));
		System.out.println(monthToDays(12));
	
		System.out.println(dayToMonth(40));
		
		fullDate();
	}
	
	/**
	 * Takes an int representation of a weekday (1-7) and prints out a string with the day
	 * @param day - integer representation of weekday
	 * @return message - string of weekday
	 */
	public static String weekdayName(int day) {
		String message = "";
		
		//added this section from weekdayName2 for the fullDate() method
		int dayOfWeek = day;
		if (day > 7) {
			dayOfWeek = dayOfWeek % 7;
			if (dayOfWeek == 0) {		//any Saturdays will come back as 0 instead of 7 since there is no remainder
				dayOfWeek = 7;
			}
		}
		
		switch (dayOfWeek) {
		case 1:
			message += "Sunday";
			break;
		case 2:
			message += "Monday";
			break;
		case 3:
			message += "Tuesday";
			break;
		case 4:
			message += "Wednesday";
			break;
		case 5:
			message += "Thursday";
			break;
		case 6:
			message += "Friday";
			break;
		case 7:
			message += "Saturday";
			break;
		default:
			break;
		}
		
		return message;
	}
	
	/**
	 * Same concept as previous method but expanded to take numbers from 1-365.
	 * Sunday is day 1. Print total number of days passed.
	 * @param day - integer representation of weekday
	 * @return actualDay - string of weekday
	 */
	public static String weekdayName2(int day) {
		int dayOfWeek = day;
		if (day > 7) {
			dayOfWeek = dayOfWeek % 7;
			if (dayOfWeek == 0) {		//any Saturdays will come back as 0 instead of 7 since there is no remainder
				dayOfWeek = 7;
			}
		}
		
		String actualDay = weekdayName(dayOfWeek);
		System.out.println(String.format("Day of Week: %s"
				+ "\nTotal Days Passed: %d", actualDay, day));
		return actualDay;
	}
	
	/**
	 * Calls weekdayName2 17 times, randomly generating arguments from 1-365.
	 * Prints different strings depending on weekday/end
	 */
	public static void someDays() {
		Random rand = new Random();
		for (int i = 0; i < 17; i++) {
			String message = "";
			String actualDay = weekdayName2(rand.nextInt(365) + 1);
			switch (actualDay) {	//since JDK7, can use a string in the expression of a switch statement
			case "Monday":
			case "Tuesday:":
			case "Wednesday":
			case "Thursday":
			case "Friday":
				message += "Work hard!";
				break;
			case "Saturday":
			case "Sunday":
				message += "Have a good day off!";
				break;
			default:
				break;
			}
			System.out.println(message);
		}
	}
	
	/**
	 * Method takes an integer from 1-12 and returns a String of that month of the year.
	 * One of the limitations for this method in the book was to do it without using any loops
	 * and you had to use an array.
	 * @param month - int representation of the month
	 * @return actualMonth - String representation of the month
	 */
	public static String monthName(int month) {
		String actualMonth = "";
		String[] months = {
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"
		};
		switch (month) {
		case 1:
			actualMonth += months[0];
			break;
		case 2:
			actualMonth += months[1];
			break;
		case 3:
			actualMonth += months[2];
			break;
		case 4:
			actualMonth += months[3];
			break;
		case 5:
			actualMonth += months[4];
			break;
		case 6:
			actualMonth += months[5];
			break;
		case 7:
			actualMonth += months[6];
			break;
		case 8:
			actualMonth += months[7];
			break;
		case 9:
			actualMonth += months[8];
			break;
		case 10:
			actualMonth += months[9];
			break;
		case 11:
			actualMonth += months[10];
			break;
		case 12:
			actualMonth += months[11];
			break;
		}
		
		return actualMonth;
	}
	
	/**
	 * Method takes a month in integer form and returns the number of days are in that month
	 * @param month - int representation of month of the year
	 * @return dayAmount - how many days (int) are in that month
	 */
	public static int monthToDays(int month) {
		/*
		 * 2022
		 * 28 days: February
		 * 30 days: April, June, September, November
		 * 31 days: Janurary, March, May, July, August, Octoober, December 
		 */
		int dayAmount = 0;
		switch (month) {
		case 2:					
			dayAmount += 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayAmount += 30;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dayAmount += 31;
			break;
		default:
			break;
		}
		
		return dayAmount;
	}
	
	/**
	 * Overloaded monthToDays(). Does the same thing but evaluates a String instead.
	 * @param month
	 * @return
	 */
	public static int monthToDays(String month) {
		/*
		 * 2022
		 * 28 days: February
		 * 30 days: April, June, September, November
		 * 31 days: Janurary, March, May, July, August, Octoober, December 
		 */
		int dayAmount = 0;
		switch (month) {
		case "February":					
			dayAmount += 28;
			break;
		case "April":
		case "June":
		case "September":
		case "November":
			dayAmount += 30;
			break;
		case "January":
		case "March":
		case "May":
		case "July":
		case "August":
		case "October":
		case "December":
			dayAmount += 31;
			break;
		default:
			break;
		}
		
		return dayAmount;
	}
	
	/**
	 * Takes in a int of the dayCount from the start of the year and returns a String of what month that day is in
	 * @param dayCount
	 * @return
	 */
	public static String dayToMonth(int dayCount) {
		//there must be a better way to do this, I might just be too tired
		if (dayCount >= 334) {
			return "December";
		} else if (dayCount >= 304) {
			return "November";
		} else if (dayCount >= 273) {
			return "October";
		} else if (dayCount >= 243) {
			return "September";
		} else if (dayCount >= 212) {
			return "August";
		} else if (dayCount >= 181) {
			return "July";
		} else if (dayCount >= 151) {
			return "June";
		} else if (dayCount >= 120) {
			return "May";
		} else if (dayCount >= 90) {	
			return "April";
		} else if (dayCount >=  60) {	
			return "March";
		} else if (dayCount >= 32) {	
			return "February";			
		} else {
			return "January";			
		}
	}
	
	/**
	 * Takes input from user and prints out a ful date (Weekday - Day - Month - Year)
	 */
	public static void fullDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What year is it?");
		int year = sc.nextInt();
		
		System.out.println("How many days are it from the start of the year?");
		int days = sc.nextInt();
		
		String month = dayToMonth(days);
		String weekday = weekdayName(days);
		
		int howManyDaysInMonth = monthToDays(month);
		int dayOfTheMonth = days % howManyDaysInMonth;
		
		String message = String.format("Today's date is:"
				+ "\n%s, the %sth of %s, %d", weekday, dayOfTheMonth, month, year);
		System.out.println(message);
		sc.close();
		
	}
	
	

}
