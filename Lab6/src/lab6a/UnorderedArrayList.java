package lab6a;

public class UnorderedArrayList<T> extends ArrayList<T> {

	public UnorderedArrayList() {
		super(); // with this code or not it gonna call partent constructor
	}

	public UnorderedArrayList(int capacity) {
		super(capacity);
	}

	/**
	 * add method - adds an item to this list
	 * 
	 * @param insertItem
	 *            is a reference to the item to be added
	 * @return <i>true</i> if item was added, <i>false</i> otherwise
	 */
	@Override
	public boolean add(T insertItem) {
		// TODO Just add the item to the array
		if (isFull()) {
			return false;
		}
		data[size++] = insertItem;
		return true;
	}

	/**
	 * Returns the index of the first occurrence of the specified item (key) in this
	 * list
	 * 
	 * @param searchItem
	 *            is a reference to an item whose key-field has been initialized
	 * @return the location of the first occurrence of the specified item in this
	 *         list; if searchItem is not found, -1 is returned
	 */
	@Override
	public int indexOf(T searchItem) {
		for (int i = 0; i < size; i++) {
			if (searchItem.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified item (key) in this
	 * list
	 * 
	 * @param searchItem
	 *            is a reference to an item whose key-field has been initialized
	 * @return the location of the last occurrence of the specified item in this
	 *         list; if searchItem is not found, -1 is returned
	 */
	@Override
	public int lastIndexOf(T searchItem) {
		// TODO Auto-generated method stub
		int result = -1;
		for (int i = 0; i < size; i++) {
			if (searchItem.equals(data[i])) {
				result = i;
			}
		}
		return result;
	}

	/**
	 * contains method - determines whether or not the searchItem (key)is in this
	 * list
	 * 
	 * @param searchItem
	 *            is a reference to an item whose key-field has been initialized
	 * @return <i>true</i> if the item is in this list, <i>false</i> otherwise
	 */
	@Override
	public boolean contains(T searchItem) {

		if (indexOf(searchItem) == -1) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * get method - returns the item at the specified location in this list
	 * 
	 * @param index
	 *            is the index of the item in this list
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	@Override
	public T get(int index) {
		if (index >= 0 && index < size) {
			return data[index];
		}
		return null;
	}

	/**
	 * Removes the first occurrence of the specified item from this list, if it is
	 * present
	 * 
	 * @param removeItem
	 *            is a reference to an item whose key-field has been initialized
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	@Override
	public T remove(T removeItem) {
		// TODO
		T item;
		int index=indexOf(removeItem);
		if (index == -1) {
			return null;
		} else {
			item = data[index];
			for(int j=index;j<size-1;j++)
				data[j] = data[j+1];
			size--;
			return item;
		}
		// Find the removeItem in the array
		// return null if not found
		// First, Store the item found in a variable
		// shift the sequence element to the blank(adjust the array)
		// decrease size by 1
		// return the stored item

	}

	/**
	 * Removes the item at the specified location from this list, if it is present
	 * 
	 * @param index
	 *            is the index of the item in this list
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	@Override
	public T remove(int index) {
		// TODO check if index is withing the correct range
		// If not, return null
		// otherwise , do the same as above
		if (index >= 0 && index < size) {
			T item = data[index];
	    		for(int i=index;i<size-1;i++)
	    			data[i] = data[i+1];
	    		size--;
	    		return item;
		} else {
			return null;
		}

	}

}
