package cs212lib;

/**
 * <p>
 * Title: StackADT class
 * </p>
 *
 * <p>
 * Description :This Stack class represents a last-in-first-out (LIFO) stack of objects.
 * The usual push and pop operations are provided, as well as a method to peek 
 * at the top item on the stack, and a method to test for whether the stack is empty.
 * When a stack is first created, it contains no items.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 *
 * <p>
 * College: Queens College
 * </p>
 *
 * @author Win Thurein Myint
 * @version 1.0
 */

public interface StackADT<T> {
	/**
	 * Pushes an object onto the top of this stack.
	 * 
	 * @param d
	 *            The object to be stored onto the stack.
	 * @throws StackFullException
	 *             - if this stack is full
	 */
	public void push(T d) throws StackFullException;
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T pop() throws StackEmptyException;
	/**
	 * Returns the object at the top of this stack without removing it.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T peek() throws StackEmptyException;
	/**
	 * Tests if this stack is full.
	 * @return <i>true</i> if and only if this stack is full; <i>false</i> otherwise.
	 */
	public boolean isFull();
	/**
	 * Tests if this stack is empty.
	 * @return <i>true</i> if and only if this stack is empty; <i>false</i> otherwise.
	 */
	public boolean isEmpty();
	/**
	 * Returns the number of objects on the stack.
	 * @return The number of objects on the stack.
	 */
	public int size();
}
