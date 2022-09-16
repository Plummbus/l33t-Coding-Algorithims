package Fundamentals_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/***
 * @author Franz Jacob Hernandez
 * @since 09-15-2022
 * 
 * Basic exercises from the Chapter 1 Fundamentals - Part 4 of the Coding Dojo Algorithm Challenges book. More array manipulation and for/while loop problems,
 * but now they're word problems.
 * 
 */

public class part4 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(shortenArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3)));	//should return [4, 5, 6]
		System.out.println(xIntercept(3, 4));	//should return -1
		badProbability();
		potentiallyEvenWorseProbability();
		compoundingSmartness(100);	//gonna get some ridiculously high IQ number
		letterGrade(97);
		letterGrade(55);
		letterGradeImproved(85);
		letterGradeImproved(72);
		letterGradeImproved(99);

	}
	
	//given an integer array and an integer X, remove all values from the array except the last X elements. Return that new, shortened array
	public static int[] shortenArray(int[] arr, int x) {
		int[] newArr = new int[x];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[arr.length - x + i];
		}
		
		return newArr;
	}
	
	//consider the math equation for find the x-intercept: Y = MX + B.
	//you are given coefficeints M and B, find X;
	public static double xIntercept(int m, int b) {
		//-b/m = X since Y should be 0
		return (-b) / m;
	}
	
	//for the last 100 days, 10 days had volcanic erruptions
	//15 days had tsunamis
	//20 days had earthquakes
	//25 days had blizzards
	//and 30 days had meteors.
	//write a method that will predict what will happen tomorrow using these probabiliies.
	public static void badProbability() {
		Random rand = new Random();
		int outcome = rand.nextInt(101);	//top end is exclusive, so this is 0 - 100
		String message = "Today's forecast is: ";
		
		if (0 <= outcome && outcome <= 10) {
			System.out.println(message + " volcanic erruptions");
		} else if (10 < outcome && outcome <= 25) {
			System.out.println(message + " tsunamis");
		} else if (25 < outcome && outcome <= 45) {
			System.out.println(message + " earthquakes");
		} else if (45 < outcome && outcome <= 70) {
			System.out.println(message + " blizzards");
		} else {
			System.out.println(message + " meteors");
		}
	}
	
	//same concept as previous method, except test each forecast independently.
	//so it's not guaranteed that something awful will happen today, but also it is possible to get all 5 events on one day.
	public static void potentiallyEvenWorseProbability() {
		Random rand = new Random();
		int outcome = rand.nextInt(101);	//top end is exclusive, so this is 0 - 100
		String message = "Today's forecast is:";
		
		ArrayList<String> todaysWeather =  new ArrayList<String>();
		
		if (0 <= outcome && outcome <= 10) {
			todaysWeather.add(" volcanic erruptions");
		}
		if (0 <= outcome && outcome <= 15) {
			todaysWeather.add(" tsunamis");
		}
		if (0 <= outcome && outcome <= 20) {
			todaysWeather.add(" earthquakes");
		}
		if (0 <= outcome && outcome <= 25) {
			todaysWeather.add(" blizzards");
		}
		if (0 <= outcome && outcome <= 30) {
			todaysWeather.add(" meteors");
		}
		if (31 <= outcome && outcome <= 100) {
			todaysWeather.add(" clear skies and warm");	//non-catastrophe option, for rolls from 31 to 100
		}
		
		for (int i = 0; i < todaysWeather.size(); i++) {
			if (i == todaysWeather.size() - 1 && todaysWeather.size() != 1) {
				message += " and";
			}
			message += todaysWeather.get(i);
			if (todaysWeather.size() >= 3 && i != todaysWeather.size() - 1) {
				message += ",";
			}
		}
		
		System.out.println(message);
	}
	
	//given a int that represents someone's IQ, return their final IQ after 14 weeks if they're IQ rose by 0.1 cummulatively each day.
	//+0.1 on 1st day, +0.2 on 2nd day, etc.
	public static void compoundingSmartness(int iq) {
		int days = 7 * 14;
		double baseIQmodifier = 0.1;
		double dailyIQchange = 0.1; 
		double finalIQ = iq;
		
		for (int i = 0; i < days; i++) {
			finalIQ += baseIQmodifier;
			baseIQmodifier += dailyIQchange;
		}
		
		String message = String.format("Starting IQ: %d"
				+ "\nFinal IQ: %.2f", iq, finalIQ);
		System.out.println(message);
		
	}
	
	//write a function that prints the score and letter grade a student receives.
	//90+: A
	//80-89: B
	//70-79: C
	//60-69: D
	//0-59: F
	public static void letterGrade(int score) {
		String grade = "";
		
		if (score <= 59) {
			grade += "F";
		} else if (60 <= score && score <= 69) {
			grade += "D";
		} else if (70 <= score && score <= 79) {
			grade += "C";
		} else if (80 <= score && score <= 89) {
			grade += "B";
		} else {
			grade += "A";
		}
		
		String message = String.format("Score: %d"
				+ "\nGrade: %s", score, grade);
		
		System.out.println(message);
	}
	
	//same concept as above, but put '+' and '-' for the high and low ends of each letter grade
	public static void letterGradeImproved(int score) {
		String grade = "";
		
		if (score <= 59) {
			grade += "F";
		} else if (60 <= score && score <= 69) {
			grade += "D";
			if (60 <= score && score <= 62) {
				grade += "-";
			}
			if (67 <= score && score <= 69) {
				grade += "+";
			}
		} else if (70 <= score && score <= 79) {
			grade += "C";
			if (70 <= score && score <= 72) {
				grade += "-";
			}
			if (77 <= score && score <= 79) {
				grade += "+";
			}
		} else if (80 <= score && score <= 89) {
			grade += "B";
			if (80 <= score && score <= 82) {
				grade += "-";
			}
			if (87 <= score && score <= 89) {
				grade += "+";
			}
		} else {
			grade += "A";
			if (90 <= score && score <= 92) {
				grade += "-";
			}
			if (97 <= score && score <= 100) {
				grade += "+";
			}
		}
		
		String message = String.format("Score: %d"
				+ "\nGrade: %s", score, grade);
		
		System.out.println(message);
	}

}
