package lab3aMyintW;

import java.util.Calendar;

/**
 * <p>
 * Title: Lab3a
 * </p>
 *
 * <p>
 * Description: parameterized constructor - sets dMonth, dDay, and dYear to user
 * specified value and verify the date input
 * </p>
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
public class Date {

	private int dMonth; // variable to store the month
	private int dDay; // variable to store the day
	private int dYear; // variable to store the year

	/**
	 * default constructor - sets dMonth=1, dDay=1, and dYear=1900
	 */
	public Date() {
		dMonth = 1;
		dDay = 1;
		dYear = 1900;
	}

	/**
	 * parameterized constructor - sets dMonth, dDay, and dYear to user specified
	 * values
	 * 
	 * @param month
	 *            value to be stored in dMonth
	 * @param day
	 *            value to be stored in dDay
	 * @param year
	 *            value to be stored in dYear
	 * @throws DateException
	 */
	public Date(int month, int day, int year) throws DateException {
		setMonth(month);
		setDay(day);
		setYear(year);
	}

	/**
	 * setDate - stores month, day, and year in dMonth, dDay, and dYear respectively
	 * be calling each of the setMethods defined
	 * 
	 * @param month
	 *            value to be stored in dMonth
	 * @param day
	 *            value to be stored in dDay
	 * @param year
	 *            value to be stored in dYear
	 * @throws DateException
	 */
	public void setDate(int month, int day, int year) throws DateException {
		setMonth(month);
		setDay(day);
		setYear(year);
	}

	/**
	 * setMonth - stores month in dMonth
	 * 
	 * @param month
	 *            the value to be stored in dMonth
	 */
	public void setMonth(int month) throws DateException {
		if (month >= 1 && month <= 12)
			dMonth = month;
		else
			throw new DateException("Invalid Month: month out of range. Range between 1-12");
	}

	/**
	 * setDay - stores day in dDay
	 * 
	 * @param day
	 *            the value to be stored in dDay
	 * @throws DateException
	 */
	public void setDay(int day) throws DateException {

		switch (this.dMonth) {
		case 1:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 2:
			if (day > 0)
				dDay = day;
			else if (day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range.");
			break;
		case 3:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 4:
			if (day <= 30 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-30");
			break;
		case 5:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 6:
			if (day <= 30 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-30");
			break;
		case 7:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 8:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 9:
			if (day <= 30 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-30");
			break;
		case 10:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		case 11:
			if (day <= 30 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-30");
			break;
		case 12:
			if (day <= 31 && day > 0)
				dDay = day;
			else
				throw new DateException("Invalid day: day out of range. Range between 1-31");
			break;
		}

	}

	/**
	 * setYear - stores year in dYear
	 * 
	 * @param year
	 *            the value to be stored in dYear
	 * @throws DateException
	 */
	public void setYear(int year) throws DateException {
		if (year >= 1752 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
			// leap year
			leapYear(year);
			dYear = year;
		} else {
			throw new DateException("Invalid year: year out of range. Range between 1752-Present");
		}
	}

	/**
	 * leapYear - check the day in leap year
	 * 
	 * @param year
	 *            the value to check the leap year
	 * @throws DateException
	 * 
	 */
	private void leapYear(int year) throws DateException {
		if (this.dMonth == 2 && (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) && this.dDay > 29)) {
			throw new DateException("Invalid day: day out of range and it is leap year. Range between 1-29 ");
		} else if (this.dMonth == 2 && (((year % 4 != 0) && (year % 100 == 0)) || (year % 400 != 0) && this.dDay > 28)) {
			throw new DateException("Invalid day: day out of range and it's not leap year. Range between 1-28");
		}

	}

	/**
	 * getMonth - accessor for dMonth
	 * 
	 * @return returns the value stored in dMonth
	 */
	public int getMonth() {
		return dMonth;
	}

	/**
	 * getDay - accessor for dDay
	 * 
	 * @return returns the value stored in dDay
	 */
	public int getDay() {
		return dDay;
	}

	/**
	 * getYear - accessor for dYear
	 * 
	 * @return returns the value stored in dYear
	 */
	public int getYear() {
		return dYear;
	}

	/**
	 * toString - returns the month, day, and year in the format: mm-dd-yyyy;
	 * leading zeros are NOT contained within the string
	 * 
	 * @return a String containing the date in month-day-year format
	 */
	public String toString() {
		return (dMonth + "-" + dDay + "-" + dYear);
	}
}
