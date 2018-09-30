package lab8MyintW;
/**
 * <p>
 * Title: Debugging
 * </p>
 * 
 * <p>
 * Description: Use the debugger to trace through the programs
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
public class Factorial {

	public static void main(String[] args) {
		int n = 20;
		int factorial = 1;
		
		int i = 1;
		while (i <= n) {
			factorial = factorial * i;
			i++;
		}
		System.out.println("The Factorial of " + n + " is " + factorial);
	}
}