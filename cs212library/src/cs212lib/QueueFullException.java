package cs212lib;
/**
 * <p>
 * Title: QueueFullException Class
 * </p>
 * 
 * <p>
 * Description: Create a custom exception for  Full Queue
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
public class QueueFullException extends RuntimeException{
	/**
	 * Constructs a new QueueException with a default error message string.
	 */
	public QueueFullException(){
		super("Exception : Queue is full");
	}
	/**
	 * Constructs a new QueueException with the parameter as the error message string.
	 * @param msg The string passed as the error message string.
	 */
	public QueueFullException(String msg){
		super(msg);
	}
}
