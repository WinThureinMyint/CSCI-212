package lab5aMyintW;

/**
 * <p>
 * Title: QueueADT Class
 * </p>
 *
 * <p>
 * Description :A queue supports the insert and remove operations using a first-in first-out (FIFO) discipline. 
 * By convention, we name the queue insert operation enqueue and the remove operation dequeue.
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

public interface QueueADT<T> {
	/**
	 * Add an object to the queue
	 * 
	 * @param d The object to be stored onto the Queue.
	 * @throws QueueException - if this Queue is full
	 */
	void enqueue(T d) throws QueueException;
	/**
	 * Removes the object at the head of this queue.
	 * @return The object at the head of the queue.
	 * @throws QueueException - if this queue is empty
	 */
	T dequeue() throws QueueException;
	/**
	 * Returns the object at the head of this queue without removing it.
	 * @return The object at the head of the queue.
	 * @throws QueueException - if this queue is full
	 */
	T front() throws QueueException;
	/**
	 * Returns the object at the tail of this queue without removing it.
	 * @return The object at the tail of the queue.
	 * @throws QueueException - if this queue is full
	 */
	T rear() throws QueueException;
	/**
	 * Tests if this queue is empty.
	 * @return <i>true</i> if and only if this queue is empty; <i>false</i> otherwise.
	 */
	boolean isEmpty();
	/**
	 * Tests if this queue is full.
	 * @return <i>true</i> if and only if this queue is full; <i>false</i> otherwise.
	 */
	boolean isFull();
	/**
	 * Returns the number of objects on the queue.
	 * @return The number of objects on the queue.
	 */
	int getSize();
}
