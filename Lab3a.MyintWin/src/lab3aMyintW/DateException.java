package lab3aMyintW;
/**
 * <p>
 * Title: Lab3a
 * </p>
 *
 * <p>
 * Description: Create custom exception class for Date exception handling 
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
public class DateException extends Exception{
	public DateException() {
		super("Invalid value for Date");
	}
	public DateException(String message) {
		super(message);
	}
}
