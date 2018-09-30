package list;

import jdk.jshell.spi.ExecutionControl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class List<T extends Comparable<T>> implements ListADT<T> {

	protected class Node<E extends Comparable<E>> {
		private E data;
		private Node<E> next;

		/**
		 * default constructor
		 */
		public Node() {
			data = null;
			next = null;
		}

		/**
		 * parameterized constructor with the item
		 * 
		 * @param item
		 */
		public Node(E item) {
			data = item;
			next = null;
		}

		/**
		 * parameterized constructor with the item and a reference to the next Node
		 * 
		 * @param item
		 * @param n
		 */
		public Node(E item, Node<E> n) {
			data = item;
			next = n;
		}

		/**
		 * sets (changes) the reference to the next Node
		 * 
		 * @param n
		 */
		public void setNext(Node<E> n) {
			next = n;
		}

		/**
		 * returns a reference to the next Node in the list
		 * 
		 * @return next
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * sets (changes) the data in the Node
		 * 
		 * @param item
		 */
		public void setData(E item) {
			data = item;
		}

		/**
		 * returns the data in the Node
		 * 
		 * @return data - the data in the node
		 */
		public E getData() {
			return data;
		}
	}

	public class ListIterator<E extends Comparable<E>> implements Iterator<E> {
		/**
		 * singly linked list used to store the contents of this list
		 */
		private Node<E> list;
		/**
		 * count the number of items in this list
		 */
		private int count;
		/**
		 * current the index of current item in the list
		 */
		private int current;

		/**
		 * Parameterized constructor for the ListIterator class.
		 * 
		 * @param d
		 *            the list
		 * @param c
		 *            the number of items in the list
		 */
		public ListIterator(Node<E> head, int c) {
			list = head;
			count = c;
			current = 0;
		}

		/**
		 * Returns <i>true</i> if there is another item in the list.
		 * 
		 * @return <i>true</i> if there is another item in the list
		 */
		public boolean hasNext() {
			return current < count;
		}

		/**
		 * Returns the next item in the list and advances to the next item.
		 * 
		 * @return the next item in the list
		 */
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E data = list.data;
			list = list.next;
			current++;
			return data;
		}

		/**
		 * This is a stub method. It does nothing
		 */
		public void remove() {
			/*
			 * does nothing add code if you need to delete while traversing
			 * http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
			 */
			list.next = null;
		}
	}

	protected Node<T> front = new Node<>();
	protected int size;

	@Override
	abstract public void add(T item);

	@Override
	public T first() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		ListIterator itr = new ListIterator(front, size);
		itr.next();
		T data = (T) itr.list.getData();
		return data;
	}

	@Override
	public T last() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		ListIterator itr = new ListIterator(front, size);
		while (itr.hasNext())
			itr.next();
		T data = (T) itr.list.getData();
		return data;
	}

	@Override
	public T removeFirst() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		Node<T> trav = front;
		T data = (T) trav.getData();
		front = trav.getNext();
		size--;
		return data;
	}

	@Override
	public T removeLast() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		ListIterator itr = new ListIterator(front, size);
		while (itr.hasNext())
			itr.next();
		T data = (T) itr.list.getData();
		itr.list.setNext(null);
		size--;
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeAtPosition(int location) throws IndexOutOfBoundsException {
		if (location > size)
			throw new IndexOutOfBoundsException();
		//this.front=this.front.next;
		ListIterator itr = new ListIterator(front, size);
		while (itr.current !=  location &&itr.hasNext() )
			itr.next();
		Node<T> data = itr.list;
		while (itr.hasNext() ) {
			T nextData = (T)itr.list.next.getData();
			itr.list.setData(nextData); 
			itr.next();
		}
		size--;
		
		//itr.list.setData(null);
		return data.getData();
	}

	@Override
	abstract public void remove(T item);

	@Override
	public void set(T item1, T item2) throws ListEmptyException {
		ListIterator itr = new ListIterator(front, size);
		while (itr.hasNext()) {
			if (itr.list.getData() == item1)
				itr.list.setData(item2);
			itr.next();
		}

	}

	@Override
	public T set(T item, int location) throws IndexOutOfBoundsException {
		if (location > size)
			throw new IndexOutOfBoundsException();
		ListIterator itr = new ListIterator(front, size);
		while (itr.hasNext() && itr.count != location)
			itr.next();
		T data = null;
		if (itr != null) {
			data = (T) itr.list.getData();
			itr.list.setData(item);
		}
		return data;
	}

	@Override
	abstract public int search(T item);

	@Override
	public boolean contains(T item) throws ListEmptyException {
		if (isEmpty())
			throw new ListEmptyException();
		return search(item) != -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		front.setNext(null);
		System.gc();
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(front.next, size);
	}

	public String toString() {
		String str = "[";
		Iterator<T> iter = iterator();
		while (iter.hasNext())
			str += iter.next() + (iter.hasNext() ? ", " : "]");
		return str;
	}
}
