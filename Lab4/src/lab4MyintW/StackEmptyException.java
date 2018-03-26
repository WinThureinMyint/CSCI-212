package lab4MyintW;
/**
 * <p>
 * Title: StackEmptyException Class
 * </p>
 * 
 * <p>
 * Description: Create a custom exception for Empty Stack
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author harrychan
 *
 */
public class StackEmptyException extends Exception {
	/**
	 * Constructs a new StackEmptyException with a default error message string.
	 */
	public StackEmptyException(){
		super("Exception : Stack is empty");
	}
	/**
	 * Constructs a new StackEmptyException with the parameter as the error message string.
	 * @param msg The string passed as the error message string.
	 */
	public StackEmptyException(String msg){
		super(msg);
	}
}