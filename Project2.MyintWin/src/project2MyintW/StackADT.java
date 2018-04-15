package project2MyintW;



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
