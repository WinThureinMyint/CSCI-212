package cs212lib;
/**
 * <p>
 * Title: Queue Class
 * </p>
 *
 * <p>
 * Description :A queue supports the insert and remove operations using a
 * first-in first-out (FIFO) discipline. By convention, we name the queue insert
 * operation enqueue and the remove operation dequeue.
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
public class Queue<T> implements QueueADT<T> {
	/**
	 * The array into which the objects of the queue are stored.
	 */
	private T[] data;
	/**
	 * The number of objects in this queue.
	 */
	private int size;
	/**
	 * index # of the front of the queue
	 */
	private int head; // index # of the front of the queue
	/**
	 * index # of the back of the queue
	 */
	private int tail; // index # of the back of the queue
	/**
	 * The default capacity of this queue.
	 */
	private static final int MAX_SIZE = 100;

	/**
	 * Constructs a new queue with capacity for 100 objects
	 */
	public Queue() {
		this.data = (T[]) new Object[MAX_SIZE];
		this.size = 0;
		this.head = 0;
		this.tail = -1;
	}

	/**
	 * Constructs a new queue with capacity specified by user
	 * 
	 * @param size
	 *            the size of the queue
	 */
	public Queue(int size) {
		this.data = (T[]) new Object[size];
		this.size = 0;
		this.head = 0;
		this.tail = -1;
	}

	/**
	 * Returns the number of objects on the queue.
	 * 
	 * @return The number of objects on the queue.
	 */
	public synchronized boolean isFull() {
		return (size == data.length);
	}

	/**
	 * Tests if this queue is full.
	 * 
	 * @return <i>true</i> if and only if this queue is full; <i>false</i>
	 *         otherwise.
	 */
	public synchronized boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Reset the data of queue to empty.
	 * 
	 * @throws QueueFullException - throw an exception when the queue is empty
	 */
	public synchronized void makeEmpty() throws QueueFullException {
		if (isEmpty())
			throw new QueueEmptyException("Queue is emptied.");
		this.size = 0;
		this.head = 0;
		this.tail = -1;

	}

	/**
	 * Add an object to the queue
	 * 
	 * @param d The object to be stored onto the Queue.
	 * @throws QueueFullException - if this Queue is full
	 */
	@Override
	public synchronized void enqueue(T d) throws QueueFullException {
		// enqueue -> return ((tail+1)%1/data.length) != 0; \\ head may be
		if (isFull()) {
			throw new QueueFullException("Maximum number of items that can be stored is " + data.length);
		} else {
			head = 0;
			data[(tail + 1) % data.length] = d;
			tail++;
			size++;
		}
	}

	/**
	 * Removes the object at the head of this queue.
	 * 
	 * @return The object at the head of the queue.
	 * @throws QueueFullException
	 *             - if this queue is empty
	 */
	@Override
	public synchronized T dequeue() throws QueueFullException {

		if (isEmpty()) {
			throw new QueueEmptyException("Queue is Empty");
		}
		T x = front();
		head = (head + 1) % data.length;
		size--;
		return x;
	}

	/**
	 * Returns the object at the head of this queue without removing it.
	 * 
	 * @return The object at the head of the queue.
	 * @throws QueueFullException
	 *             - if this queue is full
	 */
	@Override
	public synchronized T front() throws QueueFullException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is Empty");
		}

		return data[head];
	}

	/**
	 * Returns the object at the tail of this queue without removing it.
	 * 
	 * @return The object at the tail of the queue.
	 * @throws QueueFullException
	 *             - if this queue is full
	 */
	@Override
	public synchronized T rear() throws QueueFullException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is Empty");
		}

		return data[tail];
	}

	/**
	 * Returns the number of objects on the queue.
	 * 
	 * @return The number of objects on the queue.
	 */
	@Override
	public synchronized int getSize() {
		return size;
	}

	@Override
	public synchronized String toString() {
		if (isEmpty()) {
			return "Queue is Empty! Maximum number of items that can be stored is " + data.length;
		} else {

			String str = "The number of items in the queue is " + size + "\n--\n";

			// for (int i = head; i < ((tail + 1) % data.length); i++) {
			// str = str + "The Queue contains the following: " + data[i].toString() + "\n";
			// }
			for (int i = size - 1; i >= 0; i--) {
				str = str + "The Queue contains the following: " + data[i].toString() + "\n";
			}
			return str + "--\n";
		}

	}

}
