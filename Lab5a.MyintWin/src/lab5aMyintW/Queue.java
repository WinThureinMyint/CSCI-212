package lab5aMyintW;

public class Queue<T> implements QueueADT<T> {
	private T[] data;
	private int size;
	private int head; // index # of the front of the queue
	private int tail; // index # of the back of the queue
	private static final int MAX_SIZE = 100;

	public Queue() {
		data = (T[]) new Object[MAX_SIZE];
		size = 0;
		head = 0;
		tail = 0;
	}

	public Queue(int size) {
		data = (T[]) new Object[size];
		size = 0;
		head = 0;
		tail = 0;
	}
	// public <T> deque(){
	// T[] x=(T[]) data[head];
	// head = (head+1) % data.length;
	// size--;
	// return x;
	// }

	public boolean isFull() {
		return size == data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(T d) throws QueueException {
		// enqueue -> return ((tail+1)%1/data.length) != 0; \\ head may be
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		if(isFull()) {
			throw new QueueException("Maximum number of items that can be stored is 100");
		}
		data[(tail+1)%data.length]=d;
		size++;
	}

	@Override
	public T dequeue() throws QueueException {
		
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		if(isFull()) {
			throw new QueueException("Maximum number of items that can be stored is 100");
		}
		T[] x = (T[]) data[head];
		head = (head + 1) % data.length;
		size--;
		return (T) x;
	}

	@Override
	public T front() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		if(isFull()) {
			throw new QueueException("Maximum number of items that can be stored is 100");
		}
		return data[head];
	}

	@Override
	public T rear() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		if(isFull()) {
			throw new QueueException("Maximum number of items that can be stored is 100");
		}
		return data[tail];
	}

	@Override
	public int getSize() {
		return size;
	}
}
