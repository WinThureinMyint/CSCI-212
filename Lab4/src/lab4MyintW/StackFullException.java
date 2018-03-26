package lab4MyintW;
/**
 * <p>
 * Title: StackFullException Calss
 * </p>
 * 
 * <p>
 * Description: Defines custom exception class for Full Stack Exception.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 * @version 0.9
 */
public class StackFullException extends RuntimeException {
	/**
	 * Constructs a new StackFullException with a default error message string.
	 */
	public StackFullException(){
		super("Exception : Stack is full");
	}
	/**
	 * Constructs a new StackFullException with the parameter as the error message string.
	 * @param msg The string passed as the error message string.
	 */
	public StackFullException(String msg){
		super(msg);
	}
}