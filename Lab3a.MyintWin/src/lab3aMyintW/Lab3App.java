package lab3aMyintW;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>
 * Title: Lab3a
 * </p>
 *
 * <p>
 * Description: Explore the use of System.in and validating input Explore
 * exception handling Create and use a programmer-defined exception class
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 *
 * <p>
 * Company: Queens College
 * </p>
 *
 * @author Win Thurein Myint
 * @version 1.0
 */
public class Lab3App {
	public static void main(String[] args) throws InputMismatchException, DateException {
		// Create a Scanner object
		Scanner scan = new Scanner(System.in);
		Date aDate;
		int month, day, year;
		boolean done = false;
		while (!done) {
			try {
				System.out.print("Enter the month as an integer: ");
				month = scan.nextInt();
				System.out.print("Enter the day as an integer: ");
				day = scan.nextInt();
				System.out.print("Enter the year as an integer:");
				year = scan.nextInt();
				aDate = new Date(month, day, year);
				done = true;
				System.out.print(aDate);
			}catch (InputMismatchException ime) {
				System.out.println("Invalid input entered. Enter an integer");
				scan.nextLine();
			}catch (DateException ex) {
				System.out.println("DateException: " + ex.getMessage());
			}
		}
	}
}
