package cs212lib;
/**
 * <p>
 * Title: QueueEmptyException Class
 * </p>
 * 
 * <p>
 * Description: Create a custom exception for Empty Queue 
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
public class QueueEmptyException extends RuntimeException{
	/**
	 * Constructs a new QueueException with a default error message string.
	 */
	public QueueEmptyException(){
		super("Exception : Queue is empty");
	}
	/**
	 * Constructs a new QueueException with the parameter as the error message string.
	 * @param msg The string passed as the error message string.
	 */
	public QueueEmptyException(String msg){
		super(msg);
	}
}
