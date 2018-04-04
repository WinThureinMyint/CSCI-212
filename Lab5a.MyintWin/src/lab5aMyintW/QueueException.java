package lab5aMyintW;
/**
 * <p>
 * Title: QueueException Class
 * </p>
 * 
 * <p>
 * Description: Create a custom exception for Empty Queue and Full Queue
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
public class QueueException extends Exception{
	/**
	 * Constructs a new QueueException with a default error message string.
	 */
	public QueueException(){
		super("Exception : Queue is wrong");
	}
	/**
	 * Constructs a new QueueException with the parameter as the error message string.
	 * @param msg The string passed as the error message string.
	 */
	public QueueException(String msg){
		super(msg);
	}
	/**
	 * Constructs a new QueueException with the parameter as the error message string and throwable cause.
	 * @param msg The string passed as the error message string.
	 * @param cause The Throwable passed as the error cause.
	 */
	public QueueException(String msg,Throwable cause){
		super(msg,cause);
	}
}
