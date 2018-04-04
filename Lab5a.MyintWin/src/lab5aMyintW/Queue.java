package lab5aMyintW;

public class Queue<T> implements QueueADT<T> {
	private T[] data;
	private int size;
	private int head; // index # of the front of the queue
	private int tail; // index # of the back of the queue
	private static final int MAX_SIZE = 100;

	public Queue() {
		this.data = (T[]) new Object[MAX_SIZE];
		this.size = 0;
		this.head = 0;
		this.tail = -1;
	}

	public Queue(int size) {
		this.data = (T[]) new Object[size];
		this.size = 0;
		this.head = 0;
		this.tail = -1;
	}
	// public <T> deque(){
	// T[] x=(T[]) data[head];
	// head = (head+1) % data.length;
	// size--;
	// return x;
	// }

	public boolean isFull() {
		return (size == data.length);
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void makeEmpty() throws QueueException{
		if (isEmpty())
			throw new QueueException("Queue is emptied.");
		this.size = 0;
		this.head = 0;
		this.tail = -1;
			
	}

	@Override
	public void enqueue(T d) throws QueueException {
		// enqueue -> return ((tail+1)%1/data.length) != 0; \\ head may be
		if (isFull()) {
			throw new QueueException("Maximum number of items that can be stored is " + data.length);
		} else {
			head = 0;
			data[(tail + 1) % data.length] = d;
			tail++;
			size++;
		}
	}

	@Override
	public T dequeue() throws QueueException {

		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		T x = front();
		head = (head + 1) % data.length;
		size--;
		return x;
	}

	@Override
	public T front() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		}

		return data[head];
	}

	@Override
	public T rear() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		}

		return data[tail];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
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
